package com.example.omara.balootcounter;

import android.support.compat.R;
java.lang.ClassNotFoundException: Didn't find class "android.support.v7.internal.widget.DialogTitle"
import android.app.AlertDialog;
import android.support.v7.app.AlertDialog;
import android.app.AppOpsManager;

import android.support.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.DialogInterface;


import android.widget.TextView;
import android.widget.Toast;
import android.app.Dialog;
import android.widget.NumberPicker;
import android.widget.Button;
import com.example.omara.balootcounter.R;




import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.EditText;
import android.content.DialogInterface;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Dialog;

import android.widget.NumberPicker;

import android.widget.Button;

import com.example.omara.balootcounter.R;


public class MainActivity extends AppCompatActivity {

    int scoreRight = 0, scoreLeft = 0;
 int n,m=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

    public void enter(View view) {

        EditText EditTextUs = (EditText) findViewById(R.id.counter_us);
        String n1 = EditTextUs.getText().toString().trim();  // يطلع الطول شف لهذي حل خله تجمع الأرقام بطال مايعد الطول
        if(n1.isEmpty() || n1.length() == 0 || n1.equals("") || n1 == null)

        { n = 0;   //EditText is empty
        }
        else
        { n = Integer.parseInt(n1);  //EditText is not empty
        }
        EditText EditTextThem = (EditText) findViewById(R.id.counter_them);

        String m1 = EditTextThem.getText().toString();  // يطلع الطول شف لهذي حل خله تجمع الأرقام بطال مايعد الطول
        if(m1.isEmpty() || m1.length() == 0 || m1.equals("") || m1 == null)
        {  m =0;   //EditText is empty
        }
        else
        {m = Integer.parseInt(m1); //EditText is not empty

        }

        // end of chicking and start of counting

        scoreLeft +=n;
        scoreRight += m;

        // start of chicking if input is Right
        if(m > 148 || n > 148 || scoreLeft-n >152 || scoreRight-m >152){
            scoreLeft -=n;
            scoreRight -=m;
            n=0;
            m=0;
            AlertDialog.Builder ABuilder = new AlertDialog.Builder(MainActivity.this);
            ABuilder.setTitle("إدخال خاطأ");
            ABuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialoginterface, int i) {
                    dialoginterface.dismiss();
                }
            });
            AlertDialog dialog = ABuilder.create();
            dialog.show();
        }
        // end of chickng if input is Right

            else if(scoreRight>=152 && scoreLeft>=152){
                if(scoreRight > scoreLeft) {
                    displayLeft(scoreLeft);
                    displayRight(scoreRight);
                    EditTextThem.getText().clear();
                    EditTextUs.getText().clear();
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                    View mView = getLayoutInflater().inflate(R.layout.alert_dialog_we, null);
                    mBuilder.setPositiveButton("نعم" , new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick( DialogInterface dialoginterface , int i) {
                            resetWithoutButton();
                            dialoginterface.dismiss();}
                    });

                    mBuilder.setNegativeButton("لا" , new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick( DialogInterface dialoginterface , int i) {
                            dialoginterface.dismiss();}
                    });


                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show(); }
                else if (scoreRight < scoreLeft){


                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                    View mView = getLayoutInflater().inflate(R.layout.alert_dialog_they, null);

                    mBuilder.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialoginterface, int i) {
                            resetWithoutButton();
                            dialoginterface.dismiss();
                        }
                    });
                    mBuilder.setNegativeButton("لا", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialoginterface, int i) {
                            dialoginterface.dismiss();
                        }
                    });
                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();


                }
                else {
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                    mBuilder.setTitle("تعادل");
                    mBuilder.setMessage(" صكة جديدة ؟");
                    mBuilder.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialoginterface, int i) {
                            resetWithoutButton();
                            dialoginterface.dismiss();
                        }
                    });
                    mBuilder.setNegativeButton("لا", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialoginterface, int i) {
                            dialoginterface.dismiss();
                        }
                    });
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();
                }

            } else if(scoreLeft>=152) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.alert_dialog_they, null);

                mBuilder.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialoginterface, int i) {
                        resetWithoutButton();
                        dialoginterface.dismiss();
                    }
                });
                mBuilder.setNegativeButton("لا", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialoginterface, int i) {
                        dialoginterface.dismiss();
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }

         else if(scoreRight>=152){
                displayLeft(scoreLeft);
                displayRight(scoreRight);
                EditTextThem.getText().clear();
                EditTextUs.getText().clear();
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.alert_dialog_we, null);
                mBuilder.setPositiveButton("نعم" , new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick( DialogInterface dialoginterface , int i) {
                        resetWithoutButton();
                        dialoginterface.dismiss();}
                });

                mBuilder.setNegativeButton("لا" , new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick( DialogInterface dialoginterface , int i) {
                        dialoginterface.dismiss();}
                });


                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show(); }

            displayLeft(scoreLeft);
            displayRight(scoreRight);
            EditTextThem.getText().clear();
            EditTextUs.getText().clear();
        }

    public void back (View view){

        scoreLeft -=n;

        scoreRight -= m;

        displayLeft(scoreLeft);

        displayRight(scoreRight);

        n=0;

        m=0;}

    public void reset(View view){

        scoreRight=0;

        scoreLeft =0;

        displayLeft(scoreLeft);

        displayRight(scoreRight);


        n=0;

        m=0;}

    public void resetWithoutButton(){

        scoreRight=0;

        scoreLeft =0;

        displayLeft(scoreLeft);

        displayRight(scoreRight);


        n=0;

        m=0;}
/*
    public void weWon(){

        String we = "We Won" ;

        TextView textView =(TextView) findViewById(R.id.text);

        textView.setText(String.valueOf(we));}

    public void theyWon(){

        String they = "They Won";

        TextView textView =(TextView) findViewById(R.id.text);

        textView.setText(String.valueOf(they));}*/



    public void displayLeft(int scoreL){

        TextView teamATextView =(TextView) findViewById(R.id.SecLeft);

        teamATextView.setText(String.valueOf(scoreL));}



    public void displayRight(int scoreR){

        TextView teamBTextView =(TextView) findViewById(R.id.SecRight);

        teamBTextView.setText(String.valueOf(scoreR));}

}