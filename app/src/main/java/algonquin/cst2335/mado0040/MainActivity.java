package algonquin.cst2335.mado0040;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mytext=findViewById(R.id.textview);
        Button mybutton=findViewById(R.id.mybutton);
        EditText myedit = findViewById(R.id.myedittext);
        mybutton.setOnClickListener(    (View v) -> {  mytext.setText("Your edit text has: " + myedit.getText().toString());  }   );
        CheckBox mycheckbox=findViewById(R.id.mycheckbox);
        Switch myswitch=findViewById(R.id.myswitch);
        RadioButton myradiobutton=findViewById(R.id.myradiobutton);
        ImageView myimage=findViewById(R.id.logo_algonquin);
        ImageButton imgbtn=findViewById(R.id.myimagebutton);

        // Toast message with height and width for ImageButton
        imgbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View myimagebutton) {
                Toast.makeText(getApplicationContext(),
                        "The width=" + imgbtn.getMeasuredWidth() + " and height=" + imgbtn.getMeasuredHeight() , Toast.LENGTH_SHORT).show();

            }
        });

        // Toast message for CheckBox
        mycheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View mycheckbox) {
                Toast.makeText(getApplicationContext(),
                        "It is clear outside today!", Toast.LENGTH_SHORT).show();

            }
        });

        // Toast message for Switch
        myswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View myswitch) {
                Toast.makeText(getApplicationContext(),
                        "You are a gamer!", Toast.LENGTH_SHORT).show();

            }
        });

        // Toast message for RadioButton
        myradiobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View myradiobutton) {
                Toast.makeText(getApplicationContext(),
                        "You have seen the rain!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}