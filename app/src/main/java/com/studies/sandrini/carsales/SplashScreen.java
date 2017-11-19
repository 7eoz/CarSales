package com.studies.sandrini.carsales;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class SplashScreen extends AppCompatActivity {

    private static String url = "https://dl.dropboxusercontent.com/s/d24im9i7e3tczls/carros.json";

    private final  int DELAY = 3000; //3 seconds

    ArrayList<HashMap<String, String>> carList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        getSupportActionBar().hide();

        Handler h = new Handler();
        //h.postDelayed(this, DELAY);

        //new GetCars().execute();

    }
/*
    @Override
    public void run() {
        new GetCars().execute();
    }
*/

    private class GetCars extends AsyncTask<Void, Void, Void> {
        Intent it = new Intent(SplashScreen.this, MasterActivity.class);
        Bundle params = new Bundle();

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            //Do the request and receives answer
            String jsonStr = sh.makeServiceCall(url);

            if(jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    JSONArray cars = jsonObj.getJSONArray("carros");

                    //running array and getting cars
                    for (int i = 0; i < cars.length(); i++) {
                        JSONObject c = cars.getJSONObject(i);

                        String id = c.getString("id");
                        String model = c.getString("modelo");
                        String image = c.getString("foto");
                        String manufacturer = c.getString("fabricante");
                        String year = c.getString("ano");
                        String color = c.getString("cor");
                        String price = c.getString("preco");

                        params.putString("id", id);
                        params.putString("model", model);
                        params.putString("image", image);
                        params.putString("manufacturer", manufacturer);
                        params.putString("year", year);
                        params.putString("color", color);
                        params.putString("price", price);
                        it.putExtras(params);
                    }
                } catch (final JSONException e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "JSON Parsing Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Couldn't get JSON from server." , Toast.LENGTH_LONG).show();
                    }
                });
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            startActivity(it);
            finish();
        }
    }
}

