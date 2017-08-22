package com.example.student.hsar;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PlumberQuestions extends AppCompatActivity {
    EditText phone,problem,address,Landmark;
    String Phone,Add,Problem,l;
DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber_questions);
        getSupportActionBar().setTitle("Fill in Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
databaseReference= FirebaseDatabase.getInstance().getReference("services").child("plumber");
        address=(EditText)findViewById(R.id.address);
        Landmark=(EditText)findViewById(R.id.landmark);
        phone=(EditText)findViewById(R.id.phone);
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
                l= Landmark.getText().toString();
                Add = address.getText().toString()+"\n landmark: "+l;
                Phone = phone.getText().toString();
                Problem = problem.getText().toString();
                sendingData();
            }
        }

    // Add , Phone, Problem
    public void sendingData()
    {
        // String add, String phone, String problem
        String id=databaseReference.push().getKey();

        PlumberModel painterModel=new PlumberModel(Add,Phone,Problem);
        databaseReference.child(id).setValue(painterModel);
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
