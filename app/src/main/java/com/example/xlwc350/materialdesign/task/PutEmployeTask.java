package com.example.xlwc350.materialdesign.task;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.xlwc350.materialdesign.beans.Employe;
import com.example.xlwc350.materialdesign.beans.Response;
import com.example.xlwc350.materialdesign.rest.EmployePutMethode;

/**
 * Created by xlwc350 on 25/02/2016.
 */
public class PutEmployeTask extends AsyncTask<Employe,Void, Response> {
    private Context context;

    public PutEmployeTask(Context context) {
        this.context = context;
    }

    @Override
    protected Response doInBackground(Employe... params) {

        EmployePutMethode employePutMethode = new EmployePutMethode(context);
        Response response = employePutMethode.putEmployeRest(params[0]);
        return response;
    }

    @Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);
        Toast.makeText(context, response.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
