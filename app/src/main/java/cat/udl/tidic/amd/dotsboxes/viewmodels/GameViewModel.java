package cat.udl.tidic.amd.dotsboxes.viewmodels;

import android.graphics.Color;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cat.udl.tidic.amd.dotsboxes.models.Board;
import cat.udl.tidic.amd.dotsboxes.models.Game;
import cat.udl.tidic.amd.dotsboxes.models.Player;
import cat.udl.tidic.amd.dotsboxes.views.GameView;

// TODO
public class GameViewModel extends ViewModel {
    static int M=4;
    static int N=4;

    Game game;
    Board board;
    public void init() {
        //init board
        board = new Board(M,N);

        //init game
        game = new Game(board);
        game.playerRed = new Player("red Player", Color.RED);
        game.playerBlue = new Player("blue Player", Color.BLUE);
    }
    public Game getGame()  {
        return this.game;
    }


}
