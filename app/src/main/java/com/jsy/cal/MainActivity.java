package com.jsy.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText EditText1, EditText2;

    Button btnAdd, btnSub, btnMul, btnDiv, btnBack;
    Button result;

    String history = "";
    String number1 = "";
    String number2 = "";

    int type;

    int Add = 0;
    int Sub = 1;
    int Mul = 2;
    int Div = 3;
    double d1;
    double d2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("계산기");

        EditText2 = findViewById(R.id.EditText2);
        EditText1 = findViewById(R.id.EditText1);
        EditText1.setText("");
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnBack = findViewById(R.id.btnBack);
        result = findViewById(R.id.btnResult);

        btnAdd.setOnClickListener(mListener);
        btnSub.setOnClickListener(mListener);
        btnMul.setOnClickListener(mListener);
        btnDiv.setOnClickListener(mListener);
        result.setOnClickListener(mListener);
        btnBack.setOnClickListener(mListener);

        findViewById(R.id.btn0).setOnClickListener(numClick);
        findViewById(R.id.btn1).setOnClickListener(numClick);
        findViewById(R.id.btn2).setOnClickListener(numClick);
        findViewById(R.id.btn3).setOnClickListener(numClick);
        findViewById(R.id.btn4).setOnClickListener(numClick);
        findViewById(R.id.btn5).setOnClickListener(numClick);
        findViewById(R.id.btn6).setOnClickListener(numClick);
        findViewById(R.id.btn7).setOnClickListener(numClick);
        findViewById(R.id.btn8).setOnClickListener(numClick);
        findViewById(R.id.btn9).setOnClickListener(numClick);
        findViewById(R.id.btnDot).setOnClickListener(numClick);



        Button btnAC = findViewById(R.id.btnAC);
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText2.setText("");
                EditText1.setText("");
                d1=d2=0;
                history = number1 = number2 = "";

            }
        });

        Button btnMinor =findViewById(R.id.btnMinor);
        btnMinor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((Double.parseDouble(EditText1.getText().toString()))-((int)Double.parseDouble(EditText1.getText().toString())))==0.0)
                {
                    EditText1.setText( "" + (Integer.parseInt(EditText1.getText().toString())*-1));
                } else {
                    EditText1.setText( "" + (Double.parseDouble(EditText1.getText().toString())*-1));
                }
            }
        });

    }

    Button.OnClickListener mListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(EditText1.getText().toString() == null)
            {
                Toast.makeText(MainActivity.this,"수를 입력하세요",Toast.LENGTH_SHORT).show();
            }
            switch (v.getId()) {
                case R.id.btnAdd :
                    number1 = EditText1.getText().toString();
                    history = EditText1.getText().toString() + " + ";
                    EditText2.setText(history);
                    EditText1.setText("");

                    type = Add;
                    break;

                case R.id.btnSub :
                    number1 = EditText1.getText().toString();
                    history = EditText1.getText().toString() + " - ";
                    EditText2.setText(history);
                    EditText1.setText("");

                    type = Sub;
                    break;

                case R.id.btnMul :
                    number1 = EditText1.getText().toString();
                    history = EditText1.getText().toString() + " * ";
                    EditText2.setText(history);
                    EditText1.setText("");

                    type = Mul;
                    break;

                case R.id.btnDiv :
                    number1 = EditText1.getText().toString();
                    history = EditText1.getText().toString() + " ÷ ";
                    EditText2.setText(history);
                    EditText1.setText("");

                    type = Div;
                    break;

                case R.id.btnBack :

                    String back_number = EditText1.getText().toString();
                    //Toast.makeText(MainActivity.this,back_number,Toast.LENGTH_SHORT).show();
                    EditText1.setText(back_number.substring(0,back_number.length() - 1));
                    break;

                case R.id.btnResult :
                    double result = 0;
                    //Toast.makeText(MainActivity.this, "결과", Toast.LENGTH_SHORT).show();
                    number2 = EditText1.getText().toString();
                    history = history + EditText1.getText().toString();
                    EditText2.setText(history);

                    d1 = Double.parseDouble(number1);
                    d2 = Double.parseDouble(number2);

                    if(type == Add) {
                        result = d1 + d2;
                        if((result-Math.floor(result))==0){
                            EditText1.setText("" + (int)result);
                        }else
                        EditText1.setText("" + result);
                        Log.i("mytag","d1 : "+d1);
                        Log.i("mytag","d2 : "+d2);
                    } else if (type == Sub) {
                        result = d1 - d2;
                        if((result-Math.floor(result))==0){
                            EditText1.setText("" + (int)result);
                        }else
                            EditText1.setText("" + result);
                    }else if (type == Mul) {
                        result = d1 * d2;
                        if((result-Math.floor(result))==0){
                            EditText1.setText("" + (int)result);
                        }else
                            EditText1.setText("" + result);
                    }else if (type == Div) {
                        result = d1 / d2;
                        if((result-Math.floor(result))==0){
                            EditText1.setText("" + (int)result);
                        }else
                            EditText1.setText("" + result);
                    }
                    number1 = EditText1.getText().toString();
                    break;

            }
        }
    };


    Button.OnClickListener numClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn0 : EditText1.setText(EditText1.getText().toString() + "0"); break;
                case R.id.btn1 : EditText1.setText(EditText1.getText().toString() + "1"); break;
                case R.id.btn2 : EditText1.setText(EditText1.getText().toString() + "2"); break;
                case R.id.btn3 : EditText1.setText(EditText1.getText().toString() + "3"); break;
                case R.id.btn4 : EditText1.setText(EditText1.getText().toString() + "4"); break;
                case R.id.btn5 : EditText1.setText(EditText1.getText().toString() + "5"); break;
                case R.id.btn6 : EditText1.setText(EditText1.getText().toString() + "6"); break;
                case R.id.btn7 : EditText1.setText(EditText1.getText().toString() + "7"); break;
                case R.id.btn8 : EditText1.setText(EditText1.getText().toString() + "8"); break;
                case R.id.btn9 : EditText1.setText(EditText1.getText().toString() + "9"); break;
                case R.id.btnDot : EditText1.setText(EditText1.getText().toString() + "."); break;
            }
        }
    };


}



















