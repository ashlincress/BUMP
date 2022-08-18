package com.example.bump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Button registerbtn;
    Spinner spinner;
    String[] users={"Prego","Gynecologist","Counsellor"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        spinner=findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.simple_spinner_item,users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                 String value=parent.getItemAtPosition(position).toString();
                Toast.makeText(RegisterActivity.this,value,Toast.LENGTH_SHORT).show();
                }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        TextView btn=findViewById(R.id.exists);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=(new Intent(RegisterActivity.this,MainActivity.class));
                startActivity(intent);
            }
        });
//        registerbtn=findViewById(R.id.Register);
//        registerbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=(new Intent(RegisterActivity.this,MainActivity.class));
//                startActivity(intent);
//            }
//        });
    }
}