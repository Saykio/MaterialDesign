package stage.laposte.xlwc350.materialdesign.rest;

import android.content.Context;
import android.util.Log;

import stage.laposte.xlwc350.materialdesign.beans.ListConge;
import stage.laposte.xlwc350.materialdesign.beans.ListEmploye;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xlwc350 on 25/02/2016.
 */
public class EmployeGetMethode {

    private static String LOG_TAG="EmployeGetMethod";
    Context mContext=null;

    public EmployeGetMethode(Context context){
        mContext = context.getApplicationContext();
    }

    public ListEmploye getEmployeRest () {

        final String url = "https://bddandroid.herokuapp.com/get_all_employe.php";

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
        ListEmploye employe = new ListEmploye();
        try {
            Log.i("test", "test");
            ResponseEntity<ListEmploye> responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, requestEntity, ListEmploye.class );

            employe = responseEntity.getBody();
        } catch (RestClientException e) {
            Log.e(LOG_TAG,"RestException dans le chargement des donnees serveur ARRET",e);


        }

        return employe;
    }

}
