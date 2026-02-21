package com.example.connectionfirebase;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText email, password;
    private MaterialButton loginBtn;
    private TextView goRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        goRegister = findViewById(R.id.goRegister);

        loginBtn.setOnClickListener(v -> loginUser());

        goRegister.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });
    }

    private void loginUser() {

        String userEmail = email.getText().toString().trim();
        String userPass = password.getText().toString().trim();

        loginBtn.setEnabled(false);

        mAuth.signInWithEmailAndPassword(userEmail, userPass)
                .addOnCompleteListener(task -> {

                    loginBtn.setEnabled(true);

                    if (task.isSuccessful()) {

                        FirebaseUser user = mAuth.getCurrentUser();

                        if (user != null && user.isEmailVerified()) {

                            startActivity(new Intent(this, MainActivity.class));
                            finish();

                        } else {
                            Toast.makeText(this,
                                    "Please verify your email first.",
                                    Toast.LENGTH_LONG).show();
                        }

                    } else {
                        Toast.makeText(this,
                                task.getException().getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null && user.isEmailVerified()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}