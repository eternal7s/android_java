package org.techtown.graphics.custom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.techtown.graphics.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomView view = new CustomView(this);
        setContentView(view);
    }
}