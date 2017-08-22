package com.example.student.hsar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RoQuestions extends AppCompatActivity {
    EditText address, phone, problem,Landmark;
    String Add, Phone, Problem,l;
DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ro_questions);
        getSupportActionBar().setTitle("Fill in Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        databaseReference= FirebaseDatabase.getInstance().getReference("services").child("ro");
        address=(EditText)findViewById(R.id.address);
        phone=(EditText)findViewById(R.id.phone);
        Landmark=(EditText)findViewById(R.id.landmark);
        problem=(EditText)findViewById(R.id.problem);


    }

    public void submitData(View v) {
        if ((problem.length()==0))
        {
            Toast.makeText(this, "Add Problem", Toast.LENGTH_SHORT).show();
            problem.setError("Required");
        }
        else if (!(phone.length() == 10)) {
            Toast.makeText(this, "Add 10 digit mobile number", Toast.LENGTH_SHORT).show();
            phone.setError("10 digits number");
        }

        else if ((address.length()==0)) {
            Toast.makeText(this, "Add Address", Toast.LENGTH_SHORT).show();
            address.setError("Required");
        }
        else {
            l = Landmark.getText().toString();
            Add = address.getText().toString()+"landmark:"+l;
            Phone = phone.getText().toString();
            Problem = problem.getText().toString();
            sendingData();
        }
    }
    // Add, Phone, Problem
    public void sendingData()
    {

        String id=databaseReference.push().getKey();

        RoModel roModel=new RoModel(Add,Phone,Problem);
        databaseReference.child(id).setValue(roModel);
        Toast.makeText(this,"sending request...",Toast.LENGTH_SHORT).show();
        Empty();
        }
    public void Empty()
    {
        address.setText(" ");
        phone.setText(" ");
        problem.setText(" ");
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
