package com.example.xlwc350.materialdesign.rest;

import android.content.Context;
import android.util.Log;

import com.example.xlwc350.materialdesign.beans.Conge;
import com.example.xlwc350.materialdesign.beans.Employe;
import com.example.xlwc350.materialdesign.beans.ListEmploye;
import com.example.xlwc350.materialdesign.beans.Response;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xlwc350 on 25/02/2016.
 */
public class EmployePutMethode {private static String LOG_TAG="EmployeRestMethod";
    Context mContext=null;

    public EmployePutMethode(Context context){
        mContext = context.getApplicationContext();
    }

    public Response putEmployeRest(Employe employe) {

        final String url = "https://bddandroid.herokuapp.com/create_employe.php";

        Log.d(LOG_TAG, "Invoke url " + url);

        // Set the Accept header for "application/json"
        HttpHeaders requestHeaders = new HttpHeaders();
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(acceptableMediaTypes);
        requestHeaders.setAcceptLanguage("fr_FR");
        // Populate the headers in an HttpEntity object to use for the request
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("nom_employe", employe.getNom_employe())
                .queryParam("prenom_employe", employe.getPrenom_employe())
                .queryParam("solde_conge", employe.getSolde_conge());
        URI uri = builder.build().encode().toUri();
        Log.d("bonsoir", uri.toString());

        // Perform the HTTP GET request
        Response response = new Response();
        try {
            Log.i("test", "test");
            ResponseEntity<Response> responseEntity = restTemplate.exchange(
                    uri, HttpMethod.GET, requestEntity, Response.class );

            response = responseEntity.getBody();
        } catch (RestClientException e) {
            Log.e(LOG_TAG,"RestException dans le chargement des donnees serveur ARRET",e);


        }

        return response;
    }
}