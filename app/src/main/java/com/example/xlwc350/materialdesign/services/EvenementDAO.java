package com.example.xlwc350.materialdesign.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.xlwc350.materialdesign.bdd.DBAdapter;
import com.example.xlwc350.materialdesign.beans.EvenementBO;
import com.example.xlwc350.materialdesign.beans.TypeEvenementBO;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Created by xlwc350 on 22/01/2016.
 */
public class EvenementDAO extends DBAdapter{

    private static EvenementDAO instance = null;

    public static EvenementDAO getInstance(Context context){
        if(instance==null){
            instance = new EvenementDAO(context);
        }
        return instance;
    }
    private EvenementDAO(Context context){
        super(context);
    }

    public List<EvenementBO> getEvenementBOs(){
        List<EvenementBO> evenementBOs = new ArrayList<>();
        this.open();

        Cursor cursor = db.query("evenement",new String[]{"date","type"},null,null,null,null,null);
        while(cursor.moveToNext()){
            EvenementBO evenementBO = new EvenementBO(new Date(cursor.getLong(cursor.getColumnIndex("date"))),
                    new TypeEvenementBO(cursor.getInt(cursor.getColumnIndex("type"))));
            evenementBOs.add(evenementBO);
        }

        this.close();

        return evenementBOs;
    }

    public long insertEvenementBO(EvenementBO evenementBO){
        this.open();
        ContentValues values = new ContentValues();
        values.put("date", evenementBO.getDateEvenement().getTime());
        values.put("type", evenementBO.getTypeEvenementBO().getId());

        long result = db.insert("evenement", null,values);

        this.close();
        return result;
    }

    public EvenementBO getLastEvenementBO(){
        //TODO a modifier
//        List<EvenementBO> evenementBOs = new ArrayList<>();
//        if(evenementBOs.isEmpty() || evenementBOs.get(evenementBOs.size()-1)== evenementBOs.get(TypeEvenementBO.TYPE_SORTIE)) {
//          return  new EvenementBO(new Date(),  new TypeEvenementBO(TypeEvenementBO.TYPE_ENTREE));
//        }else if (evenementBOs.get(evenementBOs.size()-1)== evenementBOs.get(TypeEvenementBO.TYPE_ENTREE))  {
//            return new EvenementBO(new Date(), new TypeEvenementBO(TypeEvenementBO.TYPE_SORTIE));
//        }else {
//        return null; }

//        List<EvenementBO> evenementBOs = new ArrayList<>();
//        EvenementBO evenementBO =null;
//
//        if(!evenementBOs.isEmpty()){
//            evenementBO = evenementBOs.get(evenementBOs.size()-1);
//        }

       this.open();
        EvenementBO evenementBO =null;

        Cursor cursor = db.query("evenement",new String[]{"date","type"},null,null,null,null, "date desc");
        if (cursor.moveToNext()){
            evenementBO = new EvenementBO(new Date(cursor.getLong(cursor.getColumnIndex("date"))),
                    new TypeEvenementBO(cursor.getInt(cursor.getColumnIndex("type"))));
        }

        this.close();
        return evenementBO;

    }
}
