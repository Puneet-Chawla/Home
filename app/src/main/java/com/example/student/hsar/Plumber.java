package com.example.student.hsar;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Plumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber);
        getSupportActionBar().setTitle("Plumber");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void feed(View v)
    {

        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setType("plain/text");
        sendIntent.setData(Uri.parse("hsarhelp@gmail.com"));
        sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
        //sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "example@gmail.com" });
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Complaint");
        sendIntent.putExtra(Intent.EXTRA_TEXT, "your message ");
        startActivity(sendIntent);

    }
    public void schedulePlumber(View v)
    {
        Intent i=new Intent(this,PlumberQuestions.class);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id==android.R.id.home) {
            finish();
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
