package com.example.xlwc350.materialdesign.bdd;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xlwc350.materialdesign.R;
import com.example.xlwc350.materialdesign.beans.Conge;
import com.example.xlwc350.materialdesign.beans.ListConge;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by xlwc350 on 18/02/2016.
 */
public class CGAdapter extends ArrayAdapter<Conge> {


    public CGAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public CGAdapter(Context context, int resource, List<Conge> conges) {
        super(context, resource, conges);
    }



    public View getView(int position, View convertView, ViewGroup parentView) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.conge_item, null);
        }

        final Conge mConge = this.getItem(position);
        String dateFormater = sdf.format(mConge.getDatedebut());
        String maDateAuFormatString = sdf.format(mConge.getDatefin());
        if (mConge != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.id_conge);
            TextView tt2 = (TextView) v.findViewById(R.id.id_employe);
            TextView tt3 = (TextView) v.findViewById(R.id.datedebutitem);
            TextView tt4 = (TextView) v.findViewById(R.id.datefinitem);
            TextView tt5 = (TextView) v.findViewById(R.id.motif);



            if (tt1 != null) {
                tt1.setText("id_conge : " +mConge.getId_conge().toString());
            }

            if (tt2 != null) {
                tt2.setText("id_employe : " +mConge.getId_employe().toString());
            }
            if (tt3 != null) {
                tt3.setText("Date de debut : " +dateFormater);
            }
            if (tt4 != null) {
                tt4.setText("Date de fin : " +maDateAuFormatString);
            }
            if (tt5 != null) {
                tt5.setText("Motif de demande : " +mConge.getMotif().toString());
            }
        }
        return v;

    }



}
