package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.jokepresenter.DisplayJokeActivity;
import com.udacity.gradle.builditbigger.OnJokeReturned;
import com.udacity.gradle.builditbigger.R;


public class MainActivityFree extends AppCompatActivity implements OnJokeReturned {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_free);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {


        progressBar = findViewById(R.id.progress_joking);
        progressBar.setVisibility(View.VISIBLE);


        new EndpointsAsyncTask(this).execute();
    }


    @Override
    public void jokeReturned(String joke) {
        Intent intent = new Intent(this, DisplayJokeActivity.class);
        if (joke == null)
            joke = getString(R.string.error_connect);

        intent.putExtra(DisplayJokeActivity.BORING_JOKE, joke);

        //this is for the sake of testing, since in the testing only the asyntask will run
        // and this view on be binded
        if (progressBar != null)
            progressBar.setVisibility(View.GONE);

        startActivity(intent);
    }
}
