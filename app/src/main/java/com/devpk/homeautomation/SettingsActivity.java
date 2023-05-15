package com.devpk.homeautomation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SettingsActivity extends AppCompatActivity {

    private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7;
    private Button temperature_inside_limit, temperature_outside_limit,
            humidity_inside_limit, humidity_outside_limit, gas_limit, water_max_limit, water_min_limit;
    private DatabaseReference mDatabase;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference myRef1 = firebaseDatabase.getReference("settings/temperature_inside_limit");
        DatabaseReference myRef2 = firebaseDatabase.getReference("settings/temperature_outside_limit");
        DatabaseReference myRef3 = firebaseDatabase.getReference("settings/humidity_inside_limit");
        DatabaseReference myRef4 = firebaseDatabase.getReference("settings/humidity_outside_limit");
        DatabaseReference myRef5 = firebaseDatabase.getReference("settings/gas_limit");
        DatabaseReference myRef6 = firebaseDatabase.getReference("settings/water_level_max");
        DatabaseReference myRef7 = firebaseDatabase.getReference("settings/water_level_min");

        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer val = snapshot.getValue(Integer.class);
                editText1.setText("" + val);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        editText1 = findViewById(R.id.editText1);
        temperature_inside_limit = findViewById(R.id.temperature_inside_limit);
        temperature_inside_limit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                Double value = Double.valueOf(editText1.getText().toString());
                mDatabase.child("settings/temperature_inside_limit").setValue(Float.valueOf(String.format("%.2f", value)));
                editText1.setText("");
                Toast.makeText(SettingsActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }
        });

        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer val = snapshot.getValue(Integer.class);
                editText2.setText("" + val);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        editText2 = findViewById(R.id.editText2);
        temperature_outside_limit = findViewById(R.id.temperature_outside_limit);
        temperature_outside_limit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                Float value = Float.valueOf(editText2.getText().toString());
                mDatabase.child("settings/temperature_outside_limit").setValue(Float.valueOf(String.format("%.2f", value)));
                editText2.setText("");
                Toast.makeText(SettingsActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }
        });

        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer val = snapshot.getValue(Integer.class);
                editText3.setText("" + val);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        editText3 = findViewById(R.id.editText3);
        humidity_inside_limit = findViewById(R.id.humidity_inside_limit);
        humidity_inside_limit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                Double value = Double.valueOf(editText3.getText().toString());
                mDatabase.child("settings/humidity_inside_limit").setValue(Float.valueOf(String.format("%.2f", value)));
                editText3.setText("");
                Toast.makeText(SettingsActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }
        });

        myRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer val = snapshot.getValue(Integer.class);
                editText4.setText("" + val);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        editText4 = findViewById(R.id.editText4);
        humidity_outside_limit = findViewById(R.id.humidity_outside_limit);
        humidity_outside_limit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                Double value = Double.valueOf(editText4.getText().toString());
                mDatabase.child("settings/humidity_inside_limit").setValue(Float.valueOf(String.format("%.2f", value)));
                editText4.setText("");
                Toast.makeText(SettingsActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }
        });

        myRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer val = snapshot.getValue(Integer.class);
                editText5.setText("" + val);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        editText5 = findViewById(R.id.editText5);
        gas_limit = findViewById(R.id.gas_limit);
        gas_limit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                Double value = Double.valueOf(editText5.getText().toString());
                mDatabase.child("settings/gas_limit").setValue(Float.valueOf(String.format("%.2f", value)));
                editText5.setText("");
                Toast.makeText(SettingsActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }
        });

        myRef6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer val = snapshot.getValue(Integer.class);
                editText6.setText("" + val);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        editText6 = findViewById(R.id.editText6);
        water_max_limit = findViewById(R.id.water_max_limit);
        water_max_limit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                Double value = Double.valueOf(editText6.getText().toString());
                mDatabase.child("settings/water_level_max").setValue(Float.valueOf(String.format("%.2f", value)));
                editText6.setText("");
                Toast.makeText(SettingsActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }
        });

        myRef7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer val = snapshot.getValue(Integer.class);
                editText7.setText("" + val);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        editText7 = findViewById(R.id.editText7);
        water_min_limit = findViewById(R.id.water_min_limit);
        water_min_limit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                Double value = Double.valueOf(editText7.getText().toString());
                mDatabase.child("settings/water_level_min").setValue(Float.valueOf(String.format("%.2f", value)));
                editText7.setText("");
                Toast.makeText(SettingsActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }
        });

    }

}