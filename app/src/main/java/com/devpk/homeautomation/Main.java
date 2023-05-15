package com.devpk.homeautomation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.TimeUnit;

public class Main extends AppCompatActivity {

    private AppCompatButton setting,dashBoard , signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        final WorkManager workManager = WorkManager.getInstance();
        final PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest
                .Builder(MyWorker.class, 1, TimeUnit.MINUTES)
                .setConstraints(new Constraints.Builder()
                        .setRequiresCharging(false)
                        .setRequiresBatteryNotLow(true)
                        .setRequiredNetworkType(NetworkType.CONNECTED)
                        .build())
                .build();

        workManager.enqueue(periodicWorkRequest);

        dashBoard = findViewById(R.id.dashBoard);
        setting = findViewById(R.id.setting);
        signout = findViewById(R.id.signout);

        dashBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, DashBoardActivity.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Main.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}