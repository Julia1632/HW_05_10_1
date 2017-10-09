package com.example.mycalculator;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class CalculatorActivity extends AppCompatActivity {

    private ICalculator mCalculator= new Calculator();
    private TextView mResultTextView;
    private EditText mInputEditText;
    private View mButtonPlus;
    private View mButtonMinus;
    private View mButtonMult;
    private View mButtonDiv;
    private View mButtonEq;

    private double a;
    private double b;
    private char o;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void InitView(){
        mInputEditText=(EditText) findViewById(R.id.input_txt_edit_text);
        mButtonPlus=findViewById(R.id.button_plus_button);
        mButtonMinus=findViewById(R.id.button_minus_button);
        mButtonMult=findViewById(R.id.button_mult_button);
        mButtonDiv=findViewById(R.id.button_div_button);
        mButtonEq= findViewById(R.id.button_eq_button);

        mButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=mInputEditText.getText().toString();
                a=Double.parseDouble(s);
                o='+';
                mInputEditText.getText().clear();

            }
        });


        mButtonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=mInputEditText.getText().toString();
                b=Double.parseDouble(s);
                if (o=='+'){
                    showResult(mCalculator.plus(a,b));}

            }
        });


        mInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length= editable.length();
                if (length>0) {
                    mButtonEq.setEnabled(true);
                    mButtonPlus.setEnabled(true);
                } else {
                    mButtonEq.setEnabled(false);
                    mButtonPlus.setEnabled(false);
                }

            }
        });
    }

    private void showResult (double r) {
        String r2=Double.toString(r);
        mResultTextView.setText(r2);}
}
