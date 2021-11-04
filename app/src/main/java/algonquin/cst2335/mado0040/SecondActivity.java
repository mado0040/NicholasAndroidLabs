package algonquin.cst2335.mado0040;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent fromPrevious = getIntent();
        String emailAddress = fromPrevious.getStringExtra("EmailAddress");
        TextView welcome = findViewById(R.id.textView);
        welcome.setText(emailAddress);

        EditText phoneNumber = findViewById(R.id.editTextPhone);
        Intent call = new Intent(Intent.ACTION_DIAL);
        callButton.setOnClickListener( clk-> {
            call.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(call);
        } );
    }
}