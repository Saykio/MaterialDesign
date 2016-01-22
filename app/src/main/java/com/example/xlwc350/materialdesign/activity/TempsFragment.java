package com.example.xlwc350.materialdesign.activity;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.xlwc350.materialdesign.R;
import com.example.xlwc350.materialdesign.beans.EvenementBO;
import com.example.xlwc350.materialdesign.beans.TypeEvenementBO;
import com.example.xlwc350.materialdesign.services.EvenementDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TempsFragment extends Fragment implements View.OnClickListener {
    private ToggleButton toggle;
    private ListView listView;

    public TempsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        toggle = (ToggleButton)this.getActivity().findViewById(R.id.toggleButton);
        toggle.setOnClickListener(this);
        EvenementBO evenementBO = EvenementDAO.getInstance(this.getActivity()).getLastEvenementBO();
        if(evenementBO.getTypeEvenementBO().getId()== TypeEvenementBO.TYPE_ENTREE){
            toggle.setChecked(true);
        }else{
            toggle.setChecked(false);
        }

        listView = (ListView)this.getActivity().findViewById(R.id.listView);
        dessinerListView();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_temps, container, false);


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onClick(View v) {
        EvenementBO evenementBO;
        if (toggle.isChecked()){
            Toast.makeText(this.getActivity(), "ON", Toast.LENGTH_SHORT).show();
            evenementBO = new EvenementBO(new Date(),new TypeEvenementBO(TypeEvenementBO.TYPE_ENTREE));
        } else {
            evenementBO = new EvenementBO(new Date(),new TypeEvenementBO(TypeEvenementBO.TYPE_SORTIE));
            Toast.makeText(this.getActivity(), "OFF", Toast.LENGTH_SHORT).show();
        }
        EvenementDAO.getInstance(this.getActivity()).insertEvenementBO(evenementBO);
        this.dessinerListView();    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    private void dessinerListView(){
        ArrayList<String> listString = new ArrayList();
        List<EvenementBO> evenementBOs = EvenementDAO.getInstance(this.getActivity()).getEvenementBOs();
        for(EvenementBO evenementBO : evenementBOs){
            listString.add(evenementBO.getDateEvenement()+"-"+evenementBO.getTypeEvenementBO().getLibelle());
        }
        ArrayAdapter adapter = new ArrayAdapter(this.getActivity(),android.R.layout.simple_list_item_1,listString);
        listView.setAdapter(adapter);
    }
}
