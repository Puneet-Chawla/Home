package com.example.student.hsar;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AcQuestions extends AppCompatActivity {
    CheckBox typeAc1,typeAc2,Service1,Service2,Service3,Service4;
    EditText address,phone,need1,need2,need3,need4,Landmark;
  String actype,s1,s2,s3,s4,n1,n2,n3,n4,Phon,Add,l;
DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_questions);
        getSupportActionBar().setTitle("Fill in Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        databaseReference= FirebaseDatabase.getInstance().getReference("services").child("ac");
        typeAc1=(CheckBox) findViewById(R.id.typeAc1);
        typeAc2=(CheckBox)findViewById(R.id.typeAc2);
        Service1=(CheckBox)findViewById(R.id.service1);
        Service2=(CheckBox)findViewById(R.id.service2);
        Service3=(CheckBox)findViewById(R.id.service3);
        Service4=(CheckBox)findViewById(R.id.service4);
          need1=(EditText)findViewById(R.id.need1);
        Landmark=(EditText)findViewById(R.id.landmark);
          need2=(EditText)findViewById(R.id.need2);
          need3=(EditText)findViewById(R.id.need3);
          need4=(EditText)findViewById(R.id.need4);
          phone=(EditText)findViewById(R.id.phone);
          address=(EditText)findViewById(R.id.address);
    }

 public void addData(View v)
 {

if(!(typeAc1.isChecked() || typeAc2.isChecked()))
{
    Toast.makeText(this,"Please select an AC type",Toast.LENGTH_SHORT).show();
}

        else if(!(Service1.isChecked() || Service2.isChecked() || Service3.isChecked() || Service4.isChecked()))
        {
            Toast.makeText(this,"Please select a Service",Toast.LENGTH_SHORT).show();
        }

        else if((need1.equals(" ") && need2.equals(" ") && need3.equals(" ") && need4.equals(" ") ))
{
    Toast.makeText(this,"Please type in number of AC(s)",Toast.LENGTH_SHORT).show();
}
else if(phone.equals(" "))
{
    phone.setError(" Required");
    Toast.makeText(this,"Please enter your mobile number",Toast.LENGTH_SHORT).show();
}
else if (!(phone.length()==10))
{
    Toast.makeText(this,"Enter 10 digits mobile number",Toast.LENGTH_SHORT).show();
    phone.setError("10 digits?");
}
else if(address.length()==0)
{
    address.setError(" Required");
    Toast.makeText(this,"Please enter your address",Toast.LENGTH_SHORT).show();
}
 else
{
    if(typeAc1.isChecked())
    {
        actype=typeAc1.getText().toString();
    }
    else
    {
        actype=typeAc2.getText().toString();
    }
    if(Service1.isChecked())
    {
        s1=Service1.getText().toString();
    }
    else if(Service2.isChecked())
    {
        s1=Service2.getText().toString();
    }

    else if(Service3.isChecked())
    {
        s1=Service3.getText().toString();
    }

    else
    {
        s1=Service2.getText().toString();
    }
    n1=need1.getText().toString();
    n2=need2.getText().toString();
    n3=need3.getText().toString();
    n4=need4.getText().toString();
    Phon=phone.getText().toString();
    l=Landmark.getText().toString();
    Add=address.getText().toString()+l;
    sendData();
}
// n1 , n2 , n3 , Phon , Address , s1 , acType
    }
    public void sendData()
    {
        String id=databaseReference.push().getKey();
        //    public AcModel(String acType, String address, String id, String installno, String phone, String repairno, String service, String servicingno, String uninstallno) {

        AcModel acModel= new AcModel(actype,Add,id,n2,Phon,n4,s1,n1,n3);
        databaseReference.child(id).setValue(acModel);
Toast.makeText(this,"sending request",Toast.LENGTH_SHORT).show();
Empty();
    }
    public void Empty()
    {
  /*
            CheckBox typeAc1,typeAc2,Service1,Service2,Service3,Service4;
    EditText address,phone,need1,need2,need3,need4;

         */
        address.setText(" ");
        phone.setText(" ");
        need1.setText(" ");
        need2.setText(" ");
        need3.setText(" ");
        need4.setText(" ");
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
