package com.example.xlwc350.materialdesign.task;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.xlwc350.materialdesign.beans.Conge;
import com.example.xlwc350.materialdesign.beans.ListConge;
import com.example.xlwc350.materialdesign.beans.Response;
import com.example.xlwc350.materialdesign.rest.CongePutMethode;
import com.example.xlwc350.materialdesign.rest.CongeRestMethode;

/**
 * Created by xlwc350 on 23/02/2016.
 */
public class PutCongeTask extends AsyncTask<Conge,Void, Response> {
        private Context context;

        public PutCongeTask(Context context) {
                this.context = context;
        }

        @Override
        protected Response doInBackground(Conge... params) {

                CongePutMethode congePutMethod = new CongePutMethode(context);
                Response response = congePutMethod.putCongeRest(params[0]);
                return response;
        }

        @Override
        protected void onPostExecute(Response response) {
                super.onPostExecute(response);
                Toast.makeText(context, response.getMessage(),Toast.LENGTH_SHORT).show();
        }
}
