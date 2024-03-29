package com.richsoftware.catchthekenny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView timetext;
    TextView scoretext;
    int score;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timetext = findViewById(R.id.textView);
        scoretext = findViewById(R.id.textView2);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);


        imageArray = new ImageView[]{imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};

        hideimages();


        score = 0;

        new CountDownTimer(10000, 1000) {//Geriye Doğru Sayma Metodu
            @Override
            public void onTick(long millisUntilFinished) {
                timetext.setText("Time: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                timetext.setText("Time Off");
                handler.removeCallbacks(runnable);//Burada gelen Image leri Durduruyor
                for (ImageView image : imageArray) {//Zaman Durduğunda Imageyi Gizliyor
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Tekrar?");
                alert.setMessage("Baştan Başlatılsınmı");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //restart

                        Intent intent=getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(getApplicationContext(),Basla.class);
                        startActivity(intent);
                    }
                });
                alert.show();

            }

        }.start();

    }
    public void Score(View view) {
        score++;
        scoretext.setText("Score: " + score);

    }

    public void hideimages() {  //Random Oluştuduğumuz Dizideki İmage'ler Random Görünecekler
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageArray) {
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);

    }
    public void geri(View view){
        AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Ana Menü");
        alert.setMessage("Ana Sayfaya Dönsünmü");
        alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                Intent intent=new Intent(getApplicationContext(), Basla.class);
               startActivity(intent);
            }
        });
        alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent=getIntent();
                finish();
                startActivity(intent);
            }
        });
        alert.show();

    }


}