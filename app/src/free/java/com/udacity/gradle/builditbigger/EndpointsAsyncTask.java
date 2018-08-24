package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private OnJokeReturned jokeReturned;

    EndpointsAsyncTask(OnJokeReturned jokeReturned) {
        this.jokeReturned = jokeReturned;
    }


    @Override
    protected String doInBackground(Void... nothing) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(abstractGoogleClientRequest -> abstractGoogleClientRequest.setDisableGZipContent(true));
            // end options for devappserver

            myApiService = builder.build();
        }


        try {


            String joke = myApiService.getBoringJoke().execute().getData();


            return joke;

        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {

        jokeReturned.jokeReturned(result);
    }
}