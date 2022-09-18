package com.example.colorpicker;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout layout;
    private Slider redSlider;
    private Slider greenSlider;
    private Slider blueSlider;
    private TextView redText;
    private TextView greenText;
    private TextView blueText;
    private TextView colorBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        redSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int red = (int)value;
                int g = (int)greenSlider.getValue();
                int b = (int)blueSlider.getValue();
                String redSzoveg = String.format("Red: %d",red);
                redText.setText(redSzoveg);
                colorBox.setBackgroundColor(Color.rgb(red,g,b));
                String colorBoxSzoveg = String.format("(%d, %d, %d)",red,g,b);
                colorBox.setText(colorBoxSzoveg);

            }
        });

        greenSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int green = (int)value;
                int b = (int)blueSlider.getValue();
                int r = (int)redSlider.getValue();
                String greenSzoveg = String.format("Green: %d",green);
                greenText.setText(greenSzoveg);
                colorBox.setBackgroundColor(Color.rgb(r,green,b));
                String colorBoxSzoveg = String.format("(%d, %d, %d)",r,green,b);
                colorBox.setText(colorBoxSzoveg);
            }
        });

        blueSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int blue = (int)value;
                int r = (int)redSlider.getValue();
                int g = (int)greenSlider.getValue();
                String blueSzoveg = String.format("Blue: %d",blue);
                blueText.setText(blueSzoveg);
                colorBox.setBackgroundColor(Color.rgb(r,g,blue));
                String colorBoxSzoveg = String.format("(%d, %d, %d)",r,g,blue);
                colorBox.setText(colorBoxSzoveg);
            }
        });

        }

    private void init(){
        layout = findViewById(R.id.mainLayout);
        redSlider = findViewById(R.id.redColorSlider);
        greenSlider = findViewById(R.id.greenColorSlider);
        blueSlider = findViewById(R.id.blueColorSlider);
        redText = findViewById(R.id.redText);
        greenText = findViewById(R.id.greenText);
        blueText = findViewById(R.id.blueText);
        colorBox = findViewById(R.id.colorBox);
    }
}