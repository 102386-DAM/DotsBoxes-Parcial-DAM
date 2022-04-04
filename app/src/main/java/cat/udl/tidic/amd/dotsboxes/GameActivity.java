package cat.udl.tidic.amd.dotsboxes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import cat.udl.tidic.amd.dotsboxes.databinding.ActivityGameBinding;
import cat.udl.tidic.amd.dotsboxes.viewmodels.GameViewModel;
import cat.udl.tidic.amd.dotsboxes.views.GameView;

public class GameActivity extends AppCompatActivity {

    protected GameView gameView;
    private  GameViewModel gameViewModel;
    private  GameActivity gameActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

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
            score_player1.setText(squares);
        }
        else{
            TextView score_player2 = findViewById(R.id.pointsP2TV);
            score_player2.setText(squares);
        }
    }

    public void showToast(int error){
        if (error == 1) {
            Toast.makeText(gameActivity, "Not valid move -> PA must be different from PB", Toast.LENGTH_SHORT).show();
        } else if (error == 2) {
            Toast.makeText(gameActivity, "Not a valid move -> The distance between PA and PB is greater than 1 or they points are in diagonal.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(gameActivity, "Not a valid move ->  The line is owned by the other player", Toast.LENGTH_SHORT).show();
        }
    }
    //
}