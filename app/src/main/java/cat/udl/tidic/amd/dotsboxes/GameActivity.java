package cat.udl.tidic.amd.dotsboxes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import cat.udl.tidic.amd.dotsboxes.databinding.ActivityGameBinding;
import cat.udl.tidic.amd.dotsboxes.models.Game;
import cat.udl.tidic.amd.dotsboxes.viewmodels.GameViewModel;
import cat.udl.tidic.amd.dotsboxes.views.GameView;

public class GameActivity extends AppCompatActivity {

    protected GameView gameView;
    public static GameActivity ga;
    private  GameViewModel gameViewModel;
    public static TextView currentPlayer;
    public static TextView scorePlayer1;
    public static TextView scorePlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initDataBinding();
        gameView = (GameView) findViewById(R.id.gameView);
        //
        ga = this;
        currentPlayer = (TextView) findViewById(R.id.currentPlayerTV);
        scorePlayer1 = (TextView) findViewById(R.id.pointsP1TV);
        scorePlayer2 = (TextView) findViewById(R.id.pointsP2TV);
    }

    //TODO
    private void initDataBinding() {
    }
    //

    public void restart(){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
    public static void createDialog(String winner){
        DialogFragment newFragment = RepeatDialogFragment.newInstance(winner);
        newFragment.show(ga.getSupportFragmentManager(), "dialog");
    }

    public static void intentChangeStart(){
        Intent intent = new Intent(ga.getBaseContext(), StartActivity.class);
        ga.startActivity(intent);
    }

    public static void createToast(String msg){
        Toast toast = Toast.makeText(GameActivity.currentPlayer.getContext(),
                msg,
                Toast.LENGTH_SHORT);

        toast.show();
    }
}