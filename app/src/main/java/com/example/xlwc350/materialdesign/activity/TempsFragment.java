package com.example.xlwc350.materialdesign.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
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
import com.example.xlwc350.materialdesign.bdd.DBAdapter;
import com.example.xlwc350.materialdesign.beans.EvenementBO;
import com.example.xlwc350.materialdesign.beans.TypeEvenementBO;
import com.example.xlwc350.materialdesign.services.EvenementDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TempsFragment extends Fragment implements View.OnClickListener {
    private ToggleButton toggle;
    private ListView listView;
    DBAdapter db;
    private static final int SUPPRIMER = 100;
    private static final int EDITER = 200;
    private static final int NOMENU = 0;

    public TempsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        toggle = (ToggleButton)this.getActivity().findViewById(R.id.toggleButton);
        toggle.setOnClickListener(this);

        EvenementBO evenementBO = EvenementDAO.getInstance(this.getActivity()).getLastEvenementBO();
        if(evenementBO == null || evenementBO.getTypeEvenementBO().getId()== TypeEvenementBO.TYPE_SORTIE){
            toggle.setChecked(true);
        }else{
            toggle.setChecked(false);
        }

        listView = (ListView)this.getActivity().findViewById(R.id.listView);
        dessinerListView();
        registerForContextMenu(listView);

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_temps, container, false);


        // Inflate the layout for this fragment
        return rootView;
    }

//    public onListItemClick(ListView listView, View v, int position) {
//        Cursor cursor = (cursor) l.getAdapter().getItem(position);
//    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Action");
        menu.add(NOMENU, SUPPRIMER, 0, "Supprimer");
        menu.add(NOMENU, EDITER, 1, "Editer");
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case SUPPRIMER :
                SQLiteCursor sQLiteCursor = ((SQLiteCursor) listView.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) item.getMenuInfo()).position));
                db.SupprimerProduit(sQLiteCursor.getInt(sQLiteCursor.getColumnIndex("date")));
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        EvenementBO evenementBO;
        if (toggle.isChecked()){
            Toast.makeText(this.getActivity(), "ON", Toast.LENGTH_SHORT).show();
            evenementBO = new EvenementBO(new Date(),new TypeEvenementBO(TypeEvenementBO.TYPE_SORTIE));
        } else {
            evenementBO = new EvenementBO(new Date(),new TypeEvenementBO(TypeEvenementBO.TYPE_ENTREE));
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

    public void DataBind(){
        Cursor c = db.RecupereLaListe();
        this.getActivity().startManagingCursor(c);
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
