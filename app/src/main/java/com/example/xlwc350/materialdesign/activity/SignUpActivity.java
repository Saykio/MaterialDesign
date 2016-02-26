package com.example.xlwc350.materialdesign.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.xlwc350.materialdesign.R;
import com.example.xlwc350.materialdesign.beans.Employe;
import com.example.xlwc350.materialdesign.task.PutEmployeTask;

/**
 * Created by xlwc350 on 25/02/2016.
 */
public class SignUpActivity extends Activity {

    private EditText user_nom, user_prenom, user_solde;
    private Button sinscrire;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        user_nom = (EditText)this.findViewById(R.id.user_nom);
        user_prenom = (EditText)this.findViewById(R.id.user_prenom);
        user_solde = (EditText)this.findViewById(R.id.user_solde);
        sinscrire = (Button)this.findViewById(R.id.sinscrire);
        sinscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employe employe = new Employe();
                Log.d("prenom",user_prenom.getText().toString());
                Log.d("prenom",user_nom.getText().toString());
                employe.setPrenom_employe(user_prenom.getText().toString());
                employe.setNom_employe(user_nom.getText().toString());
                employe.setSolde_conge(Integer.valueOf(user_solde.getText().toString()));
                PutEmployeTask task = new PutEmployeTask(SignUpActivity.this);
                task.execute(employe);
            }
        });


    }
}
