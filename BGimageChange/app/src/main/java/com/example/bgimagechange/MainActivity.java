package com.example.bgimagechange;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    View screenView;
    int[] back_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // array creation of images which are stored
        // in drawable folder under res folder
        back_images = new int[]{R.drawable.a,R.drawable.e};
        button = findViewById(R.id.Button);
        screenView = findViewById(R.id.relative_layout);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // fetching length of array
                int array_length = back_images.length;

                // object creation of random class
                Random random = new Random();

                // generation of random number
                int random_number = random.nextInt(array_length);

                // set background images on screenView
                // using setBackground() method.
                screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), back_images[random_number]));
            }
        });
    }
}
