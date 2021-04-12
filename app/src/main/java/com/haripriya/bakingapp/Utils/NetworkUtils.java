package com.haripriya.bakingapp.Utils;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    private static final String TAG = NetworkUtils.class.getSimpleName();
    private static final String Recipe_URL = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";
    public static final String BASE_URL = "https://d17h27t6h515a5.cloudfront.net";
    public static final String JSON_LOC = "/topher/2017/May/59121517_baking/baking.json";




    public static URL buildUrl() {



        URL url = null;
        try {
            url = new URL(Recipe_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.v(TAG, "Built URI " + url);
        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            Log.i("scanner",scanner.toString());
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {

                return scanner.next();
            } else {

                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
