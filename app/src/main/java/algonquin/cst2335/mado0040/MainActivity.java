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

    ImageView imgView;
    Switch sw;
    Button login;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w( "MainActivity", "Any memory used by the application is freed." );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w( "MainActivity", "The application is no longer visible.\n" +
                "Normally an application will always be asleep in the background when it is not visible on screen. It's only when an app is removed from the system by the user that the last function is called." );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w( "MainActivity", "The application no longer responds to user input." );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w( "MainActivity", "The application is now responding to user input\n" +
                "After these 3 function calls, your application is up and running on the screen. When another application comes up on screen and your application disappears beneath, there are other functions that get called." );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w( "MainActivity", "The application is now visible on screen." );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w( "MainActivity", "In onCreate() - Loading Widgets" );

        imgView = findViewById(R.id.flagview);
        sw = findViewById(R.id.spin_switch);
        login = findViewById(R.id.loginButton);
        EditText email = findViewById(R.id.editTextTextEmailAddress);

        Intent nextPage = new Intent( MainActivity.this, SecondActivity.class);
        login.setOnClickListener( clk-> {
            nextPage.putExtra( "EmailAddress", email.getText().toString());
            startActivity(nextPage);
        } );

        sw.setOnCheckedChangeListener( (btn, isChecked) -> {
            if (isChecked)
            {
                RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(5000);
                rotate.setRepeatCount(Animation.INFINITE);
                rotate.setInterpolator(new LinearInterpolator());

                imgView.startAnimation(rotate);
                    }
            else {
                imgView.clearAnimation();
            }
                });
            }
        }