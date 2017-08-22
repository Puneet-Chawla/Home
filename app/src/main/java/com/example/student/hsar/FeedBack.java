package com.example.student.hsar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Rating;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class FeedBack extends AppCompatActivity {
    private RatingBar ratingBar;
String rating,Mid,Comp,service,Phone;
    private TextView ratingValue;
    EditText mid,comp,phone;
    Spinner spinner;
    private Button button;
    DatabaseReference databaseReference;
        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
            getSupportActionBar().setTitle("Fill in Details");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mid=(EditText)findViewById(R.id.mid);
            comp=(EditText)findViewById(R.id.comp);
            phone=(EditText)findViewById(R.id.phone);
            spinner=(Spinner)findViewById(R.id.spinner);
            service=spinner.getSelectedItem().toString();
 databaseReference= FirebaseDatabase.getInstance().getReference("feedback").child(service);
        addListenerOnRatingBar();
        addListenerOnButton();
    }

    public void addListenerOnRatingBar() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingValue = (TextView) findViewById(R.id.txtRatingValue);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
        {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {
                ratingValue.setText(String.valueOf(rating));
            }
        });
    }

    public void addListenerOnButton() {
       ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                rating=ratingValue.getText().toString();
                if(mid.length()==0)
                {
                    mid.setError("Required");
                    Toast.makeText(FeedBack.this,"Ask the servicemen",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Mid=mid.getText().toString();
                    Comp=comp.getText().toString();
                   Phone=phone.getText().toString();
                    sendingData();
                }
               }
           });

    }

public void sendingData()
{
    String id=databaseReference.push().getKey();
    // String complaint, String memberid, String rating, String service
    FeedbackModel electricalModel=new FeedbackModel(Comp,Mid,rating,service,Phone);
    databaseReference.child(id).setValue(electricalModel);
    Toast.makeText(this,"sending request...",Toast.LENGTH_SHORT).show();
    Empty();
}
    public void Empty()
    {
showProgressDialog();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hideProgressDialog();
                 }
        },4000);
        mid.setText(" ");
        comp.setText(" ");
        phone.setText(" ");
    }

    public ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("Registering Complaint....");
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
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

