package com.example.sprawdzian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

   private Button prevButton, nextButton, thisButton;
   private ImageView imageView;
   private Switch aSwitch;
   private EditText editText;
   private int current = 0, number = 0;
   private boolean isChecked = false;
   private int[] images = new int[] {R.drawable.kot1, R.drawable.kot2,R.drawable.kot3,R.drawable.kot4,};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prevButton = findViewById(R.id.button);
        nextButton = findViewById(R.id.button2);
        thisButton = findViewById(R.id.button3);
        imageView = findViewById(R.id.imageView);
        aSwitch = findViewById(R.id.switch1);
        editText = findViewById(R.id.editTextNumber);

        if (savedInstanceState != null) {
            current = savedInstanceState.getInt("current");
            show();
        }

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prev();
            }
        });
        thisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!String.valueOf(editText.getText()).isEmpty()) {
                    number = Integer.valueOf(String.valueOf(editText.getText()));
                    if (number == 1 || number == 2 || number == 3 || number == 4) {
                        current = number - 1;
                        show();
                    }
                }
            }
        });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                changeBg();
            }
        });

    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("current", current);
    }

    void prev() {
        current --;
        if (current == -1) {
            current = 3;
        }
        show();
    }

    void next() {
        current ++;
        if (current == 4) {
            current = 0;
        }
        show();
    }
    void show() {
        imageView.setImageResource(images[current]);
    }
    void changeBg() {
        if (isChecked == false) {
            View view = findViewById(R.id.mainLayout);
            view.setBackgroundColor(getResources().getColor(R.color.bg3));
            isChecked = true;
        } else {
            View view = findViewById(R.id.mainLayout);
            view.setBackgroundColor(getResources().getColor(R.color.bg1));
            isChecked = false;
        }
    }
}