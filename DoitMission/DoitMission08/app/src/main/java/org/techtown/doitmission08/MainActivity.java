package org.techtown.doitmission08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_CODE_MENU  = 100;

    EditText usernameInput;
    EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);

        Button button = findViewById(R.id.loginButton);
        button.setOnClickListener(v -> {
            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();
            if (!loginValidation(username, password)) return;

            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("password", password);
            startActivityForResult(intent, REQUEST_CODE_MENU);
        });

    }

    private boolean loginValidation(String username, String password) {
        boolean validation = true;
        if (username == null || "".equals(username)) {
            Toast.makeText(this, "사용자명 입력해주세요!", Toast.LENGTH_LONG).show();
            validation = false;
        }
        if (password == null || "".equals(password)) {
            Toast.makeText(this, "비밀번호를 입력해주세요!", Toast.LENGTH_LONG).show();
            validation = false;
        }
        return validation;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MENU) {
            if (data != null) {
                String menu = data.getStringExtra("menu");
                String message = data.getStringExtra("message");

                Toast toast = Toast.makeText(getBaseContext(), "result code : " + resultCode + ", menu : " + menu + ", message : " + message, Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}