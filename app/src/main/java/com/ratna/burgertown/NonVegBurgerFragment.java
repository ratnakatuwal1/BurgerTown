package com.ratna.burgertown;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class NonVegBurgerFragment extends Fragment {
    LinearLayout saladLayout, baconLayout, cheeseLayout, meatLayout;
    CardView addSalad, removeSalad, addBacon, removeBacon, addCheese, removeCheese, addMeat, removeMeat;

    AlertDialog alert;
    Button orderButton;
    TextView totalPriceText;
    int bunPrice = 55;
    int saladPrice = 10;
    int baconPrice = 15;
    int cheesePrice = 20;
    int meatPrice = 25;
    int totalPrice;
    int saladCount = 0;
    int baconCount = 0;
    int cheeseCount = 0;
    int meatCount = 0;

    public NonVegBurgerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_non_veg_burger, container, false);
        saladLayout = view.findViewById(R.id.saladLayout);
        baconLayout = view.findViewById(R.id.baconLayout);
        cheeseLayout = view.findViewById(R.id.cheeseLayout);
        meatLayout = view.findViewById(R.id.meatLayout);
        addSalad = view.findViewById(R.id.addSalad);
        removeSalad = view.findViewById(R.id.removeSalad);
        addBacon = view.findViewById(R.id.addBacon);
        removeBacon = view.findViewById(R.id.removeBacon);
        addCheese = view.findViewById(R.id.addCheese);
        removeCheese = view.findViewById(R.id.removeCheese);
        addMeat = view.findViewById(R.id.addMeat);
        removeMeat = view.findViewById(R.id.removeMeat);
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

        addBacon.setOnClickListener(view1 -> {
            baconCount++;
            changeBacon();
        });

        removeBacon.setOnClickListener(view1 -> {
            baconCount--;
            if (baconCount < 0) {
                baconCount = 0;
            }
            changeBacon();
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

        addMeat.setOnClickListener(view1 -> {
            meatCount++;
            changeMeat();
        });

        removeMeat.setOnClickListener(view1 -> {
            meatCount--;
            if (meatCount < 0) {
                meatCount = 0;
            }
            changeMeat();
        });



        orderButton.setOnClickListener(view1 -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Order Confirmation");
            builder.setCancelable(false);

            LayoutInflater layoutInflater = getLayoutInflater();
            View view2 = layoutInflater.inflate(R.layout.item_ordered_non_veg, null);

            TextView saladQuantity = view2.findViewById(R.id.sQty);
            saladQuantity.setText(String.valueOf(saladCount));

            TextView saladPriceText = view2.findViewById(R.id.saladPrice);
            saladPriceText.setText(String.valueOf(saladCount * saladPrice));

            TextView baconQuantity = view2.findViewById(R.id.bQty);
            baconQuantity.setText(String.valueOf(baconCount));

            TextView baconPriceText = view2.findViewById(R.id.beaconPrice);
            baconPriceText.setText(String.valueOf(baconCount * baconPrice));

            TextView cheeseQuantity = view2.findViewById(R.id.cQty);
            cheeseQuantity.setText(String.valueOf(cheeseCount));

            TextView cheesePriceText = view2.findViewById(R.id.CheesePrice);
            cheesePriceText.setText(String.valueOf(cheeseCount * cheesePrice));

            TextView meatQuantity = view2.findViewById(R.id.mQty);
            meatQuantity.setText(String.valueOf(meatCount));

            TextView meatPriceText = view2.findViewById(R.id.meatPrice);
            meatPriceText.setText(String.valueOf(meatCount * meatPrice));

            TextView totalPriceText = view2.findViewById(R.id.totalPrice);
            totalPriceText.setText("Total Price: " + (bunPrice + totalPrice));



            DatePicker datePicker = view2.findViewById(R.id.orderDate);

            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                    Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                }
            });


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

    private void resetValues() {
        saladCount = 0;
        baconCount = 0;
        cheeseCount = 0;
        meatCount = 0;
        totalPrice = 0;
        changeSalad();
        changeBacon();
        changeCheese();
        changeMeat();
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

    void changeBacon() {
        baconLayout.removeAllViews();
        for (int i = 0; i < baconCount; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(R.drawable.bacon_shape);
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

            imageView.setLayoutParams(params);
            baconLayout.addView(imageView);
        }
        updateTotalPrice();
    }

    void changeCheese() {
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

    void changeMeat() {
        meatLayout.removeAllViews();
        for (int i = 0; i < meatCount; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(R.drawable.meat_shape);
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
            meatLayout.addView(imageView);
        }
        updateTotalPrice();
    }

    void updateTotalPrice() {
        totalPrice = (saladCount * saladPrice) + (baconCount * baconPrice) + (cheeseCount * cheesePrice) + (meatCount * meatPrice);
        totalPriceText.setText(String.valueOf(bunPrice + totalPrice));
    }
}