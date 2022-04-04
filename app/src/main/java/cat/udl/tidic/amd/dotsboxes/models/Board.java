package cat.udl.tidic.amd.dotsboxes.models;

import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import cat.udl.tidic.amd.dotsboxes.GameActivity;

public class Board {

    private  static String TAG = "Board";
    private int xMargin, yMargin,  xDistance,yDistance;
    private final List<Point> points;
    private final List<Square> squares;
    private final int M;
    private final int N;

    public Board(int m, int n) {
        M = m;
        N = n;
        this.points = new ArrayList<>();
        this.squares = new ArrayList<>();
    }

    public void setBoardDimensions(int xMargin, int yMargin, int xDistance, int yDistance) {
        this.xMargin = xMargin;
        this.yMargin = yMargin;
        this.xDistance = xDistance;
        this.yDistance = yDistance;
    }

    public void build() {

        // Build points
        int x=xMargin;
        for(int r=0; r < M; r++) {
            int y = yMargin;
            for (int c = 0; c < N; c++) {
                points.add(new Point(x, y));
                y = y + yDistance;
            }
            x = x + xDistance;
        }


        // Use the points to build squares
        int initColIndex = 0;
        int initRowIndex = 0;
        int initSquareIndex = 0;

        for (int i = 0; i < (M - 1) * (N - 1); i++) {
            Point P1 = points.get(initSquareIndex);
            Point P2 = points.get(initSquareIndex + 1);
            Point P3 = points.get(initSquareIndex + (N));
            Point P4 = points.get(initSquareIndex + (N + 1));
            this.squares.add(new Square(P1, P2, P3, P4));
            initSquareIndex = initSquareIndex + 1;
            initRowIndex = initRowIndex +1;

            if (initRowIndex == (N - 1)) {
                initRowIndex = 0;
                initColIndex = initColIndex + 1;
                initSquareIndex = initColIndex * (M);
            }
        }
    }

    public List<Square> getSquares() {
        return squares;
    }


    // TODO
    @RequiresApi(api = Build.VERSION_CODES.N)
    public MoveState isValidElection(Pair<Point,Point> line){
        MoveState moveState = new MoveState();
        AtomicBoolean isValid = new AtomicBoolean(true);

        //not valid move, same point
        if(line.first.equals(line.second)){
            moveState.isValid = !isValid.get();
            GameActivity.createToast("Seleccionat el mateix punt 2 cops");
            return moveState;
        }

        // Not a valid move -> The distance between PA and PB is greater than 1 or they points are in diagonal.

        int distx = Math.abs(line.first.x - line.second.x);
        int disty = Math.abs(line.first.y - line.second.y);
        if(distx >281 || disty>388 || disty + distx >388){
            moveState.isValid = !isValid.get();
            GameActivity.createToast("distancia major a 1 entre punts");
            return moveState;
        }

        // Not a valid move ->  The line is owned by the other player (Or me?)
        for (Square sq: squares) {
            for(Line l : sq.lines){
                if((l.PA.equals(line.first) && l.PB.equals(line.second)) ||
                        (l.PA.equals(line.second) && l.PB.equals(line.first))){
                    if (l.owner != null){
                        moveState.isValid = !isValid.get();

                        GameActivity.createToast("punts ja pintats");
                        return moveState;
                    }
                }
            }
        }

        moveState.isValid = isValid.get();
        return moveState;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean update(Player player){
        Line cl = new Line(player.election.first,player.election.second);
        AtomicBoolean squareIsCompleted = new AtomicBoolean();
        squareIsCompleted.set(false);
        squares.forEach( (Square square) -> {
            square.lines.forEach((Line l) -> {
                if (l.equals(cl)) {
                    l.owner = player;
                    if (square.isCompleted().get()) {
                        square.setOwner(player);
                        squareIsCompleted.set(true);
                    }
                }
            });
        });
        return squareIsCompleted.get();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Point getPoint(Point current){
        AtomicReference<Point> point = new AtomicReference<>();
        point.set(null);
        points.forEach((Point p) -> {
            // Check ->  needs to be a point of the board with
            // an accepted error around the threshold (30)
            if ( ((current.x <= p.x + 30 && current.x >= p.x - 30)
                    && (current.y <= p.y + 30 && current.y >= p.y - 30))
            ) {
                point.set(p);
            }
        });
        return point.get();
    }

}
