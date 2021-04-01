package org.techtown.doitmission_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView, imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
    }

    public void onButton1Clicked(View view) {
        imageView.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
    }

    public void onButton2Clicked(View view) {
        imageView.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.VISIBLE);
    }

}