package com.example.xlwc350.materialdesign.task;

import android.content.Context;
import android.os.AsyncTask;

import com.example.xlwc350.materialdesign.beans.ListConge;
import com.example.xlwc350.materialdesign.rest.CongeRestMethode;

/**
 * Created by xlwc350 on 16/02/2016.
 */
public class getCongesTask extends AsyncTask<Void,Void, ListConge>{

    private Context context;

public getCongesTask(Context context){
        this.context = context;
        }

@Override
protected ListConge doInBackground(Void... params) {

        CongeRestMethode congeRestMethod = new CongeRestMethode(context);
        ListConge lesConges = congeRestMethod.getCongesRest();
        return lesConges;
        }


}