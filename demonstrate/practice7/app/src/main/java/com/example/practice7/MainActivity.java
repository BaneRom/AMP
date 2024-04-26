package com.example.practice7;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        ImageView imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        // Button click listener
        button.setOnClickListener(v -> textView.setText("Button clicked"));

        // Button long click listener
        button.setOnLongClickListener(v -> {
            textView.setText("Button long clicked");
            return true;
        });

        // Image touch listener
        imageView.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    textView.setText("Image touch down");
                    break;
                case MotionEvent.ACTION_UP:
                    textView.setText("Image touch up");
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    textView.setText("Image pointer down");
                    break;
            }
            return true;
        });

        // Edit Text key listener
        editText.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                String text = editText.getText().toString();
                if (!text.isEmpty()) {
                    textView.setText("Entered text: " + text);
                    editText.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Please enter text", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
            return false;
        });
    }
}