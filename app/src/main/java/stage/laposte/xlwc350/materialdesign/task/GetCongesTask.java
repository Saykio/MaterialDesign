package stage.laposte.xlwc350.materialdesign.task;

import android.content.Context;
import android.os.AsyncTask;

import stage.laposte.xlwc350.materialdesign.beans.ListConge;
import stage.laposte.xlwc350.materialdesign.rest.CongeRestMethode;

/**
 * Created by xlwc350 on 16/02/2016.
 */
public class GetCongesTask extends AsyncTask<Integer,Void, ListConge>{

    private Context context;

public GetCongesTask(Context context){
        this.context = context;
        }

@Override
protected ListConge doInBackground(Integer... params) {

        CongeRestMethode congeRestMethod = new CongeRestMethode(context);
        ListConge lesConges = congeRestMethod.getCongeRestById(params[0]);
        return lesConges;
        }


}
