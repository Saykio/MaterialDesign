package com.example.xlwc350.materialdesign.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xlwc350.materialdesign.R;
import com.example.xlwc350.materialdesign.beans.Conge;
import com.example.xlwc350.materialdesign.task.PutCongeTask;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class FriendsFragment extends Fragment implements View.OnClickListener {

//    DatePicker datedebut, datefin;
//
//    Button enregistrer;
//    EditText idemploye;
//    RequestQueue requestQueue;
//    String insertUrl = "http://localhost/testbddandroid/insertconge.php";
    private DatePicker datedebut;
    private DatePicker datefin;
    private Spinner motif;
    private EditText textint;
    private Button enregister;


    Button button;

    public FriendsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Spinner spinner =(Spinner)this.getActivity().findViewById(R.id.motif);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this.getActivity(), R.array.motif, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        datedebut = (DatePicker)this.getActivity().findViewById(R.id.datedebut);
        datefin = (DatePicker)this.getActivity().findViewById(R.id.datefin);
        motif = (Spinner)this.getActivity().findViewById(R.id.motif);
        enregister = (Button)this.getActivity().findViewById(R.id.enregistrer);
        enregister.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.enregistrer) {
//            if (textint.getText().toString().equals("")) {
//                Toast.makeText(this.getContext(), "Remplir le N°employe svp !", Toast.LENGTH_SHORT).show();
//                return;
//            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Log.d("bonsoir la france", "bonsoir");
            Conge conge = new Conge();
            Log.d("datedebut", sdf.format(this.recupDate(datedebut)));
            Log.d("datedebut", sdf.format(this.recupDate(datefin)));
            conge.setDatefin(this.recupDate(datedebut));
            conge.setDatedebut((this.recupDate(datefin)));
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
            int identifiant = preferences.getInt("id_employe", -1);
            if (identifiant == -1) {
                Log.e("test","test identifiant");
            }
            conge.setId_employe(identifiant);
            conge.setMotif(motif.getSelectedItem().toString());
            PutCongeTask task = new PutCongeTask(this.getContext());
            task.execute(conge);
        }
    }



    public Date recupDate(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();

    }







//        requestQueue = Volley.newRequestQueue(this.getActivity().getApplicationContext());
//
//        enregistrer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String s) {
//
//                    }
//                }, new Response.ErrorListener(){
//                    @Override
//                    public void onErrorResponse(VolleyError error){
//
//                    }
//                }){
//                    @Override
//                    protected Map<String, String> getParams() throws AuthFailureError {
//                        Map<String, String> parameters = new HashMap<String, String>();
//                        parameters.put("datedebut", datedebut.getCalendarView().toString());
//                        parameters.put("datefin", datefin.getCalendarView().toString());
//                        parameters.put("id_employe", idemploye.getText().toString());
//
//                        return parameters;
//                    }
//                };
//                requestQueue.add(request);
//            }
//
//        });

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_demande, container, false);


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