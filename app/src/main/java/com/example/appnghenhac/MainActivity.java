package com.example.appnghenhac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView txtTitle, txtTimeSong;
    Button buttonSelect, buttonPlay, buttonPause;
    int i = 0;
    ArrayList<Song>  arraySong;
    static MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Anhxa();
        addSong();

        Intent intent = getIntent();
        if(intent.getStringExtra("index")!=null){
            i = Integer.parseInt(intent.getStringExtra("index"))-1;
        }
        txtTitle.setText(arraySong.get(i).getTitle());
        mp = MediaPlayer.create(MainActivity.this, arraySong.get(i).getFile());

    }

    private void addSong() {
        arraySong = new ArrayList<>();
        arraySong.add(new Song("anh khong biet", R.raw.cuoi_luon_duoc_khong));
        arraySong.add(new Song("em la con thuyen", R.raw.em_la_con_thuyen));
        arraySong.add(new Song("masewgreat", R.raw.masewgreat));
        arraySong.add(new Song("phai nhoa cam suc", R.raw.phaii_nhoa_cam_xuc));
        arraySong.add(new Song("thay nong", R.raw.thay_long));
        arraySong.add(new Song("yeu la cuoi", R.raw.yeu_la_cuoi));
        arraySong.add(new Song("tan vo", R.raw.tan_vo));


    }

    private void Anhxa() {
        txtTimeSong     = (TextView) findViewById(R.id.TxtTime);
        txtTitle        = (TextView) findViewById(R.id.TxtTitle);
        buttonSelect    = (Button) findViewById(R.id.buttonSelect);
        buttonPlay      = (Button) findViewById(R.id.buttonPlay);
        buttonPause     = (Button) findViewById(R.id.buttonPause);

    }
    public  void onClick(View view){
        mp.stop();

        Intent i =  new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }

    public void playSong (View v){
        mp.start();
        updateTimeSong();
    }
    public void pauseSong (View v){
        mp.pause();
    }
    void updateTimeSong(){
        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat formater= new SimpleDateFormat("mm:ss");
                txtTimeSong.setText(formater.format(mp.getCurrentPosition()));
                handler.postDelayed(this,1000);
            }
        },10);
    }
}


