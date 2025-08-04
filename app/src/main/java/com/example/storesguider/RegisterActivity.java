package com.example.storesguider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storesguider.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding; // Σύνδεση με το binding για το layout
    UserDbHelper userDatabaseHelper; // Βοηθητική κλάση για την επικοινωνία με τη βάση δεδομένων

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userDatabaseHelper = new UserDbHelper(this);

        binding.doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();
                String confirmPassword = binding.confirmPassword.getText().toString();

                // Έλεγχος εάν έχουν συμπληρωθεί όλα τα πεδία
                if (username.equals("") || password.equals("") || confirmPassword.equals("")) {
                    Toast.makeText(RegisterActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    // Έλεγχος εάν οι κωδικοί είναι ίδιοι
                    if (password.equals(confirmPassword)) {
                        // Έλεγχος εάν το όνομα χρήστη υπάρχει ήδη
                        Boolean checker = userDatabaseHelper.checkUsername(username);
                        if (!checker) {
                            // Εισαγωγή των νέων δεδομένων στη βάση
                            Boolean insert = userDatabaseHelper.insertData(username, password);
                            // Τσεκάρει τα δεδομένα
                            if (insert) {
                                // Αν είναι σωστά η εγγραφή είναι επιτυχής
                                Toast.makeText(RegisterActivity.this, "Register Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                                startActivity(intent);
                            } else {
                                // Αλλιώς είναι αποτυχής
                                Toast.makeText(RegisterActivity.this, "Register Failed!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // Αν υπάρχει το username εμφανίζει το κατάλληλο μήνυμα
                            Toast.makeText(RegisterActivity.this, "Username already exists! Go to Sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Αν δεν είναι ιδιοι εμφανίζει το κατάλληλο μήνυμα
                        Toast.makeText(RegisterActivity.this, "Invalid Password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Το κουμπί μπακ μας πηγαίνει πίσω στο LogInActivity
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                startActivity(intent);
            }
        });
    }
}
