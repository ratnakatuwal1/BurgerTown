package com.ratna.burgertown;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VegBurgerFragment extends Fragment {
    LinearLayout saladLayout, baconLayout, cheeseLayout, PattyLayout;
    CardView addSalad, removeSalad, addCarrotBacon, removeCarrotBacon, addCheese, removeCheese, addPatty, removePatty;
    Button orderButton;
    TextView totalPriceText;
    int bunPrice = 55;
    int saladPrice = 10;
    int carrotBaconPrice = 10;
    int cheesePrice = 20;
    int pattyPrice = 15;
    int totalPrice;
    int saladCount = 0;
    int carrotBaconCount = 0;
    int cheeseCount = 0;
    int pattyCount = 0;

    public VegBurgerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_veg_burger, container, false);
    }
}