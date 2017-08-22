package com.example.student.hsar;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ComputerQuestions extends AppCompatActivity {
    CheckBox typePc1,typePc2,typePc3,Service1,Service2,Service3,Service4;
    EditText address,phone,issue, Landmark;
public String Issue,Device,Address,Phone,l;
DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_questions);
        getSupportActionBar().setTitle("Fill in Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        databaseReference= FirebaseDatabase.getInstance().getReference("services").child("computer");


        typePc1=(CheckBox) findViewById(R.id.typePc1);
        typePc2=(CheckBox)findViewById(R.id.typePc2);
        typePc3=(CheckBox)findViewById(R.id.typePc3);
        issue=(EditText)findViewById(R.id.issue);
        Landmark=(EditText)findViewById(R.id.landmark);
        phone=(EditText)findViewById(R.id.phone);
        address=(EditText)findViewById(R.id.address);
    }

    public void addComputer(View v)
    {

        if(!(typePc1.isChecked() || typePc2.isChecked() || typePc3.isChecked()))
        {
            Toast.makeText(this,"Please select your device",Toast.LENGTH_SHORT).show();
        }
        else if(issue.equals(" ") )
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
            l= Landmark.getText().toString();
          Phone= phone.getText().toString();
            Address=address.getText().toString()+l;
            Issue=issue.getText().toString();
            if(typePc1.isChecked())
            {
                Device=typePc1.getText().toString();
            }
            else if(typePc2.isChecked())
            {
            Device=typePc2.getText().toString();
            }
            else
            {
                Device=typePc3.getText().toString();
            }

        sendData();

        }

    }
    //  Issue , Device , Address , Phone

    public void sendData()

    {
        String id=databaseReference.push().getKey();
        //String address, String device, String issue, String phone
        ComputerModel computerModel=new ComputerModel(Address,Device,Issue,Phone);
        databaseReference.child(id).setValue(computerModel);
        Toast.makeText(this,"sending request...",Toast.LENGTH_SHORT).show();
        Empty();
    }
public void Empty()
{
    // address,phone,issue
address.setText(" ");
    phone.setText(" ");
    issue.setText(" ");
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
