package com.jsy.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
                    history = EditText1.getText().toString() + " / ";
                    EditText2.setText(history);
                    EditText1.setText("");

                    type = Div;
                    break;

                case R.id.btnBack :

                    String back_number = EditText1.getText().toString();
                    Toast.makeText(MainActivity.this,back_number,Toast.LENGTH_SHORT).show();
                    EditText1.setText(back_number.substring(0,back_number.length() - 1));
                    break;

                case R.id.EditText1 :
                    double result = 0;
                    Toast.makeText(MainActivity.this, "결과", Toast.LENGTH_SHORT).show();
                    number2 = EditText1.getText().toString();
                    history = history + EditText1.getText().toString();
                    EditText2.setText(history);

                    d1 = Double.parseDouble(number1);
                    d2 = Double.parseDouble(number2);

                    //number2 = EditText1.getText().toString();
                    if(type == Add) {
                        result = d1 + d2;
                        EditText1.setText("" + result);
                    } else if (type == Sub) {
                        result = d1 - d2;
                        EditText1.setText("" + result);
                    }else if (type == Mul) {
                        result = d1 * d2;
                        EditText1.setText("" + result);
                    }else if (type == Div) {
                        result = d1 / d2;
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
                case R.id.btn0 : EditText1.setText("0"); break;
                case R.id.btn1 : EditText1.setText(EditText2.getText().toString() + 1); break;
                case R.id.btn2 : EditText1.setText(EditText2.getText().toString() + 2); break;
                case R.id.btn3 : EditText1.setText(EditText2.getText().toString() + 3); break;
                case R.id.btn4 : EditText1.setText(EditText2.getText().toString() + 4); break;
                case R.id.btn5 : EditText1.setText(EditText2.getText().toString() + 5); break;
                case R.id.btn6 : EditText1.setText(EditText2.getText().toString() + 6); break;
                case R.id.btn7 : EditText1.setText(EditText2.getText().toString() + 7); break;
                case R.id.btn8 : EditText1.setText(EditText2.getText().toString() + 8); break;
                case R.id.btn9 : EditText1.setText(EditText2.getText().toString() + 9); break;
                case R.id.btnDot : EditText1.setText(EditText2.getText().toString() + "."); break;
            }
        }
    };


}


/*
    EditText edit1,edit2,edit3;
    Button btnDot,btnAdd,btnMul,btnEq,btnSub,btnDiv,btnMinor,btnBack,btnAC;
    TextView textResult;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,
            R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};
    Integer result;
    String num1,num2;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("계산기");

        edit1=(EditText)findViewById(R.id.EditText1);
        edit2 = (EditText)findViewById(R.id.EditText2);
        edit3 = (EditText)findViewById(R.id.EditText3);
        btnDot = (Button)findViewById(R.id.btnDot);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnMul = (Button)findViewById(R.id.btnMul);
        btnEq = (Button)findViewById(R.id.btnEq);
        btnSub  = (Button)findViewById(R.id.btnSub);
        btnDiv  = (Button)findViewById(R.id.btnDiv);
        btnMinor  = (Button)findViewById(R.id.btnMinor);
        btnBack  = (Button)findViewById(R.id.btnBack);
        btnAC  = (Button)findViewById(R.id.btnAC);
        textResult = (TextView)findViewById(R.id.TV1);


        for(i=0;i<numBtnIDs.length;i++){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }
        for(i=0;i<numBtnIDs.length;i++){
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case R.id.btnAdd :
                            edit2.isFocused(edit2.setText(btnAdd.getText()));

                        case R.id.btn0 :
                            if(edit2==null){ edit3.setText(edit3.getText().toString()+0); }
                            else { edit1.setText(edit1.getText().toString() + 0); } break;
                        case R.id.btn1 :
                            if(edit2==null){ edit3.setText(edit3.getText().toString() + 1); }
                            else { edit1.setText(edit1.getText().toString() + 1); } break;
                    }
                }
            });
        }










        btnEq.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                String num1=edit1.getText().toString();
                String num2=edit2.getText().toString();
                String num3=edit3.getText().toString();
                int result=0;
                switch(num2){
                    case "+":
                        result=Integer.parseInt(num3) + Integer.parseInt(num1);
                        Log.i("mytag",result+"");
                        //Toast.makeText(getApplicationContext(),result+"",Toast.LENGTH_SHORT).show();
                        textResult.setText(result+"");
                        break;
                    case "-":
                        result=Integer.parseInt(num3) - Integer.parseInt(num1);
                        Log.i("mytag",result+"");
                        //Toast.makeText(getApplicationContext(),result+"",Toast.LENGTH_SHORT).show();
                        textResult.setText(result+"");
                        break;
                    case "*":
                        result=Integer.parseInt(num3) * Integer.parseInt(num1);
                        Log.i("mytag",result+"");
                        //Toast.makeText(getApplicationContext(),result+"",Toast.LENGTH_SHORT).show();
                        textResult.setText(result+"");
                        break;
                    case "÷":
                        result=Integer.parseInt(num3) / Integer.parseInt(num1);
                        Log.i("mytag",result+"");
                        //Toast.makeText(getApplicationContext(),result+"",Toast.LENGTH_SHORT).show();
                        textResult.setText(result+"");
                        break;

                }

                return false;

            }
        });


    }
}*/


















