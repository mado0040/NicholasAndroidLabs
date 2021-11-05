package algonquin.cst2335.mado0040;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Nicholas Madore
 * @version 1.0
 * @description This page holds the variables for textView, editText, and Button. It then holds
 *  functions to test that the users entered password is in a valid format. If it is not,
 *  it then returns false, giving the user a @toast message telling the user that their
 *  password is in invalid format or missing required characters.
 */

public class MainActivity extends AppCompatActivity {

    /**
     * This textView shows the feedback on the screen
     */
    TextView feedbackText;

    /**
     * This button shows the LOGIN on the screen
     */
    Button loginButton;

    /**
     * This editText allows the user to input a password
     */
    EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        feedbackText = findViewById(R.id.textView);
        passwordText = findViewById(R.id.editText);
        loginButton = findViewById(R.id.button);

        loginButton.setOnClickListener((click) -> {
            String password = passwordText.getText().toString(); // ""

            if (checkPasswordComplexity(password))
                feedbackText.setText("Your password is complex enough.");
            else if (!checkPasswordComplexity(password))
            feedbackText.setText("Your password is not complex enough!");
        });
    }

    /**
     * This function ensures that password has uppercase, lowercase, number, and special
     * character.
     *
     * @param password Non-null String of tge user typed in the editText.
     * @return True if all conditions are met, false if otherwise.
     */
    private boolean checkPasswordComplexity(@NonNull String password) {
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;

        //Start the loop
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            Log.i("Looking at char:", "" + c);
            if (Character.isLowerCase(c))
                foundLowerCase = true;
            if (Character.isUpperCase(c))
                foundUpperCase = true;
            if (Character.isDigit(c))
                foundNumber = true;
            if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }
        }
        /**
         * NOTE: I decided to use the setError with the drawable icon for all four because I like the
         * design of it better than a toast message.
         */
        if (!foundLowerCase) {
            passwordText.setError("Missing a lowercase letter!");
            return false;
        } else if (!foundSpecial) {
            passwordText.setError("Missing the special character!");
            return false;
        } else if (!foundUpperCase) {
            passwordText.setError("Missing an upercase letter!");
            return false;
        } else if (!foundNumber) {
            passwordText.setError("Missing a number!");
            return false;
        }

        //If anything is false, then it's not in the password;
        return foundLowerCase && foundSpecial && foundNumber && foundUpperCase;
    }
    /** This returns true if c is one of the #$%^&*!@? characters, false if otherwise.
     *
     * @param c The character that we are checking for a special character.
     * @return True if c is a special character (#$%^&*!@?), false if otherwise.
     */
    private boolean isSpecialCharacter ( char c){
        switch (c) {
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '!':
            case '@':
            case '?':
                return true;
            default:
                return false;
        }
    }
}