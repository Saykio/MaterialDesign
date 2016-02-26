package com.example.xlwc350.materialdesign.task;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.xlwc350.materialdesign.activity.ActivityLogin;
import com.example.xlwc350.materialdesign.beans.ListConge;
import com.example.xlwc350.materialdesign.beans.ListEmploye;
import com.example.xlwc350.materialdesign.beans.Response;
import com.example.xlwc350.materialdesign.rest.CongeRestMethode;
import com.example.xlwc350.materialdesign.rest.EmployeGetMethode;

/**
 * Created by xlwc350 on 25/02/2016.
 */
public class GetEmployeTask extends AsyncTask<Void,Void, ListEmploye> {
    private Context context;

    public GetEmployeTask(Context context){
        this.context = context;
    }

    @Override
    protected ListEmploye doInBackground(Void... params) {

        EmployeGetMethode employeGetMethode = new EmployeGetMethode(context);
        ListEmploye lesEmployes = employeGetMethode.getEmployeRest();
        return lesEmployes;
    }

    @Override
    protected void onPostExecute(ListEmploye listEmploye) {
        super.onPostExecute(listEmploye);
        ((ActivityLogin)context).connexion(listEmploye);
    }
}
