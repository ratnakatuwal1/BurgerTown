package com.ratna.burgertown;

import android.os.Bundle;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BurgerActivity extends AppCompatActivity {
    RadioButton nonVegBurgerRadioButton, vegBurgerRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_burger);
        nonVegBurgerRadioButton = findViewById(R.id.nonVegBurgerRadioButton);
        vegBurgerRadioButton = findViewById(R.id.vegBurgerRadioButton);

        nonVegBurgerRadioButton.setOnClickListener(view -> {
            NonVegBurgerFragment nonVegBurgerFragment = new NonVegBurgerFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.burgerFrame, nonVegBurgerFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        vegBurgerRadioButton.setOnClickListener(view -> {
            VegBurgerFragment vegBurgerFragment = new VegBurgerFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.burgerFrame, vegBurgerFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });
    }
}