package com.whexberg.ribbit;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

public class PasswordResetActivity extends AppCompatActivity {

    protected EditText mEmail;
    protected Button mResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);


        mEmail = (EditText) findViewById(R.id.emailField);
        mResetButton = (Button) findViewById(R.id.resetButton);
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword( mEmail.getText().toString() );
            }
        });
    }

    public void resetPassword( String email) {

        setProgressBarIndeterminateVisibility(true);

        ParseUser.requestPasswordResetInBackground(email,
                new RequestPasswordResetCallback() {
                    public void done(ParseException e) {
                        setProgressBarIndeterminateVisibility(false);

                        if (e == null) {
                            // An email was successfully sent with reset
                            // instructions.
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.reset_password_sent), Toast.LENGTH_LONG).show();
                        } else {
                            // Something went wrong. Look at the ParseException
                            // to see what's up.
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.reset_password_fail), Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

}
