package com.example.student.hsar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ElectricalQuestions extends AppCompatActivity {
    CheckBox fans,coolers,motors,juicers,press,machine,gysers,inverters,wirings;
    EditText other,address,phone,n1,n2,n3,Landmark;
    Spinner spinner;
    String Appliance, N1,N2,N3,Phone,Address,l;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrical_questions);
        getSupportActionBar().setTitle("Fill in Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        databaseReference= FirebaseDatabase.getInstance().getReference("services").child("electrical");
        n1=(EditText)findViewById(R.id.n1);
        n2=(EditText)findViewById(R.id.n2);
        Landmark=(EditText)findViewById(R.id.landmark);
        n3=(EditText)findViewById(R.id.n3);
        spinner=(Spinner)findViewById(R.id.spinner);
     other=(EditText)findViewById(R.id.other);
        phone=(EditText)findViewById(R.id.phone);
        other=(EditText)findViewById(R.id.other);
        address=(EditText)findViewById(R.id.address);

    }
    public void submit(View v)
    {

//StringBuffer result=new StringBuffer();

 if(phone.equals(" "))
        {
            phone.setError(" Required");
            Toast.makeText(this,"Please enter your mobile number",Toast.LENGTH_SHORT).show();
        }
        else if (!(phone.length()==10))
        {
            Toast.makeText(this,"Enter 10 digits mobile number",Toast.LENGTH_SHORT).show();
            phone.setError("10 digits needed");
        }
        else if(address.length()==0)
        {
            address.setError(" Required");
            Toast.makeText(this,"Please enter your address",Toast.LENGTH_SHORT).show();
        }

        else {
     Appliance=spinner.getSelectedItem().toString()+other.getText().toString();
     l = Landmark.getText().toString();
     Address=address.getText().toString()+l;
     Phone=phone.getText().toString();

     N1=n1.getText().toString();
     N2=n2.getText().toString();
     N3=n3.getText().toString();

       sendData();
        }

    }
    // Appliance , N1 , N2 ,N3 , Phone , Address
    public void sendata()
    {
        Toast.makeText(this,Address+Appliance,Toast.LENGTH_SHORT).show();
    }
    public void sendData()

    {
        // String address, String appliance, String install, String phone, String repair, String uninstall
        String id=databaseReference.push().getKey();
        ElectricalModel electricalModel=new ElectricalModel(Address,Appliance,N1,Phone,N2,N3);
        databaseReference.child(id).setValue(electricalModel);
        Toast.makeText(this,"sending request...",Toast.LENGTH_SHORT).show();
        Empty();
    }
    public void Empty()
    {
        /*
        Appliance=other.getText().toString();
        Address=address.getText().toString();
        Phone=phone.getText().toString();
        N1=n1.getText().toString();
        N2=n2.getText().toString();
        N3=n3.getText().toString();
         */
        other.setText(" ");
        address.setText(" ");
        phone.setText(" ");
        n1.setText(" ");
        n2.setText(" ");
        n3.setText(" ");

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
