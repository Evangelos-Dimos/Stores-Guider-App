package com.example.storesguider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDbHelper extends SQLiteOpenHelper {

    public static final String databaseName = "Users.db";

    public UserDbHelper(@Nullable Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        // Δημιουργία πίνακα "users" με τα πεδία "username" και "password"
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        // Διαγραφή του πίνακα "users" αν υπάρχει
        myDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDatabase.insert("users", null, contentValues);
        // Επιστροφή αν το insert ήταν επιτυχημένο ή όχι
        return result != -1;
    }

    public Boolean checkUsername(String username) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where username = ?", new String[]{username});
        // Έλεγχος αν υπάρχει καταχώρηση με το συγκεκριμένο όνομα χρήστη
        return cursor.getCount() > 0;
    }

    public Boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where username = ? and password = ?", new String[]{username, password});
        // Έλεγχος αν υπάρχει καταχώρηση με το συγκεκριμένο όνομα χρήστη και κωδικό
        return cursor.getCount() > 0;
    }
}
