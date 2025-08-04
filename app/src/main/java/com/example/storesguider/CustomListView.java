package com.example.storesguider;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/* Ορίζει το layout που θα
εμφανιστεί στην οθόνη κατά την εκτέλεση της δραστηριότητας,
το οποίο βρίσκεται στο activity_custom_listview.xml, μέσω της setContentView.
Ουσιαστικά, ορίζεται το layout για το κάθε κατάστημα της λίστας. */
public class CustomListView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_listview);
    }
}
