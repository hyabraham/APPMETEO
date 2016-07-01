package com.example.student.myapplication.meteo;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.student.myapplication.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Meteo extends AppCompatActivity {

    private static String API_KEY ="&appid=ede9f14f2ed763244f43f97e8c8bd346";
    private static String URL_WEATHER = "http://api.openweathermap.org/data/2.5/weather";  // ?q={city name},{country code}
    // http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=ede9f14f2ed763244f43f97e8c8bd346

    EditText editVille;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meteo);

        editVille = (EditText) findViewById(R.id.meteo_ville);

    }

    public void search(View view){
        new MeteoRetriever().execute(editVille.getText().toString());
    }

    public String requestBuilder(String ville){
        StringBuilder sb = new StringBuilder();
        sb.append(URL_WEATHER).append("?q=").append(ville);
        sb.append(API_KEY);
        System.out.println("request " + sb.toString());
        return sb.toString();
    }

    private class MeteoRetriever extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                String ville = params[0];
                URL url = new URL(requestBuilder(ville));
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                int responseCode = connection.getResponseCode();
                System.out.println("GET Response Code :: " + responseCode);
                StringBuffer response = new StringBuffer();
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    Log.d("Lu : 0", inputLine);
                    response.append(inputLine);
                }
                in.close();

                Log.d("Response",response.toString());
                return response.toString();
            }catch (Exception ex) {
                Log.e("ERROR", ex.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            TextView txtVille;
            txtVille = (TextView) findViewById(R.id.meteo_view);
            txtVille.setText(formatString(s));
        }

        public String formatString(String text){

            StringBuilder json = new StringBuilder();
            String indentString = "";

            for (int i = 0; i < text.length(); i++) {
                char letter = text.charAt(i);
                switch (letter) {
                    case '{':
                    case '[':
                        json.append("\n" + indentString + letter + "\n");
                        indentString = indentString + "\t";
                        json.append(indentString);
                        break;
                    case '}':
                    case ']':
                        indentString = indentString.replaceFirst("\t", "");
                        json.append("\n" + indentString + letter);
                        break;
                    case ',':
                        json.append(letter + "\n" + indentString);
                        break;

                    default:
                        json.append(letter);
                        break;
                }
            }

            return json.toString();
        }
    }
}
