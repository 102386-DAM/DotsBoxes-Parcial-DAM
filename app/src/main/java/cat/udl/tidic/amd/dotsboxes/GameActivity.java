package cat.udl.tidic.amd.dotsboxes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import cat.udl.tidic.amd.dotsboxes.databinding.ActivityGameBinding;
import cat.udl.tidic.amd.dotsboxes.models.Player;
import cat.udl.tidic.amd.dotsboxes.viewmodels.GameViewModel;
import cat.udl.tidic.amd.dotsboxes.views.GameView;
import cat.udl.tidic.amd.dotsboxes.views.MainActivity;

public class GameActivity extends AppCompatActivity {

    protected GameView gameView;
    private  GameViewModel gameViewModel;
    private  GameActivity gameActivity;
    private MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameView = (GameView) findViewById(R.id.gameView);
        gameView.setGameViewModel(gameViewModel, this);
    }

    //TODO
    private void initDataBinding() {
    }

    public void changePlayer(String namePlayer){
        TextView actual_player = findViewById(R.id.currentPlayerTV);
        actual_player.setText(namePlayer);
    }

    public void updateScore(String name, int squares){
        if(name.equals("blue")){
            TextView score_player1 = findViewById(R.id.pointsP1TV);
            score_player1.setText(String.valueOf(squares));
        }
        else{
            TextView score_player2 = findViewById(R.id.pointsP2TV);
            score_player2.setText(String.valueOf(squares));
        }
    }

    public void checkEnd(int blue_squares, int red_squares){
        int total_squares = blue_squares + red_squares;
        if(total_squares >= 9){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

}