package com.example.xlwc350.materialdesign.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xlwc350.materialdesign.R;
import com.example.xlwc350.materialdesign.beans.ListConge;
import com.example.xlwc350.materialdesign.task.getCongesTask;

import android.app.Activity;

import java.util.concurrent.ExecutionException;


public class HomeFragment extends Fragment {

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
            Log.d("activité", "rafaichisement des données");
            getCongesTask task = new getCongesTask(this.getActivity());

            task.execute();

            try {
                ListConge conge = task.get();
                task.cancel(true);
                Log.e("libelle", "libelle = "+conge.getLibelle());

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