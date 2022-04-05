package com.example.androidprogrammingsemesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEntered;
    private EditText passwordEntered;
    private Button signIn;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEntered = (EditText) findViewById(R.id.emailAddressEditText);
        passwordEntered = (EditText) findViewById(R.id.passwordEditText);


    }


    public boolean correctCredentials(String password, String username){
        //password: 2022project, username: project@ucmo.edu
        final String hashedPass ="750DC409838C33F3B5FE0ED691B0328EEF39D739DD0814DD116B84EBF22862F8";
        final String correctUsername = "project@ucmo.edu";

        if (hashPassword(password).equals(hashedPass)&& username.equals(correctUsername))
            return true;
        else
            return false;
    }

    /* Functions hashes the password to check it against stored hash: I take zero credit for figuring
     out this function as I had found how to hash at stackoverflow*/
    public String hashPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte [] arr = messageDigest.digest(password.getBytes());
            StringBuffer stringBuffer = new StringBuffer();

            for (int x = 0; x < arr.length; x++){
                stringBuffer.append(Integer.toHexString((arr[x] & 0xFF) | 0x100).substring(1,3));
                return stringBuffer.toString();
            }
        }
        catch (NoSuchAlgorithmException e){ System.out.print(e);}
        return null;
    }
}