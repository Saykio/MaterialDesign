package com.example.xlwc350.materialdesign.bdd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by xlwc350 on 22/01/2016.
 */
public class DBAdapter {

    DatabaseHelper DBHelper;
    Context context;
    public SQLiteDatabase db;

    public DBAdapter (Context context){
        this.context = context;
        DBHelper = new DatabaseHelper(context);
    }

    public class DatabaseHelper extends SQLiteOpenHelper {

        Context context;


        public DatabaseHelper(Context context) {
            super(context, "evenement", null, 1);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            /*db.execSQL("create table demandeconge (_id integer primary key autoincrement," +
                    "datedebut text not null," +
                    "datefin text not null," +
                    "motif text not null" + ");");*/

            db.execSQL("create table evenement (date integer primary key ,type integer);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
    public boolean SupprimerProduit(long date){
        return db.delete("evenement", "date="+date, null)>0;
    }

    public Cursor RecupereLaListe(){
        return db.query("evenement", new String[]{
                "date",
                "type"},null,null,null,null,null);
    }

    public DBAdapter open() {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    /*public void Truncate() {
        db.execSQL("DELETE from demandeconge");
    }

    public long InsererUnProduit (String codebarre, String titre, String description){
        ContentValues values = new ContentValues();
        values.put("datedebut", codebarre);
        values.put("datefin", titre);
        values.put("motif", description);
        return db.insert("demandeconge", null,values);
    }

    public boolean SupprimerProduit(long id){
        return db.delete("demandeconge", "_id="+id, null)>0;
    }
     public Cursor RecupereLaListeDesProduits(){
        return db.query("demandeconge", new String[]{
                "_id",
                "datedebut",
                "datefin",
                "motif"},null,null,null,null,null);
    }

    public Cursor RecupereLaListeDesProduits(){
        return db.query("demandeconge", new String[]{
                "_id",
                "datedebut",
                "datefin",
                "motif"},null,null,null,null,null);
    }*/
}
