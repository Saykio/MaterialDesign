package com.example.xlwc350.materialdesign.rest;

import android.content.Context;
import android.util.Log;

import com.example.xlwc350.materialdesign.beans.Conge;
import com.example.xlwc350.materialdesign.beans.ListConge;
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
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xlwc350 on 23/02/2016.
 */
public class CongeDeleteMethode {
    private static String LOG_TAG="CongeDeleteMethod";
    Context mContext=null;

    public CongeDeleteMethode(Context context){
        mContext = context.getApplicationContext();
    }

    public Response deleteCongeRest (Conge conge) {

        final String url = "https://bddandroid.herokuapp.com/delete_conge.php";

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
                .queryParam("id_conge", conge.getId_conge());
        URI uri = builder.build().encode().toUri();

        // Perform the HTTP GET request
        Response response = new Response();
        try {
            Log.i("test", "test");
            ResponseEntity<Response> responseEntity = restTemplate.exchange(
                    uri, HttpMethod.DELETE, requestEntity, Response.class );

            response = responseEntity.getBody();
        } catch (RestClientException e) {
            Log.e(LOG_TAG,"RestException dans le chargement des donnees serveur ARRET",e);


        }

        return response;
    }

}
