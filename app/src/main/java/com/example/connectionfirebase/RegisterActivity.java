package com.example.connectionfirebase;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText email, password;
    private MaterialButton registerBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {

        String userEmail = email.getText().toString().trim();
        String userPass = password.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            email.setError("Enter valid email");
            return;
        }

        if (userPass.length() < 6) {
            password.setError("Minimum 6 characters");
            return;
        }

        registerBtn.setEnabled(false);

        mAuth.createUserWithEmailAndPassword(userEmail, userPass)
                .addOnCompleteListener(task -> {

                    registerBtn.setEnabled(true);

                    if (task.isSuccessful()) {

                        FirebaseUser user = mAuth.getCurrentUser();

                        if (user != null) {
                            user.sendEmailVerification();
                        }

                        Toast.makeText(this,
                                "Account created! Verify your email.",
                                Toast.LENGTH_LONG).show();

                        startActivity(new Intent(this, LoginActivity.class));
                        finish();

                    } else {
                        Toast.makeText(this,
                                task.getException().getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
    }
}