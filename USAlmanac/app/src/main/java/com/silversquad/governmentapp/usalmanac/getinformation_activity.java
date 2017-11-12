package com.silversquad.governmentapp.usalmanac;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Zaid on 11/11/2017.
 */

public class getinformation_activity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlinformation_activity);

        int r = 0;

        Intent intent = getIntent();
        Integer str = intent.getIntExtra("code", r);

        TextView tx1 = (TextView) findViewById(R.id.code_id1);
        TextView tx2 = (TextView) findViewById(R.id.code_id2);
        TextView tx3 = (TextView) findViewById(R.id.code_id3);
        TextView tx4 = (TextView) findViewById(R.id.code_id4);
        TextView tx5 = (TextView) findViewById(R.id.code_id5);
        TextView tx6 = (TextView) findViewById(R.id.code_id6);
        TextView tx7 = (TextView) findViewById(R.id.code_id7);
        TextView tx8 = (TextView) findViewById(R.id.code_id8);
        TextView tx9 = (TextView) findViewById(R.id.code_id9);
        TextView tx10 = (TextView) findViewById(R.id.code_id10);
        TextView tx11 = (TextView) findViewById(R.id.code_id11);
        TextView tx12 = (TextView) findViewById(R.id.code_id12);
        TextView tx13 = (TextView) findViewById(R.id.code_id13);
        TextView tx14 = (TextView) findViewById(R.id.code_id14);
        TextView tx15 = (TextView) findViewById(R.id.code_id15);
        TextView tx16 = (TextView) findViewById(R.id.code_id16);
        TextView tx17 = (TextView) findViewById(R.id.code_id17);
        TextView tx18 = (TextView) findViewById(R.id.code_id18);
        TextView tx19 = (TextView) findViewById(R.id.code_id19);
        TextView tx20 = (TextView) findViewById(R.id.code_id20);
        TextView tx21 = (TextView) findViewById(R.id.code_id21);
        TextView tx22 = (TextView) findViewById(R.id.code_id22);
        TextView tx23 = (TextView) findViewById(R.id.code_id23);
        TextView tx24 = (TextView) findViewById(R.id.code_id24);
        TextView tx25 = (TextView) findViewById(R.id.code_id25);
        TextView tx26 = (TextView) findViewById(R.id.code_id26);
        TextView tx27 = (TextView) findViewById(R.id.code_id27);
        TextView tx28 = (TextView) findViewById(R.id.code_id28);
        TextView tx29 = (TextView) findViewById(R.id.code_id29);
        TextView tx30 = (TextView) findViewById(R.id.code_id30);
        TextView tx31 = (TextView) findViewById(R.id.code_id31);
        TextView tx32 = (TextView) findViewById(R.id.code_id32);
        TextView tx33 = (TextView) findViewById(R.id.code_id33);
        TextView tx34 = (TextView) findViewById(R.id.code_id34);
        TextView tx35 = (TextView) findViewById(R.id.code_id35);
        TextView tx36 = (TextView) findViewById(R.id.code_id36);
        TextView tx37 = (TextView) findViewById(R.id.code_id37);
        TextView tx38 = (TextView) findViewById(R.id.code_id38);
        TextView tx39 = (TextView) findViewById(R.id.code_id39);
        TextView tx40 = (TextView) findViewById(R.id.code_id40);

        zipcode_info_activity zaid = new zipcode_info_activity(str);
        String[] ok = zaid.getSentateNum1();
        String[] ok1 = zaid.getSentateNum2();

        if(ok.length == 0)
        {
            Intent intentback = new Intent(getinformation_activity.this, MainActivity.class);
            startActivity(intentback);

            Toast.makeText(getApplicationContext(), "Please Enter A Valid Zip Code!", Toast.LENGTH_SHORT).show();
        }

        String[] output = zaid.getSentateNum1();
        String[] output1 = zaid.getSentateNum2();
        String[] output2 = zaid.getGov();
        String[] output3 = zaid.getRep();

        String zaidskreb = "";
        for(int i =0;i<output.length;i++){
            if(output[i] == output[0]) {
                tx1.setText("Senator " + output[i]);
            }
            if(output[i] == output[1]) {
                tx2.setText("Capitol Phone #: " + output[i]);
            }
            if(output[i] == output[2]) {
                tx3.setText("Fax #: " + output[i]);
            }
            if(output[i] == output[3]) {
                tx4.setText("District Phone #: " + output[i]);
            }
            if(output[i] == output[4]) {
                tx5.setText("District Fax #: " + output[i]);
            }
            if(output[i] == output[5]) {
                tx6.setText("Website: " + output[i].replace("\\", ""));
            }
            if(output[i] == output[6]) {
                tx7.setText("Econtact: " + output[i].replace("\\", ""));
            }
            if(output[i] == output[7]) {
                tx8.setText("Building : " + output[i] + ", " + output[i+2]);
            }
            if(output[i] == output[8]) {
                tx9.setText("Building Room #: " + output[i]);
            }
            if(output[i] == output[12]) {
                tx10.setText("State: " + output[i]);
            }
            //zaidskreb += output[i] + "\n";
        }
        for(int i=0; i<output1.length;i++){
            if(i == 0) {
                tx11.setText("Senator " + output1[i]);
            }
            if(i == 1) {
                tx12.setText("Capitol Phone #: " + output1[i]);
            }
            if(i == 2) {
                tx13.setText("Fax #: " + output1[i]);
            }
            if(i == 3) {
                tx14.setText("District Phone #: " + output1[i]);
            }
            if(i == 4) {
                tx15.setText("District Fax #: " + output1[i]);
            }
            if(i == 5) {
                tx16.setText("Website: " + output1[i].replace("\\", ""));
            }
            if(i == 6) {
                tx17.setText("Econtact: " + output1[i].replace("\\", ""));
            }
            if(i == 7) {
                tx18.setText("Building : " + output1[i] + ", " + output[i+2]);
            }
            if(i == 8) {
                tx19.setText("Building Room #: " + output1[i]);
            }
            if(i == 9) {
                tx20.setText("State: " + output1[i]);
            }
        }
        for(int i=0; i<output2.length;i++){
            if(i == 0) {
                tx21.setText("Governor " + output2[i]);
            }
            if(i == 1) {
                tx22.setText("Capitol Phone #: " + output2[i]);
            }
            if(i == 2) {
                tx23.setText("Fax #: " + output2[i]);
            }
            if(i == 3) {
                tx24.setText("District Phone #: " + output2[i]);
            }
            if(i == 4) {
                tx25.setText("District Fax #: " + output2[i]);
            }
            if(i == 5) {
                tx26.setText("Website: " + output2[i].replace("\\", ""));
            }
            if(i == 6) {
                tx27.setText("Econtact: " + output2[i].replace("\\", ""));
            }
            if(i == 7) {
                tx28.setText("Building : " + output2[i]  + ", " + output[i+2]);
            }
            if(i == 8) {
                tx29.setText("Building Room #: " + output2[i]);
            }
            if(i == 9) {
                tx30.setText("State: " + output2[i]);
            }
        }
        for(int i=0; i<output2.length;i++){
            if(i == 0) {
                tx31.setText("Representative " + output3[i]);
            }
            if(i == 1) {
                tx32.setText("Capitol Phone #: " + output3[i]);
            }
            if(i == 2) {
                tx33.setText("Fax #: " + output3[i]);
            }
            if(i == 3) {
                tx34.setText("District Phone #: " + output3[i]);
            }
            if(i == 4) {
                tx35.setText("District Fax #: " + output3[i]);
            }
            if(i == 5) {
                tx36.setText("Website: " + output3[i].replace("\\", ""));
            }
            if(i == 6) {
                tx37.setText("Econtact: " + output3[i].replace("\\", ""));
            }
            if(i == 7) {
                tx38.setText("Building : " + output3[i]  + ", " + output[i+2]);
            }
            if(i == 8) {
                tx39.setText("Building Room #: " + output3[i]);
            }
            if(i == 9) {
                tx40.setText("State: " + output3[i]);
            }
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intentbackbutton = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intentbackbutton);
    }
}