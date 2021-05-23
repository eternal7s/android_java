package org.techtown.mission12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            String input = editText.getText().toString();
            sendToService(input);
        });
    }

    private void sendToService(String input) {
        Intent serviceIntent = new Intent(getApplicationContext(), MyService.class);
        serviceIntent.putExtra("command", "show");
        serviceIntent.putExtra("data", input);

        startService(serviceIntent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        processIntent(intent);
    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            String command = intent.getStringExtra("command");
            String data = intent.getStringExtra("data");

            if (data != null) {
                textView.setText("받은 결과 : " + data);
            }
        }
    }

}