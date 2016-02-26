package stage.laposte.xlwc350.materialdesign.rest;

import android.content.Context;
import android.util.Log;

import stage.laposte.xlwc350.materialdesign.beans.ListConge;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xlwc350 on 16/02/2016.
 */
public class CongeRestMethode {

    private static String LOG_TAG="CongeRestMethod";
    Context mContext=null;

    public CongeRestMethode(Context context){
        mContext = context.getApplicationContext();
    }

    public ListConge getCongeRest () {

        final String url = "https://bddandroid.herokuapp.com/get_all_conge.php";

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

        // Perform the HTTP GET request
        ListConge conges = new ListConge();
        try {
            Log.i("test", "test");
            ResponseEntity<ListConge> responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, requestEntity, ListConge.class );

            conges = responseEntity.getBody();
        } catch (RestClientException e) {
            Log.e(LOG_TAG,"RestException dans le chargement des donnees serveur ARRET",e);


        }

        return conges;
    }
    public ListConge getCongeRestById (Integer identifiant) {

        final String url = "https://bddandroid.herokuapp.com/get_all_conge.php";

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
                .queryParam("id_employe", identifiant);
        URI uri = builder.build().encode().toUri();
        // Perform the HTTP GET request
        ListConge conges = new ListConge();
        try {
            Log.i("test", "test");
            ResponseEntity<ListConge> responseEntity = restTemplate.exchange(
                    uri, HttpMethod.GET, requestEntity, ListConge.class );

            conges = responseEntity.getBody();
        } catch (RestClientException e) {
            Log.e(LOG_TAG,"RestException dans le chargement des donnees serveur ARRET",e);


        }

        return conges;
    }

}
