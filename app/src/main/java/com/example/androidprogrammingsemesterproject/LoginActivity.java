package com.example.androidprogrammingsemesterproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/*This activity handles the login and reset procedures of this app:
* 1. login password is hashed w/ sha256, then that along with the login
* are compared with correct values
* 2. reset button opens dialogue telling user to contact support for help*/
public class LoginActivity extends AppCompatActivity {
    private EditText usernameEntered;
    private EditText passwordEntered;
    private Button signIn;
    private Button reset;
    public static boolean loggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEntered = (EditText) findViewById(R.id.emailAddressEditText);
        passwordEntered = (EditText) findViewById(R.id.passwordEditText);
        signIn = (Button) findViewById(R.id.signInButton);
        reset = (Button) findViewById(R.id.resetButton);

        //If signIn button is clicked it attempts to login into HomeActivity
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEntered.getText().toString();
                String password = passwordEntered.getText().toString();
                if (correctCredentials(username, password)) {
                    loggedIn = true;
                    Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    usernameEntered.setText("");
                } else
                    Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_LONG).show();
                hideKeyboard(view);
                passwordEntered.setText("");

            }


        });

        //If user wants to reset his password, he will be told to contact his support
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(view);
                resetAlertDialogue();

            }
        });

    }


    /*Checks whether user has given valid credentials
     * Params: takes in strings username & password
     * Return: true if credentials are valid, false otherwise*/
    public boolean correctCredentials(String username, String password) {
        //password: 2022project, username: project@ucmo.edu
        final String hashedPass = "36a9e7f1c95b82ffb99743e0c5c4ce95d83c9a430aac59f84ef3cbfab6145068";
        final String correctUsername = " ";
        String userHashedEntry = hashPassword(password);

        if (userHashedEntry.equals(hashedPass) && username.equals(correctUsername))
            return true;
        else {
            System.out.println(userHashedEntry);
            return false;
        }
    }

    /* Functions hashes the password to check it against stored hash: I take zero credit for figuring
     out this function as I had found how to hash at stackoverflow*/
    public String hashPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] arr = messageDigest.digest(password.getBytes());
            StringBuffer stringBuffer = new StringBuffer();

            for (int x = 0; x < arr.length; x++) {
                stringBuffer.append(Integer.toHexString((arr[x] & 0xFF) | 0x100).substring(1, 3));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.print(e);
        }
        return null;
    }

    //opens dialogue telling user to contact support
    public void resetAlertDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Password Reset");
        builder.setMessage("Please email support@ucmo.edu");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        AlertDialog dialogue = builder.create();
        dialogue.show();
    }

    //inflates the actionbar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }

    //Depeding on the menu item selected on the actiobar, it goes to homepage
    //or it logs out user
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_home:
                if (loggedIn == true) {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    clearUserInput();
                    hideKeyboard(this);
                }

                break;
            case R.id.menu_logout:
                if(loggedIn) {
                    loggedIn = false;
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);

                }
                clearUserInput();
                hideKeyboard(this);

                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //clears the keyboard from focus
    public void hideKeyboard(View view){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(),0);

    }
    //clears the keyboard from focus but takes in activity
    public void hideKeyboard(Activity activity){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),0);

    }

    //clears username and appsword input
    public void clearUserInput(){
        passwordEntered.setText("");
        usernameEntered.setText("");
    }
}