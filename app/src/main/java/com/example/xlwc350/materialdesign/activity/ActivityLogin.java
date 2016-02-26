package com.example.xlwc350.materialdesign.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xlwc350.materialdesign.R;
import com.example.xlwc350.materialdesign.beans.Employe;
import com.example.xlwc350.materialdesign.beans.ListEmploye;
import com.example.xlwc350.materialdesign.rest.EmployeGetMethode;
import com.example.xlwc350.materialdesign.task.GetEmployeTask;

import java.util.Map;
import java.util.Set;

/**
 * Created by xlwc350 on 25/02/2016.
 */
public class ActivityLogin extends Activity {
    private ListEmploye lesEmployes;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        final Button loginButton = (Button) findViewById(R.id.connect);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GetEmployeTask task = new GetEmployeTask(ActivityLogin.this);
                task.execute();
            }
        });

        final Button createButton = (Button) findViewById(R.id.create_account);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    public void connexion(ListEmploye listEmploye) {
        boolean flagConnection = false;


        String nom = ((EditText) findViewById(R.id.user_nom)).getText().toString().toLowerCase();
        String prenom = ((EditText) findViewById(R.id.user_prenom)).getText().toString().toLowerCase();
        Log.e("test id", "id=" + nom + prenom);


        for (Employe employe : listEmploye.getEmploye()) {
            if (nom.equals(employe.getNom_employe().toLowerCase()) && prenom.equals(employe.getPrenom_employe().toLowerCase())) {

                    Integer id = employe.getId_employe();
            //TODO sauvegarder dans les preferences
            Log.e("test id", "id=" + id);
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("id_employe", id);
                editor.commit();
                flagConnection = true;
                break;
            }

        }


            if (flagConnection) {
                Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(ActivityLogin.this, "Connexion impossible, user inconnu", Toast.LENGTH_LONG).show();
            }
    }
}


