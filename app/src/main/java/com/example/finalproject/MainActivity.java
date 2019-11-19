package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNumber;
    private TextView tvResult;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;
    private Button btnNumber0;

    private Button btnPlus;
    private Button btnSub;
    private Button btnMul;
    private Button btnDiv;
    private Button btnPoint;

    private Button btnResult;
    private Button btnClear;
    private Button btnClearALL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickViews();
    }

    public void initWidget() {
        edtNumber = findViewById(R.id.edt_input);
        tvResult = findViewById(R.id.tv_result);
        btnNumber1 = findViewById(R.id.btnNumber1);
        btnNumber2 = findViewById(R.id.btnNumber2);
        btnNumber3 = findViewById(R.id.btnNumber3);
        btnNumber4 = findViewById(R.id.btnNumber4);
        btnNumber5 = findViewById(R.id.btnNumber5);
        btnNumber6 = findViewById(R.id.btnNumber6);
        btnNumber7 = findViewById(R.id.btnNumber7);
        btnNumber8 = findViewById(R.id.btnNumber8);
        btnNumber9 = findViewById(R.id.btnNumber9);
        btnNumber0 = findViewById(R.id.btnNumber0);

        btnPlus = findViewById(R.id.btnPlus);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        btnPoint = findViewById(R.id.btnPoint);
        btnClear = findViewById(R.id.btnClear);
        btnClearALL = findViewById(R.id.btnClearAll);
        btnResult = findViewById(R.id.btnResult);
    }

    public void setEventClickViews() {
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);
        btnNumber0.setOnClickListener(this);

        btnPlus.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

        btnPoint.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClearALL.setOnClickListener(this);
        btnResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNumber1:
                edtNumber.append("1");

                break;
            case R.id.btnNumber2:
                edtNumber.append("2");
                break;
            case R.id.btnNumber3:
                edtNumber.append("3");
                break;
            case R.id.btnNumber4:
                edtNumber.append("4");
                break;
            case R.id.btnNumber5:
                edtNumber.append("5");
                break;
            case R.id.btnNumber6:
                edtNumber.append("6");
                break;
            case R.id.btnNumber7:
                edtNumber.append("7");
                break;
            case R.id.btnNumber8:
                edtNumber.append("8");
                break;
            case R.id.btnNumber9:
                edtNumber.append("9");
                break;
            case R.id.btnNumber0:
                edtNumber.append("0");
                break;
            case R.id.btnPlus:
                edtNumber.append("+");
                break;
            case R.id.btnSub:
                edtNumber.append("-");
                break;
            case R.id.btnMul:
                edtNumber.append("*");
                break;
            case R.id.btnDiv:
                edtNumber.append("/");
                break;
            case R.id.btnPoint:
                edtNumber.append(".");
                break;
            case R.id.btnClear:
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(edtNumber, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnClearAll:
                edtNumber.setText("");
                tvResult.setText("");
                break;
            case R.id.btnResult:
                double Result = 0;
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                if (arrOperation.size() > arrNumber.size()) {
                    tvResult.setText("lỗi định dạng ");
                } else {
                    for (int i = 0; i < (arrNumber.size() - 1); i++) {
                        switch (arrOperation.get(i)) {
                            case "+":
                                if (i == 0) {
                                    Result = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else {
                                    Result = Result + arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    Result = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else {
                                    Result = Result - arrNumber.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    Result = arrNumber.get(i) * arrNumber.get(i + 1);
                                } else {
                                    Result = Result * arrNumber.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    Result = arrNumber.get(i) / arrNumber.get(i + 1);
                                } else {
                                    Result = Result / arrNumber.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    tvResult.setText(Result + "");
                }
                break;
        }

    }

    public ArrayList<String> arrOperation;

    public ArrayList<Double> arrNumber;

    public int addOperation(String input) {
        arrOperation = new ArrayList<>();
        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '*':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find()) {
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}

