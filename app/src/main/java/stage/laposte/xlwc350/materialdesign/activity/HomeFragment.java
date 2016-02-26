package stage.laposte.xlwc350.materialdesign.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import stage.laposte.xlwc350.materialdesign.R;
import stage.laposte.xlwc350.materialdesign.bdd.CGAdapter;
import stage.laposte.xlwc350.materialdesign.beans.Conge;
import stage.laposte.xlwc350.materialdesign.beans.ListConge;
import stage.laposte.xlwc350.materialdesign.task.DeleteCongeTask;
import stage.laposte.xlwc350.materialdesign.task.GetCongesTask;

import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;


public class HomeFragment extends Fragment {

    private ListView lv;
    private ListConge lesConges;
    private static final int SUPPRIMER = 100;
    private static final int EDITER = 200;
    private static final int NOMENU = 0;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

}

    public void onActivityCreated(Bundle savedInstanceState) {
       // private void refresh(){
        super.onActivityCreated(savedInstanceState);
        lv = (ListView) this.getActivity().findViewById(R.id.listeconge);
        registerForContextMenu(lv);
        this.refreshdata();

        //}



    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Action");
        menu.add(NOMENU, SUPPRIMER, 0, "Supprimer");
        menu.add(NOMENU, EDITER, 1, "Editer");
    }

    public boolean onContextItemSelected(MenuItem item) {
        lv = (ListView) this.getActivity().findViewById(R.id.listeconge);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        Integer id = lesConges.getConge().get(index).getId_conge();
        Conge conge = lesConges.getConge().get(index);
        switch(item.getItemId()) {
            case SUPPRIMER :
                Log.d("bonsoir", id.toString());
                DeleteCongeTask task = new DeleteCongeTask(this.getContext(),this);
                task.execute(conge);
                break;
        }
        return true;
    }
    public void refreshdata(){
        Log.e("Test refresh","test");
        lesConges = new ListConge();
        Log.d("activité", "rafaichisement des données");
        GetCongesTask task = new GetCongesTask(this.getActivity());
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
        int identifiant = preferences.getInt("id_employe", 0);
        if (identifiant == 0) {
            Log.e("test","test identifiant");
        }
        task.execute(identifiant);


        try {
            lesConges = task.get();
            task.cancel(true);

            if(lesConges==null) {
                Log.e("test", "lesConges==null");
            }
            if(lesConges.getConge()==null){
                Log.e("test", "lesConge.getConge()==null");
            }else {
                CGAdapter cgAdapter = new CGAdapter(this.getContext(), R.layout.conge_item, lesConges.getConge());
                lv.setAdapter(cgAdapter);
            }
//                Log.e("libelle", "libelle = " + conge.getConge().get(0).getMotif());
//                List<String> conges = new ArrayList<>();
//                for (Conge conge1 : conge.getConge()){
//                    conges.add(conge1.getId_conge()+ conge1.getId_employe()+conge1.getMotif()+sdf.format(conge1.getDatedebut()));
//                }
//                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, conges );
//                lv.setAdapter(arrayAdapter);




        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}