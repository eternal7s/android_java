package org.techtown.doitmission08;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_CUSTOMER = 201;
    public static final int REQUEST_CODE_REVENUE = 202;
    public static final int REQUEST_CODE_PRODUCT = 203;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent receivedIntent = getIntent();
        String username = receivedIntent.getStringExtra("username");
        String password = receivedIntent.getStringExtra("password");

        Toast.makeText(this, "사용자명 : " + username + ", 비밀번호 : " + password, Toast.LENGTH_LONG).show();

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("message", "result message is OK!");

            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });

        Button menu01Button = findViewById(R.id.menu01Button);
        menu01Button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
            intent.putExtra("titleMsg", "고객관리 화면");

            startActivityForResult(intent, REQUEST_CODE_CUSTOMER);
        });

        Button menu02Button = findViewById(R.id.menu02Button);
        menu02Button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RevenueActivity.class);
            intent.putExtra("titleMsg", "매출관리 화면");

            startActivityForResult(intent, REQUEST_CODE_REVENUE);
        });

        Button menu03Button = findViewById(R.id.menu03Button);
        menu03Button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
            intent.putExtra("titleMsg", "상품관리 화면");

            startActivityForResult(intent, REQUEST_CODE_PRODUCT);
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (intent != null) {
            if (requestCode == REQUEST_CODE_CUSTOMER) {
                String message = intent.getStringExtra("message");

                if (message != null) {
                    Toast toast = Toast.makeText(getBaseContext(), "고객관리 응답, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
                    toast.show();
                }
            } else if (requestCode == REQUEST_CODE_REVENUE) {
                String message = intent.getStringExtra("message");

                if (message != null) {
                    Toast toast = Toast.makeText(getBaseContext(), "매출관리 응답, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
                    toast.show();
                }
            } else if (requestCode == REQUEST_CODE_PRODUCT) {
                String message = intent.getStringExtra("message");

                if (message != null) {
                    Toast toast = Toast.makeText(getBaseContext(), "상품관리 응답, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        }

    }

}