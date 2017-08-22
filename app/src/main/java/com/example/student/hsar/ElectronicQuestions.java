package com.example.student.hsar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ElectronicQuestions extends AppCompatActivity {
EditText address,phone1,other1,repair,Landmark;
    CheckBox n1,n2,n3,n4,n5;
    String Appliance,Add,Phone,Repair,l;
DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronic_questions);
        getSupportActionBar().setTitle("Fill in Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
databaseReference= FirebaseDatabase.getInstance().getReference("services").child("electronics");
        address=(EditText)findViewById(R.id.address1);
        phone1=(EditText)findViewById(R.id.phone1);
        repair=(EditText)findViewById(R.id.repair);
        n1=(CheckBox)findViewById(R.id.n1);
        n2=(CheckBox)findViewById(R.id.n2);
        n3=(CheckBox)findViewById(R.id.n3);
        n4=(CheckBox)findViewById(R.id.n4);
        n5=(CheckBox)findViewById(R.id.n5);
        Landmark=(EditText)findViewById(R.id.landmark);
        repair=(EditText)findViewById(R.id.repair);
        other1=(EditText)findViewById(R.id.other1);
    }

    public void addData(View v) {
        if (!(n1.isChecked() || n2.isChecked() || n3.isChecked() || n4.isChecked() || n5.isChecked()))
        {
            Toast.makeText(this, "Select an appliance", Toast.LENGTH_SHORT).show();
        }
        else if(phone1.equals(" "))
        {
            phone1.setError(" Required");
            Toast.makeText(this,"Please enter your mobile number",Toast.LENGTH_SHORT).show();
        }
        else if (!(phone1.length()==10))
        {
            Toast.makeText(this,"Enter 10 digits mobile number",Toast.LENGTH_SHORT).show();
            phone1.setError("10 digits needed");
        }
        else if(address.length()==0)
        {
            address.setError(" Required");
            Toast.makeText(this,"Please enter your address",Toast.LENGTH_SHORT).show();
        }
        else {
StringBuffer result=new StringBuffer();
            if(n1.isChecked())
                result.append(n1.getText().toString());
            else if(n2.isChecked())
                result.append(n2.getText().toString());
            else if(n3.isChecked())
                result.append(n3.getText().toString());
            else if(n4.isChecked())
                result.append(n4.getText().toString());
            else if(n5.isChecked())
                result.append(n5.getText().toString());
            else {
                result.append(other1.getText().toString());
            }
            result.append(" ");
            Appliance=result.toString();
            l=Landmark.getText().toString();
            Repair=repair.getText().toString();
            Add=address.getText().toString()+l;
            Phone=phone1.getText().toString();
            sendingData();
        }
    }
    // Appliance , Repair , Add , Phone
public void sendingData() {
    String id=databaseReference.push().getKey();

    ElectronicModel electricalModel=new ElectronicModel(Add,Appliance,Phone,Repair);
    databaseReference.child(id).setValue(electricalModel);
    Toast.makeText(this,"sending request...",Toast.LENGTH_SHORT).show();
    Empty();
}
    public void Empty()
    {
        //address,phone1,other1,repair
        address.setText(" ");
        phone1.setText(" ");
        other1.setText(" ");
        repair.setText(" ");
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

