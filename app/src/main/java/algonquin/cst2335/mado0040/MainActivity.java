package algonquin.cst2335.mado0040;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w("MainActivity", "In onCreate() - Loading Widgets");

        EditText enterEmail = findViewById(R.id.enterEmail);

        EditText enterPassword = findViewById(R.id.enterPassword);

        Button login = findViewById(R.id.login);

        Intent nextPage = new Intent(MainActivity.this, SecondActivity.class);
        MainActivity.this.startActivity(nextPage);

        login.setOnClickListener(clk -> {
            nextPage.putExtra("EmailAddress", enterEmail.getText().toString());
            startActivity(nextPage);
        } );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w("MainActivity", "In onStart() - Application now visible on screen");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("MainActivity", "In onResume() - Application now responding to user input");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("MainActivity", "In onPause() - Application no longer responds to user input");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("MainActivity", "In onStop() - Application is no longer visible");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("MainActivity", "In onDestroy() - Memory used by application is freed");

    }
}