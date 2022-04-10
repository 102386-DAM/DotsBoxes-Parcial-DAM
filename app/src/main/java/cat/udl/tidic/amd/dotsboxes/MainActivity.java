package cat.udl.tidic.amd.dotsboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.startButton);
        button.setOnClickListener(v -> {
            Intent gameActivity = new Intent(MainActivity.this, GameActivity.class);
            startActivity(gameActivity);
        });

    }
}