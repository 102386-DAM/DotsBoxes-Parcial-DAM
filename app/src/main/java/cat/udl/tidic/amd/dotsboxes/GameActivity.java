package cat.udl.tidic.amd.dotsboxes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cat.udl.tidic.amd.dotsboxes.viewmodels.GameViewModel;
import cat.udl.tidic.amd.dotsboxes.views.GameView;

public class GameActivity extends AppCompatActivity {

    protected GameView gameView;
    private  GameViewModel gameViewModel;
    TextView tv = findViewById(R.id.currentPlayerTV);



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initDataBinding();
        gameView = (GameView) findViewById(R.id.gameView);
        //
        gameView.setGameViewModel(gameViewModel,this);


    }


    public void getData(String data){
        // ERROR AQUI. NO RESOLT A CLASE CONSULTA EXAMEN.
        // HAURIA DACTUALITZAR TV AMB EL NOM etc...
        // tv.setText(data);

        Log.d("jugador actual: ", data);

    }

    //TODO
    private void initDataBinding() {
    }

    public void noValid(){
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        "la jugada no es valida", Toast.LENGTH_SHORT);

        toast1.show();
    }
    //
}