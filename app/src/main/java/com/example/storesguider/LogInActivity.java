package com.example.storesguider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.storesguider.databinding.ActivityLoginBinding;

public class LogInActivity extends AppCompatActivity {

    ActivityLoginBinding binding;  // Αναφορά στο δεσμευμένο αντικείμενο ActivityLoginBinding
    UserDbHelper userDatabaseHelper;  // Αναφορά στον UserDbHelper

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Φόρτωση του δεσμευμένου αντικειμένου ActivityLoginBinding
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Δημιουργία αντικειμένου UserDbHelper
        userDatabaseHelper = new UserDbHelper(this);

        // Ορισμός του listener για το κουμπί "loginButton"
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();

                if (username.equals("") || password.equals("")) {
                    // Έλεγχος αν έχουν συμπληρωθεί και τα δύο πεδία χρήστη και κωδικού
                    Toast.makeText(LogInActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkCredentials = userDatabaseHelper.checkUsernamePassword(username, password);
                    if (checkCredentials) {
                        // Έλεγχος επαλήθευσης των στοιχείων σύνδεσης στη βάση δεδομένων
                        Toast.makeText(LogInActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LogInActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Ορισμός του listener για το κουμπί "registerButton"
        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Προωθεί τον χρήστη στην RegisterActivity για να δημιουργήσει έναν λογαριασμό
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
