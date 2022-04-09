package cat.udl.tidic.amd.dotsboxes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import cat.udl.tidic.amd.dotsboxes.databinding.ActivityGameBinding;
import cat.udl.tidic.amd.dotsboxes.viewmodels.GameViewModel;
import cat.udl.tidic.amd.dotsboxes.views.GameView;

public class GameActivity extends AppCompatActivity {

    protected GameView gameView;
    private  GameViewModel gameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initDataBinding();
        gameView = (GameView) findViewById(R.id.gameView);
        //
        GameViewModel x = new ViewModelProvider(this).get(GameViewModel.class);
        x.setTW((TextView)findViewById(R.id.currentPlayerTV));
    }

    public void updateScore(String player) {
        TextView torn = (TextView)findViewById(R.id.currentPlayerTV);
        torn.setText(player);
    }

    public void updateScorePoints(int p1, int p2) {
        TextView p1tw = (TextView)findViewById(R.id.pointsP1TV);
        p1tw.setText(String.valueOf(p1));
        TextView p2tw = (TextView)findViewById(R.id.pointsP2TV);
        p2tw.setText(String.valueOf(p2));
    }

    public void checkScore(int p1, int p2) {
        if (p1 + p2 >= 9) {
            startActivity(new Intent(GameActivity.this, MainActivity.class));
            finish();
        }
    }

    //TODO
    private void initDataBinding() {
    }
    //
}