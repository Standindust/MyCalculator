

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button bt_num0;
    private Button bt_num1;
    private Button bt_num2;
    private Button bt_num3;
    private Button bt_num4;
    private Button bt_num5;
    private Button bt_num6;
    private Button bt_num7;
    private Button bt_num8;
    private Button bt_num9;
    private Button bt_clear;
    private Button bt_percent;
    private Button bt_delete;
    private Button bt_div;
    private Button bt_mult;
    private Button bt_minus;
    private Button bt_plus;
    private Button bt_equal;
    private Button bt_dot;

    private EditText et_calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewAndListener();
    }
    private void initViewAndListener() {
        bt_num0 = findViewById(R.id.bt_num0);
        bt_num0.setOnClickListener(this);

        bt_num1 = findViewById(R.id.bt_num1);
        bt_num1.setOnClickListener(this);


        bt_num2 = findViewById(R.id.bt_num2);
        bt_num2.setOnClickListener(this);

        bt_num3 = findViewById(R.id.bt_num3);
        bt_num3.setOnClickListener(this);

        bt_num4 = findViewById(R.id.bt_num4);
        bt_num4.setOnClickListener(this);

        bt_num5 = findViewById(R.id.bt_num5);
        bt_num5.setOnClickListener(this);

        bt_num6 = findViewById(R.id.bt_num6);
        bt_num6.setOnClickListener(this);

        bt_num7 = findViewById(R.id.bt_num7);
        bt_num7.setOnClickListener(this);

        bt_num8 = findViewById(R.id.bt_num8);
        bt_num8.setOnClickListener(this);

        bt_num9 = findViewById(R.id.bt_num9);
        bt_num9.setOnClickListener(this);



        bt_clear = findViewById(R.id.bt_clear);
        bt_clear.setOnClickListener(this);

        bt_percent = findViewById(R.id.bt_percent);
        bt_percent.setOnClickListener(this);

        bt_delete = findViewById(R.id.bt_delete);
        bt_delete.setOnClickListener(this);

        bt_div = findViewById(R.id.bt_div);
        bt_div.setOnClickListener(this);

        bt_mult = findViewById(R.id.bt_mult);
        bt_mult.setOnClickListener(this);

        bt_minus = findViewById(R.id.bt_minus);
        bt_minus.setOnClickListener(this);


        bt_plus = findViewById(R.id.bt_plus);
        bt_plus.setOnClickListener(this);

        bt_equal = findViewById(R.id.bt_equal);
        bt_equal.setOnClickListener(this);


        et_calc = findViewById(R.id.et_calc);

        bt_dot = findViewById(R.id.bt_dot);
        bt_dot.setOnClickListener(this);

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {getMenuInflater().inflate(R.menu.main,menu);
    return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.comp_item:

                Log.d("FirstActivity","启动第二个Activity");
                Intent intent = new Intent(MainActivity.this, comActivity.class);
//                第一个参数是启动活动的上下文
//                        第二个参数是想要启动的目标活动

                startActivity(intent);
                finish();
                Toast.makeText(this,"您刚刚点击了'科学计算器'按钮", Toast.LENGTH_LONG).show();
                break;
            case R.id.nom_item:
                Toast.makeText(this,"您刚刚点击了'普通计算器'按钮", Toast.LENGTH_LONG).show();

                break;
            case R.id.quit_item:
                Toast.makeText(this,"您刚刚点击了'退出'按钮", Toast.LENGTH_LONG).show();
                finish();
        }
        return true;
    }

    private boolean lastIsOperator;
    private String lastOperators = ""; //最后一个运算符号
    private List<String> operatorNumbers = new ArrayList<>();
    private List<String> operators = new ArrayList<>();

    private double firstNumber = 0D;
    private double sencondNumber = 0D;

    @Override
    public void onClick(View v) {

        String currentText = et_calc.getText().toString();
        //加减乘除运算符后的数
        String operatorNumber = "";

//        if (currentText.equals("0")) {
//            et_calc.setText("");
//        }


        operatorNumber = et_calc.getText().toString();

        if(!lastOperators.equals(""))
        {
            //判断最后一个符号的位置
            int index = operatorNumber.lastIndexOf(lastOperators);
            //将这串字符中最后一个符号位置之后的数字取出 即为新的一个被操作数
            operatorNumber = operatorNumber.substring(index+1);
        }




        switch (v.getId()) {
            //获取点击的控件ID
            case R.id.bt_num0:
                et_calc.setText(et_calc.getText() + "0");
                lastIsOperator = false;
                break;
            case R.id.bt_num1:
                et_calc.setText(et_calc.getText() + "1");
                lastIsOperator = false;
                break;
            case R.id.bt_num2:
                et_calc.setText(et_calc.getText() + "2");
                lastIsOperator = false;
                break;
            case R.id.bt_num3:
                et_calc.setText(et_calc.getText() + "3");
                lastIsOperator = false;
                break;
            case R.id.bt_num4:
                et_calc.setText(et_calc.getText() + "4");
                lastIsOperator = false;
                break;
            case R.id.bt_num5:
                et_calc.setText(et_calc.getText() + "5");
                lastIsOperator = false;
                break;
            case R.id.bt_num6:
                et_calc.setText(et_calc.getText() + "6");
                lastIsOperator = false;
                break;
            case R.id.bt_num7:
                et_calc.setText(et_calc.getText() + "7");
                lastIsOperator = false;
                break;
            case R.id.bt_num8:
                et_calc.setText(et_calc.getText() + "8");
                lastIsOperator = false;
                break;
            case R.id.bt_num9:
                et_calc.setText(et_calc.getText() + "9");
                lastIsOperator = false;
                break;
            case R.id.bt_dot:
                et_calc.setText(et_calc.getText() + ".");
                lastIsOperator = false;
                break;
            case R.id.bt_clear:
                if (TextUtils.isEmpty(et_calc.getText())) {//TextUtils.isEmpty  字符串判断是否为空 是返回true
                    return;
                }
                et_calc.setText("");
                lastIsOperator = false;
                firstNumber = 0D;
                sencondNumber = 0D;
                lastOperators = "";

                break;
            case R.id.bt_percent:
                if ((TextUtils.isEmpty(et_calc.getText())//TextUtils.isEmpty  字符串判断是否为空 是返回true
                        || lastIsOperator) && !lastOperators.equals("=")) {
                    return;
                }
                //opratorCalc(operatorNumber,"+/-");
                lastIsOperator = false;
                //判断最后一个符号的位置
                int index1 = operatorNumber.lastIndexOf(operatorNumber);
                //将这串字符中最后一个符号位置之后的数字取出 即为新的一个被操作数
                if(Double.parseDouble(operatorNumber)>0){
                    StringBuffer stringBuilder1 = new StringBuffer(operatorNumber);
                    stringBuilder1.insert(index1, "-");
                    et_calc.setText(stringBuilder1);
                    lastOperators = "";
                }else{
                    Double d=Double.parseDouble(operatorNumber)*(-1);
                    String s = String.valueOf(d);

                    et_calc.setText(s);
                    lastOperators = "";
                }

                break;
            case R.id.bt_delete:
                if (TextUtils.isEmpty(et_calc.getText())) {//TextUtils.isEmpty  字符串判断是否为空 是返回true
                    return;
                }
                lastIsOperator = false;
                et_calc.setText(currentText.substring(0, currentText.length() - 1).length() > 0 ? currentText.substring(0, currentText.length() - 1) : "0");
                break;
            case R.id.bt_div:

                if ((TextUtils.isEmpty(et_calc.getText())
                        || lastIsOperator) && !lastOperators.equals("=")) {
                    int index2 = currentText.lastIndexOf(operatorNumber);
                    StringBuffer stringBuilder1 = new StringBuffer(currentText);
                    if(stringBuilder1.length()<1){
                        return;
                    }
                    //用于判断前一个字符是否为操作符 是则重新输入
                    if(stringBuilder1.substring(index2-1).equals("+")||
                            stringBuilder1.substring(index2-1).equals("-")||
                            stringBuilder1.substring(index2-1).equals("*")||
                            stringBuilder1.substring(index2-1).equals("÷")
                    ){
                        Toast.makeText(this,"输入违法，禁止连续输入操作符，请输入数字后进行运算。", Toast.LENGTH_LONG).show();
                        return;

                    }
                }
                opratorCalc(operatorNumber,"÷");
                lastIsOperator = true;
                et_calc.setText(et_calc.getText() + "÷");
                lastOperators = "÷";
                break;


            case R.id.bt_mult:
                if ((TextUtils.isEmpty(et_calc.getText())//TextUtils.isEmpty  字符串判断是否为空 是返回true
                        || lastIsOperator) && !lastOperators.equals("=")) {
                    int index2 = currentText.lastIndexOf(operatorNumber);
                    StringBuffer stringBuilder1 = new StringBuffer(currentText);
                    if(stringBuilder1.length()<1){
                        return;
                    }
                    //用于判断前一个字符是否为操作符 是则重新输入
                    if(stringBuilder1.substring(index2-1).equals("+")||
                            stringBuilder1.substring(index2-1).equals("-")||
                            stringBuilder1.substring(index2-1).equals("*")||
                            stringBuilder1.substring(index2-1).equals("÷")
                    ){
                        Toast.makeText(this,"输入违法，禁止连续输入操作符，请输入数字后进行运算。", Toast.LENGTH_LONG).show();
                        return;

                    }
                }
                 opratorCalc(operatorNumber,"*");
                lastIsOperator = true;
                et_calc.setText(et_calc.getText() + "*");
                lastOperators = "*";
                break;
            case R.id.bt_minus:

                if ((TextUtils.isEmpty(et_calc.getText())//TextUtils.isEmpty  字符串判断是否为空 是返回true
                        || lastIsOperator) && !lastOperators.equals("=")) {
                    int index2 = currentText.lastIndexOf(operatorNumber);
                    StringBuffer stringBuilder1 = new StringBuffer(currentText);

                    //用于判断前一个字符是否为操作符 是则重新输入
                    if(stringBuilder1.length()<1){
                        stringBuilder1.insert(index2, "-");
                        et_calc.setText(stringBuilder1);
                        lastOperators = "";
                        lastIsOperator = false;
                        return;
                    }
                    if(stringBuilder1.substring(index2-1).equals("+")||
                            stringBuilder1.substring(index2-1).equals("-")||
                            stringBuilder1.substring(index2-1).equals("*")||
                            stringBuilder1.substring(index2-1).equals("÷")
                    ){
                        Toast.makeText(this,"输入违法，禁止连续输入操作符，请输入数字后进行运算。", Toast.LENGTH_LONG).show();
                        return;

                    }

                    stringBuilder1.insert(index2, "-");
                    et_calc.setText(stringBuilder1);
                    lastOperators = "";
                    lastIsOperator = false;
                    return;
                }
                opratorCalc(operatorNumber,"-");
                lastIsOperator = true;
                et_calc.setText(et_calc.getText() + "-");
                lastOperators = "-";
                break;
            case R.id.bt_plus:
                if ((TextUtils.isEmpty(et_calc.getText())//TextUtils.isEmpty  字符串判断是否为空 是返回true
                        || lastIsOperator) && !lastOperators.equals("=")) {
                    int index2 = currentText.lastIndexOf(operatorNumber);
                    StringBuffer stringBuilder1 = new StringBuffer(currentText);
                    if(stringBuilder1.length()<1){

                        return;
                    }
                    //用于判断前一个字符是否为操作符 是则重新输入
                    if(stringBuilder1.substring(index2-1).equals("+")||
                            stringBuilder1.substring(index2-1).equals("-")||
                            stringBuilder1.substring(index2-1).equals("*")||
                            stringBuilder1.substring(index2-1).equals("÷")
                    ){
                        Toast.makeText(this,"输入违法，禁止连续输入操作符，请输入数字后进行运算。", Toast.LENGTH_LONG).show();
                        return;

                    }
                }
                opratorCalc(operatorNumber,"+");
                lastIsOperator = true;
                et_calc.setText(et_calc.getText() + "+");
                lastOperators = "+";
                break;
            case R.id.bt_equal:
                double result = 0D;
                //TextUtils.isEmpty  字符串判断是否为空 是返回true
                if ((TextUtils.isEmpty(et_calc.getText())//TextUtils.isEmpty  字符串判断是否为空 是返回true
                        || lastIsOperator)) {
                    int index2 = currentText.lastIndexOf(operatorNumber);
                    StringBuffer stringBuilder1 = new StringBuffer(currentText);
                    if(stringBuilder1.length()<1){
                        return;
                    }
                    //用于判断前一个字符是否为操作符 是则重新输入
                    if(stringBuilder1.substring(index2-1).equals("+")||
                            stringBuilder1.substring(index2-1).equals("-")||
                            stringBuilder1.substring(index2-1).equals("*")||
                            stringBuilder1.substring(index2-1).equals("÷")
                    ){
                        Toast.makeText(this,"输入违法，禁止连续输入操作符，请输入数字后进行运算。", Toast.LENGTH_LONG).show();
                        return;

                    }
                }
                opratorResult(operatorNumber);
                //operatorNumber 第二个操作数   opratorResult()送入第二个数并计算 把最后结果更新到fistNUm
                sencondNumber = 0D;
                lastOperators ="=";
                lastIsOperator = true;
                et_calc.setText(et_calc.getText() + "\n=" + String.valueOf(firstNumber));
                break;
        }
    }
// 计算
    private void operate(String operatorNumber)
    {
        if(sencondNumber != 0D)
        {
            if(lastOperators.equals("÷"))
            {
                if(Double.parseDouble(operatorNumber)==0){
                et_calc.setText("");
                operatorNumbers.clear();
                operators.clear();
                Toast.makeText(this,"除数不能为0，请重新输入", Toast.LENGTH_LONG).show();
            }
                sencondNumber = sencondNumber / Double.parseDouble(operatorNumber);
                firstNumber = firstNumber / sencondNumber;
            }
            else if(lastOperators.equals("*"))
            {
                sencondNumber = sencondNumber * Double.parseDouble(operatorNumber);
                firstNumber = firstNumber * sencondNumber;
            }
            else if(lastOperators.equals("+"))
            {
                sencondNumber = Double.parseDouble(operatorNumber);
                firstNumber = firstNumber + sencondNumber;
            }
            else if(lastOperators.equals("-"))
            {
                sencondNumber = Double.parseDouble(operatorNumber);
                firstNumber = firstNumber - sencondNumber;
            }
        }
        else
        {
            if(lastOperators.equals("÷"))
            {
                if(Double.parseDouble(operatorNumber)==0){
                    et_calc.setText("");
                    operatorNumbers.clear();
                    operators.clear();
                    Toast.makeText(this,"除数不能为0，请重新输入", Toast.LENGTH_LONG).show();
                    return;
                }
                firstNumber = firstNumber / Double.parseDouble(operatorNumber);
            }
            else if(lastOperators.equals("*"))
            {
                firstNumber = firstNumber * Double.parseDouble(operatorNumber);
            }
            else if(lastOperators.equals("+"))
            {
                firstNumber = firstNumber + Double.parseDouble(operatorNumber);
            }
            else if(lastOperators.equals("-"))
            {
                firstNumber= firstNumber - Double.parseDouble(operatorNumber);
            }


        }
    }
    public void opratorResult(String operatorNumber)
    {
        operate(operatorNumber);

    }
    public void opratorCalc(String operatorNumber,String currentOprator)
    {
        if(TextUtils.isEmpty(lastOperators))
        {
            firstNumber = Double.parseDouble(operatorNumber);
            return;
        }

        if(lastOperators.equals(currentOprator))
        {
            if(lastOperators.equals("÷"))
            {

                firstNumber = firstNumber / Double.parseDouble(operatorNumber);
            }
            else if(lastOperators.equals("*"))
            {
                firstNumber = firstNumber * Double.parseDouble(operatorNumber);
            }
            else if(lastOperators.equals("+"))
            {
                firstNumber = firstNumber + Double.parseDouble(operatorNumber);
            }
            else if(lastOperators.equals("-"))
            {
                firstNumber = firstNumber - Double.parseDouble(operatorNumber);
            }

            return;
        }
        operate(operatorNumber);

    }

}




