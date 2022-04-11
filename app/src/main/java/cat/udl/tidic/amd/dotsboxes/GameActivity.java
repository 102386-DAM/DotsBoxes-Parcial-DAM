package cat.udl.tidic.amd.dotsboxes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import cat.udl.tidic.amd.dotsboxes.databinding.ActivityGameBinding;
import cat.udl.tidic.amd.dotsboxes.models.Game;
import cat.udl.tidic.amd.dotsboxes.viewmodels.GameViewModel;
import cat.udl.tidic.amd.dotsboxes.views.GameView;

public class GameActivity extends AppCompatActivity {

    protected GameView gameView;
    private GameViewModel gameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initDataBinding();

    }

    public void update(Game game) {
        String currentPlayer = game.currentPlayer().getName();
        String tvp1 = Integer.toString(game.playerRed.getSquares());
        String tvp2 = Integer.toString(game.playerBlue.getSquares());
        TextView cPlayer = (TextView) findViewById(R.id.currentPlayerTV);
        cPlayer.setText(currentPlayer);
        TextView playerRed1 = (TextView) findViewById(R.id.pointsP1TV);
        playerRed1.setText(tvp1);
        TextView playerBlue2 = (TextView) findViewById(R.id.pointsP2TV);
        playerBlue2.setText(tvp2);
    }

    public void isEnded(Game game) {
        if ((game.playerRed.getSquares() + game.playerBlue.getSquares()) >= 9) {
            Intent mainActivity = new Intent(GameActivity.this, MainActivity.class);
            startActivity(mainActivity);
        }
    }

    //TODO
    private void initDataBinding() {
        gameViewModel = new GameViewModel();

        //gameView.setGameViewModel(gameViewModel, this);
    }
    //
}