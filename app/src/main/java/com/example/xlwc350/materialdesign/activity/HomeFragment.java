package com.example.xlwc350.materialdesign.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xlwc350.materialdesign.R;
import com.example.xlwc350.materialdesign.bdd.CGAdapter;
import com.example.xlwc350.materialdesign.beans.Conge;
import com.example.xlwc350.materialdesign.beans.ListConge;
import com.example.xlwc350.materialdesign.task.getCongesTask;

import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class HomeFragment extends Fragment {

    private ListView lv;
    private ListConge lesConges;
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
        lesConges = new ListConge();
            Log.d("activité", "rafaichisement des données");
            getCongesTask task = new getCongesTask(this.getActivity());

            task.execute();


            try {
                ListConge conge = task.get();
                task.cancel(true);
                CGAdapter cgAdapter = new CGAdapter(this.getContext() , R.layout.conge_item, conge.getConge());
                lv.setAdapter(cgAdapter);
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


        //}



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