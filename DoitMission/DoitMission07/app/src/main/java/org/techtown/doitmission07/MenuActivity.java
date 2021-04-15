package org.techtown.doitmission07;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        makeReturnIntent(button, "고객");
        makeReturnIntent(button2, "매출");
        makeReturnIntent(button3, "상품");
    }

    private void makeReturnIntent(Button button, String returnValue) {
        button.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("menu", returnValue + " 관리");
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });
    }
}