package com.silversquad.governmentapp.usalmanac;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button btnstart;
    EditText zipcode_tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        VideoView mvideoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.stuff123);
        mvideoview.setVideoURI(uri);
        mvideoview.start();

        mvideoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        btnstart = (Button) findViewById(R.id.startbtn);


        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int l;
                zipcode_tf = (EditText) findViewById(R.id.enterzip);

                if(zipcode_tf.length() == 5)
                {
                    l = Integer.parseInt(zipcode_tf.getText().toString());


                    Intent intent = new Intent(MainActivity.this, getinformation_activity.class);
                    intent.putExtra("code", l);
                    startActivity(intent);

                }else
                {
                    Toast.makeText(getApplicationContext(), "Please Enter a Valid Zip Code!", Toast.LENGTH_SHORT).show();
                    zipcode_tf = null;
                }

            }
        });

    }


}
