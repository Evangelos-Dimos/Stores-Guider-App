package com.example.storesguider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button showButton;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Αναθέτουμε τα αντικείμενα Button στα αντίστοιχα στοιχεία στο layout
        showButton = findViewById(R.id.showButton);
        backButton = findViewById(R.id.backButton);

        // Ορίζουμε έναν listener για το κουμπί "showButton"
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Δημιουργούμε ένα Intent για να μεταβούμε στην ResultsActivity
                Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                startActivity(intent);
            }
        });

        // Ορίζουμε έναν listener για το κουμπί "backButton"
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Δημιουργούμε ένα Intent για να μεταβούμε στην LogInActivity
                Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                startActivity(intent);
            }
        });
    }

}
