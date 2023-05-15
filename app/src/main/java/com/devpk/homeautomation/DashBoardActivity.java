package com.devpk.homeautomation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatToggleButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DashBoardActivity extends AppCompatActivity {

    private AppCompatToggleButton textFans, textLights, textLock, textWaterPump;
    private TextView textAlive, textGas, textHumidity_inside,
            textHumidity_outside, textTemperature_inside,
            textTemperature_inside_limit, textTemperature_outside, textTemperature_outside_limit, textWater;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        textAlive = findViewById(R.id.textAlive);
        textWaterPump = findViewById(R.id.textWaterPump);
        textFans = findViewById(R.id.textFans);
        textGas = findViewById(R.id.textGas);
        textHumidity_inside = findViewById(R.id.textHumidity_inside);
        textHumidity_outside = findViewById(R.id.textHumidity_outside);
        textLights = findViewById(R.id.textLights);
        textLock = findViewById(R.id.textLock);
        textTemperature_inside = findViewById(R.id.textTemperature_inside);
        //textTemperature_inside_limit = findViewById(R.id.textTemperature_inside_limit);
        textTemperature_outside = findViewById(R.id.textTemperature_outside);
        //textTemperature_outside_limit = findViewById(R.id.textTemperature_outside_limit);
        textWater = findViewById(R.id.textWater);

        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef1 = firebaseDatabase.getReference("dashboard/alive");
        DatabaseReference myRef2 = firebaseDatabase.getReference("dashboard/fans");
        DatabaseReference myRef3 = firebaseDatabase.getReference("dashboard/gas");
        DatabaseReference myRef4 = firebaseDatabase.getReference("dashboard/humidity_inside");
        DatabaseReference myRef5 = firebaseDatabase.getReference("dashboard/humidity_outside");
        DatabaseReference myRef6 = firebaseDatabase.getReference("dashboard/lights");
        DatabaseReference myRef7 = firebaseDatabase.getReference("dashboard/lock");
        DatabaseReference myRef8 = firebaseDatabase.getReference("dashboard/temperature_inside");
        DatabaseReference myRef9 = firebaseDatabase.getReference("dashboard/temperature_inside_limit");
        DatabaseReference myRef10 = firebaseDatabase.getReference("dashboard/temperature_outside");
        DatabaseReference myRef11 = firebaseDatabase.getReference("dashboard/temperature_outside_limit");
        DatabaseReference myRef12 = firebaseDatabase.getReference("dashboard/water");
        DatabaseReference myRef13 = firebaseDatabase.getReference("dashboard/waterpump");


        textWaterPump.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked == true) {
                    myRef13.setValue(1);
                } else {
                    myRef13.setValue(0);
                }
            }
        });

        myRef13.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer val = dataSnapshot.getValue(Integer.class);
                if (val.equals(0)) {
                    textWaterPump.setChecked(false);
                    textAlive.setTextColor(Color.parseColor("#FF0000"));
                } else {
                    textAlive.setTextColor(Color.parseColor("#00ff00"));
                    textWaterPump.setChecked(true);
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(DashBoardActivity.this, "Failed to read value. " + error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        textFans.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked == true) {
                    myRef2.setValue(1);
                } else {
                    myRef2.setValue(0);
                }
            }
        });


        // Read from the database
        myRef1.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer val = dataSnapshot.getValue(Integer.class);
                if (val.equals(0)) {
                    textAlive.setTextColor(Color.parseColor("#FF0000"));
                    textAlive.setText("" + 0);
                } else {
                    textAlive.setTextColor(Color.parseColor("#00ff00"));
                    textAlive.setText("" + 1);
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(DashBoardActivity.this, "Failed to read value. " + error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        // Read from the database
        myRef2.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer val = dataSnapshot.getValue(Integer.class);
                if (val.equals(0)) {
                    textFans.setChecked(false);
                    textFans.setTextColor(Color.parseColor("#FF0000"));
                } else {
                    textFans.setChecked(true);
                    textFans.setTextColor(Color.parseColor("#00ff00"));
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(DashBoardActivity.this, "Failed to read value. " + error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        // Read from the database
        myRef3.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Float val = dataSnapshot.getValue(Float.class);
                textGas.setText("" + val);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(DashBoardActivity.this, "Failed to read value. " + error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        // Read from the database
        myRef4.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Float val = dataSnapshot.getValue(Float.class);
                textHumidity_inside.setText("" + val);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(DashBoardActivity.this, "Failed to read value. " + error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        // Read from the database
        myRef5.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Float val = dataSnapshot.getValue(Float.class);
                textHumidity_outside.setText("" + val);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(DashBoardActivity.this, "Failed to read value. " + error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        textLights.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked == true) {
                    myRef6.setValue(1);
                } else {
                    myRef6.setValue(0);
                }
            }
        });

        // Read from the database
        myRef6.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer val = dataSnapshot.getValue(Integer.class);
                if (val.equals(0)) {
                    textLights.setTextColor(Color.parseColor("#FF0000"));
                    textLights.setChecked(false);
                } else {
                    textLights.setTextColor(Color.parseColor("#00ff00"));
                    textLights.setChecked(true);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(DashBoardActivity.this, "Failed to read value. " + error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        textLock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked == true) {
                    myRef7.setValue(1);
                } else {
                    myRef7.setValue(0);
                }
            }
        });


        // Read from the database
        myRef7.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer val = dataSnapshot.getValue(Integer.class);
                if (val.equals(0)) {
                    textLock.setChecked(false);
                    textLock.setTextColor(Color.parseColor("#FF0000"));
                    textLock.setText("OFF");
                } else {
                    textLock.setChecked(true);
                    textLock.setTextColor(Color.parseColor("#00ff00"));
                    textLock.setText("ON");
                }


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(DashBoardActivity.this, "Failed to read value. " + error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        // Read from the database
        myRef8.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Float val = dataSnapshot.getValue(Float.class);
                textTemperature_inside.setText("" + val);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(DashBoardActivity.this, "Failed to read value. " + error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        // Read from the database
        myRef9.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Float val = dataSnapshot.getValue(Float.class);
                //textTemperature_inside_limit.setText("" + val);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(DashBoardActivity.this, "Failed to read value. " + error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        // Read from the database
        myRef10.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Float val = dataSnapshot.getValue(Float.class);
                textTemperature_outside.setText("" + val);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(DashBoardActivity.this, "Failed to read value. " + error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        // Read from the database
        myRef11.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Float val = dataSnapshot.getValue(Float.class);
                // textTemperature_outside_limit.setText("" + val);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(DashBoardActivity.this, "Failed to read value. " + error.toException(), Toast.LENGTH_SHORT).show();
            }
        });


        // Read from the database
        myRef12.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Float val = dataSnapshot.getValue(Float.class);
                textWater.setText("" + val);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(DashBoardActivity.this, "Failed to read value. " + error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}