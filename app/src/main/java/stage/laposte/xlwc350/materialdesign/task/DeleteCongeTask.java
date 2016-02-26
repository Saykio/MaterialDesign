package stage.laposte.xlwc350.materialdesign.task;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import stage.laposte.xlwc350.materialdesign.activity.HomeFragment;
import stage.laposte.xlwc350.materialdesign.beans.Conge;
import stage.laposte.xlwc350.materialdesign.beans.ListConge;
import stage.laposte.xlwc350.materialdesign.beans.Response;
import stage.laposte.xlwc350.materialdesign.rest.CongeDeleteMethode;

/**
 * Created by xlwc350 on 23/02/2016.
 */
public class DeleteCongeTask extends AsyncTask<Conge,Void, Response> {
    private Context context;
    private Fragment fragment;

    public DeleteCongeTask(Context context, Fragment fragment) {

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

