package com.example.storesguider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String[] listStore;  // Λίστα με τα ονόματα των καταστημάτων
    int[] listImages;  // Λίστα με τις εικόνες των καταστημάτων
    String[] listAddress;  // Λίστα με τις διευθύνσεις των καταστημάτων
    LayoutInflater inflater;  // Αντικείμενο για να αναπτύσσει τα στοιχεία του layout

    public CustomBaseAdapter(Context ctx, String[] storesList, int[] images, String[] addressList) {
        this.context = ctx;
        this.listStore = storesList;
        this.listImages = images;
        this.listAddress = addressList;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listStore.length;  // Επιστρέφει τον αριθμό των στοιχείων στη λίστα
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custom_listview, null);  // Αναπτύσσει το layout για κάθε στοιχείο της λίστας
        TextView txtView = convertView.findViewById(R.id.customText);  // Αναφορά στο TextView για το όνομα του καταστήματος
        TextView txtView2 = convertView.findViewById(R.id.customText2);  // Αναφορά στο TextView για τη διεύθυνση του καταστήματος
        ImageView storeImg = convertView.findViewById(R.id.imageIcon);  // Αναφορά στο ImageView για την εικόνα του καταστήματος

        txtView.setText(listStore[position]);  // Ορίζει το όνομα του καταστήματος στο αντίστοιχο TextView
        storeImg.setImageResource(listImages[position]);  // Ορίζει την εικόνα του καταστήματος στο αντίστοιχο ImageView
        txtView2.setText(listAddress[position]);  // Ορίζει τη διεύθυνση του καταστήματος στο αντίστοιχο TextView

        return convertView;  // Επιστρέφει το αναπτυγμένο στοιχείο της λίστας για να εμφανιστεί
    }
}