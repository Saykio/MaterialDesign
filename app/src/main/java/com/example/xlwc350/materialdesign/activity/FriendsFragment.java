package com.example.xlwc350.materialdesign.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.xlwc350.materialdesign.R;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.HashMap;
import java.util.Map;


public class FriendsFragment extends Fragment {

//    DatePicker datedebut, datefin;
//
//    Button enregistrer;
//    EditText idemploye;
//    RequestQueue requestQueue;
//    String insertUrl = "http://localhost/testbddandroid/insertconge.php";
    Spinner spinner;

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
        Spinner spinner =(Spinner)this.getActivity().findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this.getActivity(), R.array.motif, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
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