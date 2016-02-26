package com.example.xlwc350.materialdesign.task;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.xlwc350.materialdesign.activity.HomeFragment;
import com.example.xlwc350.materialdesign.beans.Conge;
import com.example.xlwc350.materialdesign.beans.ListConge;
import com.example.xlwc350.materialdesign.beans.Response;
import com.example.xlwc350.materialdesign.rest.CongeDeleteMethode;

/**
 * Created by xlwc350 on 23/02/2016.
 */
public class deleteCongeTask extends AsyncTask<Conge,Void, Response> {
    private Context context;
    private Fragment fragment;

    public deleteCongeTask(Context context, Fragment fragment) {

        this.context = context;
        this.fragment = fragment;
    }

    @Override
    protected Response doInBackground(Conge... params) {

        CongeDeleteMethode congeDeleteMethod = new CongeDeleteMethode(context);
        Response response = congeDeleteMethod.deleteCongeRest(params[0]);
        return response;
    }


    @Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);
//        Toast.makeText(context, response.getMessage(), Toast.LENGTH_SHORT).show();
        ((HomeFragment)fragment).refreshdata();
    }
}
