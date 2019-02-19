package com.example.lavanya2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name,dept,spin_val;
    String[] gender={"Male","Female"};
    float prog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText e=(EditText)findViewById(R.id.editText);
        RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup);
        final RadioButton r1=(RadioButton)findViewById(R.id.radioButton1);
        final RadioButton r2=(RadioButton)findViewById(R.id.radioButton2);
        final Spinner s=(Spinner)findViewById(R.id.spinner2);
        RatingBar rb=(RatingBar)findViewById(R.id.ratingBar);
        Button b=(Button)findViewById(R.id.button);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                spin_val=gender[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,gender);
        s.setAdapter(spin_adapter);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                if(r1.isChecked()==true)
                    dept="B.Tech CSE";
                if(r2.isChecked()==true)
                    dept="B.Tech IT";
            }
        });
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar arg0, float arg1, boolean arg2) {
                prog=arg1;

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                name=e.getText().toString();
                Toast.makeText(getApplicationContext(),"Name:"+name+"\nGender:"+spin_val+"\n Degree:"+dept+"\n Programming Knowledge:"+prog,Toast.LENGTH_LONG).show();
            }
        });
    }
}
