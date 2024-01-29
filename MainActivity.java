package com.example.number_sys_cal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText; //class & objects
    Button button;
    Button button2;
    TextView textView1;
    TextView textView2;
    TextView textView3;

    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.decimalinput); //id declaration
        button = (Button) findViewById(R.id.calculate);
        button2 = (Button) findViewById(R.id.rest);
        textView1 = (TextView) findViewById(R.id.binaryval);
        textView2 = (TextView) findViewById(R.id.octalval);
        textView3 = (TextView) findViewById(R.id.hexaval);
        button3 = (Button) findViewById(R.id.contactid);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText.getText().toString().length() == 0){
                    Toast.makeText(MainActivity.this,"Enter a decimal value",Toast.LENGTH_LONG).show(); // toast
                }else if(!editText.equals(" ")) {
                    String userenterd = editText.getText().toString(); //get user input as string
                    Integer converteduinput = Integer.parseInt(userenterd); //convert string to int

                    String binary = Integer.toBinaryString(converteduinput); //convert decimal to binary
                    String octal = Integer.toOctalString(converteduinput); //convert decimal to octal
                    String hexa = Integer.toHexString(converteduinput); //convert decimal to hexadecimal

                    textView1.setText(binary); //binary value display area
                    textView2.setText(octal); //octal value display area
                    textView3.setText(hexa); //hexadecimal value display area
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() { //to clear all the fields
            @Override
            public void onClick(View v) {
                editText.setText("");
                textView1.setText("");
                textView2.setText("");
                textView3.setText("");

            }
        });

        button3.setOnClickListener(new View.OnClickListener() { //move to next page using details button
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,contactme.class); //move to next page
                startActivity(intent);
            }
        });


    }
}