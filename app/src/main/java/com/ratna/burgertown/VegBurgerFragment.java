package com.ratna.burgertown;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class VegBurgerFragment extends Fragment {
    LinearLayout saladLayout, baconLayout, cheeseLayout, PattyLayout;
    CardView addSalad, removeSalad, addCarrotBacon, removeCarrotBacon, addCheese, removeCheese, addPatty, removePatty;
    AlertDialog alert;
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
        View view = inflater.inflate(R.layout.fragment_veg_burger, container, false);
        saladLayout = view.findViewById(R.id.saladLayout);
        baconLayout = view.findViewById(R.id.baconLayout);
        cheeseLayout = view.findViewById(R.id.cheeseLayout);
        PattyLayout = view.findViewById(R.id.pattyLayout);
        addSalad = view.findViewById(R.id.addSalad);
        removeSalad = view.findViewById(R.id.removeSalad);
        addCarrotBacon = view.findViewById(R.id.addBacon);
        removeCarrotBacon = view.findViewById(R.id.removeBacon);
        addCheese = view.findViewById(R.id.addCheese);
        removeCheese = view.findViewById(R.id.removeCheese);
        addPatty = view.findViewById(R.id.addPatty);
        removePatty = view.findViewById(R.id.removePatty);
        totalPriceText = view.findViewById(R.id.totalPriceText);
        orderButton = view.findViewById(R.id.orderBtn);

        addSalad.setOnClickListener(view1 -> {
            saladCount++;
            changeSalad();
        });

        removeSalad.setOnClickListener(view1 -> {
            saladCount--;
            if (saladCount < 0) {
                saladCount = 0;
            }
            changeSalad();
        });

        addCarrotBacon.setOnClickListener(view1 -> {
            carrotBaconCount++;
            changeCarrotBacon();
        });

        removeCarrotBacon.setOnClickListener(view1 -> {
            carrotBaconCount--;
            if (carrotBaconCount < 0) {
                carrotBaconCount = 0;
            }
            changeCarrotBacon();
        });

        addCheese.setOnClickListener(view1 -> {
            cheeseCount++;
            changeCheese();
        });

        removeCheese.setOnClickListener(view1 -> {
            cheeseCount--;
            if (cheeseCount < 0) {
                cheeseCount = 0;
            }
            changeCheese();
        });

        addPatty.setOnClickListener(view1 -> {
            pattyCount++;
            changePatty();
        });

        removePatty.setOnClickListener(view1 -> {
            pattyCount--;
            if (pattyCount < 0) {
                pattyCount = 0;
            }
            changePatty();
        });

        orderButton.setOnClickListener(view1 -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Order Confirmation");
            builder.setCancelable(false);

            LayoutInflater layoutInflater = getLayoutInflater();
            View view2 = layoutInflater.inflate(R.layout.item_ordered_veg, null);

           TextView saladQuantity = view2.findViewById(R.id.sQty);
            saladQuantity.setText(String.valueOf(saladCount));

            TextView saladPriceText = view2.findViewById(R.id.saladPrice);
            saladPriceText.setText(String.valueOf(saladCount * saladPrice));

            TextView carrotBaconQuantity = view2.findViewById(R.id.bQty);
            carrotBaconQuantity.setText(String.valueOf(carrotBaconCount));

            TextView carrotBaconPriceText = view2.findViewById(R.id.beaconPrice);
            carrotBaconPriceText.setText(String.valueOf(carrotBaconCount * carrotBaconPrice));

            TextView cheeseQuantity = view2.findViewById(R.id.cQty);
            cheeseQuantity.setText(String.valueOf(cheeseCount));

            TextView cheesePriceText = view2.findViewById(R.id.CheesePrice);
            cheesePriceText.setText(String.valueOf(cheeseCount * cheesePrice));

            TextView pattyQuantity = view2.findViewById(R.id.pQty);
            pattyQuantity.setText(String.valueOf(pattyCount));

            TextView pattyPriceText = view2.findViewById(R.id.pattyPrice);
            pattyPriceText.setText(String.valueOf(pattyCount * pattyPrice));

            TextView totalPriceText = view2.findViewById(R.id.totalPrice);
            totalPriceText.setText("Total Price: " + (bunPrice + totalPrice));

            Button confirm = view2.findViewById(R.id.btnConfirm);
            confirm.setOnClickListener(view3 -> {
                Toast.makeText(getActivity(), "Order Confirmed", Toast.LENGTH_SHORT).show();
                resetValues();
                alert.dismiss();
            });

            builder.setView(view2);
            alert = builder.create();
            alert.show();
        });
        return view;
    }

    private void resetValues(){
        saladCount = 0;
        carrotBaconCount = 0;
        cheeseCount = 0;
        pattyCount = 0;
        totalPrice = 0;
        changeSalad();
        changeCarrotBacon();
        changeCheese();
        changePatty();
        totalPriceText.setText(String.valueOf(bunPrice));
    }

    void changeSalad() {
        saladLayout.removeAllViews();
        for (int i = 0; i < saladCount; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(R.drawable.salad_shape);
            int heightInPixels = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    20,
                    getResources().getDisplayMetrics()
            );
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    heightInPixels
            );
            imageView.setLayoutParams(params);
            saladLayout.addView(imageView);
        }
        updateTotalPrice();
    }

    private void changeCarrotBacon() {
        baconLayout.removeAllViews();
        for (int i = 0; i < carrotBaconCount; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(R.drawable.carrot_bacon);
            int heightInPixels = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    10,
                    getResources().getDisplayMetrics()
            );
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    heightInPixels
            );
            int marginInPixels = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    10,
                    getResources().getDisplayMetrics()
            );
            params.leftMargin = marginInPixels;
            params.rightMargin = marginInPixels;
        }
        updateTotalPrice();
    }

    private void changeCheese() {
        cheeseLayout.removeAllViews();
        for (int i = 0; i < cheeseCount; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(R.drawable.cheese_shape);
            int heightInPixels = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    15,
                    getResources().getDisplayMetrics()
            );
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    heightInPixels
            );
            imageView.setLayoutParams(params);
            cheeseLayout.addView(imageView);
        }
        updateTotalPrice();
    }

    private void changePatty() {
        PattyLayout.removeAllViews();
        for (int i = 0; i < pattyCount; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(R.drawable.veg_patty);
            int heightInPixels = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    35,
                    getResources().getDisplayMetrics()
            );
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    heightInPixels
            );
            imageView.setLayoutParams(params);
            PattyLayout.addView(imageView);
        }
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        totalPrice = (saladCount * saladPrice) + (carrotBaconCount * carrotBaconPrice) + (cheeseCount * cheesePrice) + (pattyCount * pattyPrice);
        totalPriceText.setText(String.valueOf(bunPrice + totalPrice));
    }

}