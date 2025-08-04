package com.example.storesguider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    Button backButton;
    String[] storesList = {"Cafe mera", "Apothiki Cafe-Brunch" , "Ippopotamos Cafe-Restaurant", "Ypsilon Cafe", "Butler Cafe"," Pantheon Cafe-Bar", "Harry's Spot Cafe", "Efimerida Skg Cafe", "Shark Bar-Restaurant" , "Mauri Thalassa Restaurant" ,"Kitchen Bar", "Ouzo ston pinaka Restaurant", "Palaiwn Arxwn Restaurant", "Tiganies kai Sxares Restaurant", "Spiti tou pasa Restaurant"};
    int[] storesImages = {R.drawable.cafe_mera,R.drawable.apothiki,R.drawable.ippopotamos,R.drawable.ypsilon,R.drawable.butler,R.drawable.pantheon,R.drawable.harrys_spot,R.drawable.efimerida_skg,R.drawable.shark,R.drawable.mauri_thalassa,R.drawable.kitchen_bar,R.drawable.ouzo_ston_pinaka,R.drawable.palaion_arxwn,R.drawable.tiganies,R.drawable.spiti_tou_pasa};
    String[] storesPhones = {"Angelaki Street 18, 546 21", "Konstantinou Melenikou 15, 546 35", "Plateia Agiou Gewrgiou Rotonta 7, 546 35", "Edessis 5, 546 25", "Mitropoleos 42, 546 23", "Proxenou Koromila 8, 546 23", "Angelaki 8, 546 21", "Filikis Eterias 11, 546 21", "Argonafton 2, 551 31", "Nikolaou Plastira 3, 551 32 ", "Apothiki B, 546 25", "Mpalanou 27, 546 23", "Tositsa 7, 546 31", "Katouni 3, 526 22", "Apostolou Pavlou 35, 546 34"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Εύρεση του ListView και εφαρμογή του CustomBaseAdapter
        listView = findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), storesList, storesImages, storesPhones);
        listView.setAdapter(customBaseAdapter);

        // Ανταπόκριση σε κλικ στο αντικείμενο της λίστας
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("CUSTOM_LIST_VIEW", "Item is clicked @ Position :: " + position);
            }
        });

        // Κουμπί μπακ που μας επιστρέφει στο MainActivity
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}