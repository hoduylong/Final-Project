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
import java.util.Stack;

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
    private Button btnSin;
    private Button btnCos;
    private Button btnTan;
    private Button btnCot;
    private Button btnLog;
    private Button btnPow;
    private Button btnExp;
    private Button btnSqrt;
    private Button btnGiaiThua;
    private Button btnPi;

    private Button btnResult;
    private Button btnClear;
    private Button btnClearALL;

    ArrayList<String> postFix;
    Stack stack;
    Stack stackResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickViews();
        postFix = new ArrayList<String>();
        stack = new Stack();
        stackResult = new Stack();
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
        btnSin = findViewById(R.id.btnSin);
        btnTan = findViewById(R.id.btnTan);
        btnCos = findViewById(R.id.btnCos);
        btnCot = findViewById(R.id.btnCot);
        btnLog = findViewById(R.id.btnLog);
        btnPow = findViewById(R.id.btnPow);
        btnExp = findViewById(R.id.btnExp);
        btnSqrt = findViewById(R.id.btnSqrt);
        btnGiaiThua = findViewById(R.id.btnGt);
        btnPi = findViewById(R.id.btnPi);

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
        btnSin.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnCot.setOnClickListener(this);
        btnLog.setOnClickListener(this);
        btnPow.setOnClickListener(this);
        btnExp.setOnClickListener(this);
        btnSqrt.setOnClickListener(this);
        btnGiaiThua.setOnClickListener(this);
        btnPi.setOnClickListener(this);

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
            case R.id.btnSin:
                edtNumber.append("sin(");
                break;
            case R.id.btnCos:
                edtNumber.append("cos(");
                break;
            case R.id.btnTan:
                edtNumber.append("tan(");
                break;
            case R.id.btnCot:
                edtNumber.append("cot(");
                break;
            case R.id.btnLog:
                edtNumber.append("log(");
                break;
            case R.id.btnPow:
                edtNumber.append("^");
                break;
            case R.id.btnExp:
                edtNumber.append("exp(");
                break;
            case R.id.btnSqrt:
                edtNumber.append("sqrt(");
                break;
            case R.id.btnGt:
                edtNumber.append("!");
                break;
            case R.id.btnPi:
                edtNumber.append("PI");
                break;
            case R.id.btnClear:
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(edtNumber, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnClearAll:
                edtNumber.setText("");
                tvResult.setText("");
                stack.clear();
                stackResult.clear();
                postFix.clear();
                break;
            case R.id.btnResult:
                goThrough(edtNumber.getText().toString());
                tvResult.setText(result(postFix) + "");
                break;
        }

    }

    // function
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean hasPrecedence(String op1, String op2) {
        if (op2.equals("(") || op2.equals(")"))
            return false;
        if ((op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-"))) {
            return false;
        }
        if (op1.equals("^") && (op2.equals("+") || op2.equals("-") || op2.equals("*") || op2.equals("/")))
            return false;
        else
            return true;
    }

    public boolean isTrigonometric(String s) {
        if (s.equals("sin") || s.equals("cos") || s.equals("tan") || s.equals("cot") || s.equals("log")
        || s.equals("exp") || s.equals("sqrt") || s.equals("PI")) {
            return true;
        }
        return false;
    }

    public boolean isAlphabetic(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
            return true;
        else
            return false;
    }

    public void goThrough(String s) {
        String temp = "";
        String trigonometric = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isNumeric(String.valueOf(c)) == true) {
                temp += c;
            } else if (isAlphabetic(c) == true) {
                trigonometric += c;
            } else if (c == ')') {
                if (temp != "") {
                    postFix.add(temp);
                    temp = "";
                }
                String t = String.valueOf(stack.pop());
                while (t != "(") {
                    postFix.add(t);
                    t = String.valueOf(stack.pop());
                }
            } else {
                if (temp != "") {
                    postFix.add(temp);
                    temp = "";
                }
                if (c == '+' || c == '-' || c == '/' || c == '*' || c == '^') {
                    String a = "";
                    String b = "";
                    while (!stack.empty() && hasPrecedence(b = Character.toString(c), a = (String) stack.peek()) == true) {
                        postFix.add(String.valueOf(stack.pop()));
                        System.out.println(c + " - " + a);
                    }
                    stack.push(String.valueOf(c));
                } else {
                    if (isTrigonometric(trigonometric)) {
                        stack.push(trigonometric);
                        trigonometric = "";
                    }
                    stack.push("(");
                }
            }

            if (i == s.length() - 1) {
                if (temp != "") {
                    postFix.add(temp);
                }
                while (!stack.empty()) {
                    postFix.add(String.valueOf(stack.pop()));
                }
            }
        }
    }

    public double applyOp(String op, double a, double b) {
        switch (op) {
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            case "/":
                if (a == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return b / a;
            case "^":
                return Math.pow(b, a);
        }
        return 0;
    }


    public static double giaiThua(double a){
        double S=1;
        if(a==0 || a==1) return 1;
        for (int i=2;i<=a;i++){
            S=S*i;
        }
        return S;
    }

    public double result(ArrayList<String> p) {
        for (String s : p) {
            if (isNumeric(s)) {
                stackResult.push(s);
            } else {
                if (isTrigonometric(s)) {

                    double a = Double.parseDouble(stackResult.pop().toString());
                    switch (s) {
                        case "sin":
                            a = Math.PI / 180 * a;
                            stackResult.push(Math.sin(a));
                            break;
                        case "cos":
                            a = Math.PI / 180 * a;
                            stackResult.push(Math.cos(a));
                            break;
                        case "tan":
                            a = Math.PI / 180 * a;
                            stackResult.push(Math.tan(a));
                            break;
                        case "cot":
                            a = Math.PI / 180 * a;
                            stackResult.push(1 / (Math.tan(a)));
                            break;
                        case "log":
                            stackResult.push(Math.log(a));
                            break;
                        case "exp":
                            stackResult.push(Math.exp(a));
                            break;
                        case "sqrt":
                            stackResult.push(Math.sqrt(a));
                            break;
                    }

                } else {
                    double a = Double.parseDouble(stackResult.pop().toString());
                    double b = Double.parseDouble(stackResult.pop().toString());
                    double result = applyOp(s, a, b);
                    stackResult.push(String.valueOf(result));
                }
            }
        }
        return Double.parseDouble(stackResult.pop().toString());
    }
}

