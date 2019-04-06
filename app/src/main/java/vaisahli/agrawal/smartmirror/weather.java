package vaisahli.agrawal.smartmirror;

import android.os.AsyncTask;
import android.os.RecoverySystem;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import vaisahli.agrawal.smartmirror.MainActivity;
import vaisahli.agrawal.smartmirror.MirrorView;

public class weather extends AsyncTask<String,Void,String> {
String result="";
URL url;
HttpURLConnection urlConnection=null;
    @Override
    protected String doInBackground(String... urls) {
        try {
            url=new URL(urls[0]);
            urlConnection= (HttpURLConnection) url.openConnection();
            InputStream in=urlConnection.getInputStream();
            InputStreamReader reader=new InputStreamReader(in);
            int data=reader.read();
            while (data!=-1)
            {
                char current=(char) data;
                result+=current;
                data=reader.read();
            }
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String rsesult) {
        super.onPostExecute(result);

        try {
            JSONObject jsonObject=new JSONObject(result);
            String weatherInfo=jsonObject.getString("vaisahli.agrawal.smartmirror.weather");
            JSONObject weatherDatas=new JSONObject(jsonObject.getString("main"));
            double tempInt=Double.parseDouble(weatherDatas.getString("TEMP"));


            int tempIn=(int) (tempInt*1.8-459.67);
         //   MirrorView.txt_weather




        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
