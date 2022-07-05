package com.example.cmpe408assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView myResult, myInput, myCalculations; // myTextView
    float total=0; // float variable to store result
    RadioButton rdbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    // specification with main.xml textView and mydefine variables
        myResult=findViewById(R.id.resultView);// used in to print result
        myInput =findViewById(R.id.ınputView); // used in to see given input
        myCalculations=findViewById(R.id.calculationView); // used in to see last operation


    }



    // add method to proive addition operation
    public void onAdd(View view) {
        if(myInput.length()<=0){ // stop the program if there is no input and give toast message
        Toast.makeText(getApplicationContext(), "Give a input", Toast.LENGTH_LONG).show();
            return;
        }

        float tmp =Float.valueOf(myInput.getText().toString()); // convert input to float
        myCalculations.setText(myInput.getText()+"+");
       myInput.setText("");
       total = total +tmp;
       String tmpStr=String.valueOf(total);
       myResult.setText(tmpStr);

    }

    // sub method to provide subtract operation
    public void onSub(View view) {

        if(myInput.length()<=0){ // stop the program if there is no input and give toast message
            Toast.makeText(getApplicationContext(), "Give a input", Toast.LENGTH_LONG).show();
            return;
        }
        float tmp =Float.valueOf(myInput.getText().toString()); //convert input to float
        myCalculations.setText(myInput.getText()+"-");
        myInput.setText("");
        if(total>0){
            total = total - tmp;
            String tmpStr=String.valueOf(total);
            myResult.setText(tmpStr);
        }
        else if(total==0) {
            total-=tmp;
            String tmpStr=String.valueOf(total);
            myResult.setText(tmpStr);
        }
        else if(total<0){
            total=total-tmp;
            String tmpStr=String.valueOf(total);
            myResult.setText(tmpStr);
        }
    }

    // mul method to provide multiply operation
    public void onMul(View view) {
        if(myInput.length()<=0){ // stop the program if there is no input and give toast message
            Toast.makeText(getApplicationContext(), "Give a input", Toast.LENGTH_LONG).show();
            return;
        }

        float tmp =Float.valueOf(myInput.getText().toString()); //convert input to float
        myCalculations.setText("x"+myInput.getText());
        myInput.setText("");
        if(total>0){
            total = total * tmp;
        }
        else if(total==0) {
            total = tmp;
        }else{
            total = total * tmp;
        }

        String tmpStr=String.valueOf(total);
        myResult.setText(tmpStr);
    }

    // div method to provide division operation
    public void onDiv(View view) {
        if(myInput.length()<=0){ // stop the program if there is no input and give toast message
            Toast.makeText(getApplicationContext(), "Give a input", Toast.LENGTH_LONG).show();
            return;
        }

        float tmp =Float.valueOf(myInput.getText().toString()); //convert input to float
        myCalculations.setText("/"+myInput.getText());
        myInput.setText("");
        if(total>0){
            total = total / tmp;
        }
        else if(total==0) {
            total = tmp;
        }
        else{
            total = total / tmp;
        }

        String tmpStr=String.valueOf(total);
        myResult.setText(tmpStr);
    }

    // Fac method to calculate factorial of given mumber
    public void onFac(View view) {
        if(myInput.length()<=0){ // stop the program if there is no input and give toast message
            Toast.makeText(getApplicationContext(), "Give a input", Toast.LENGTH_LONG).show();
            return;
        }
        String tmpStr = myInput.getText().toString(); //putting input temporary variable
        boolean point= tmpStr.contains("."); // cheking if there is dot "." means input is  float  number
        if(point){ // ıf there is a dot "." give toast message to instead of float number to have the user enter an integer number
            Toast.makeText(getApplicationContext(), "Give integer number", Toast.LENGTH_LONG).show();
            myCalculations.setText("Give integer number");
            myInput.setText("");
            return;
        }

        int tmp =Integer.valueOf(myInput.getText().toString());

        if(tmp==0) { // number 0 ' s faktörial is 1
            myCalculations.setText(myInput.getText()+ " "+" faktorial calculated");
            myResult.setText("1");
            return;
        }
        else if (tmp<0){ // give toast message in order to take positive number
                Toast.makeText(getApplicationContext(), "Give positive number", Toast.LENGTH_LONG).show();
                myInput.setText("");
        }
        else if(tmp>0){ // calulation of faktörial giver number
            int totaltmp= 1;
            for(int i=1; i<=tmp; i++){
                totaltmp = totaltmp*i;
            }

            String tmpStr1= String.valueOf(totaltmp);
            myResult.setText(tmpStr1);
            myCalculations.setText(myInput.getText()+ " "+" faktorial calculated");
            return;
        }
    }

    // Prime method to indicate given number prime or not
    public void onPrime(View view) {
        if (myInput.length() <= 0) { // stop the program if there is no input and give toast message
            Toast.makeText(getApplicationContext(), "Give a input", Toast.LENGTH_LONG).show();
            return;
        }

        String tmpStr = myInput.getText().toString(); //putting input temporary variable
        boolean point= tmpStr.contains("."); // cheking if there is dot "." means input is  float number
        if(point){  // ıf there is a dot "." give toast message to instead of float number to have the user enter an integer number
            Toast.makeText(getApplicationContext(), "Give integer number", Toast.LENGTH_LONG).show();
            myCalculations.setText("Give integer number");
            myInput.setText("");
            return;
        }

        int tmp =Integer.valueOf(myInput.getText().toString());

        if(tmp==0 ||tmp==1) { // 0 and 1 is not prime specific case
            myCalculations.setText(myInput.getText()+ " "+" is not prime");
            myResult.setText("");
            return;
        }
        else if(tmp==2){ // 2 is prime number
            myCalculations.setText(myInput.getText()+ " "+" is  prime");
            return;
        }
        else if(tmp>2){ // prime calcutaion to understand number is prime or not
            for(int i=2;i<tmp;i++){
                if(tmp%i==0){
                    myCalculations.setText(myInput.getText()+ " "+" is not prime");
                    return;
                }
                else{
                        myCalculations.setText(myInput.getText()+ " "+" is  prime");
                        return;
                }
            }
        }
    }

    // Resetinput method  to clear myınput and mycalculataion textview
    public void onResetInput(View view) {
        myInput.setText("");
        myCalculations.setText("");
    }

    // Resetall method  to clear myınput ,result, total and mycalculataion textview
    public void onResetAll(View view) {
        myInput.setText("");
        myResult.setText("");
        myCalculations.setText("");
        total=0;
    }

    // to get number 1 from user
    public void onOne(View view) {
      myInput.setText(myInput.getText()+"1");
    }

    // to get number 2 from user
    public void onTwo(View view) {
        myInput.setText(myInput.getText()+"2");
    }

    // to get number 3 from user
    public void onThree(View view) {
        myInput.setText(myInput.getText()+"3");
    }

    // to get number 4 from user
    public void onFour(View view) {
        myInput.setText(myInput.getText()+"4");
    }

    // to get number 5 from user
    public void onFive(View view) {
        myInput.setText(myInput.getText()+"5");
    }

    // to get number 6 from user
    public void onSix(View view) {
        myInput.setText(myInput.getText()+"6");
    }

    // to get number 7 from user
    public void onSeven(View view) {
        myInput.setText(myInput.getText()+"7");
    }

    // to get number 8 from user
    public void onEight(View view) {
        myInput.setText(myInput.getText()+"8");
    }

    // to get number 9 from user
    public void onNine(View view) {
        myInput.setText(myInput.getText()+"9");
    }

    // to get number 0 from user
    public void onZero(View view) {
        myInput.setText(myInput.getText()+"0");
    }

    // to get point from user
    public void onPoint(View view) {
        myInput.setText(myInput.getText()+".");
    }

    // delete operation, delete last given char.
    public void onDelete(View view) {
        if(myInput.length()<=0){
            Toast.makeText(getApplicationContext(), "There is no input", Toast.LENGTH_LONG).show();
            myInput.setText("");
            return;
        }
        int tmp=myInput.length();
        String tmpStr = myInput.getText().toString();
        String end ="";
        end =tmpStr.substring(0, tmp-1);
        myInput.setText(end);
    }

    public void onOdevInput(View view) {
       
    }

}

