package com.devpk.homeautomation;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.devpk.homeautomation.model.Root;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MyWorker extends Worker {

    private FirebaseDatabase firebaseDatabase;
    private Context ctx;

    public MyWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        ctx = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        try {
            for (int i = 0; i < 900; i++) {
                firebaseDatabase.getReference("dashboard/alive").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int value = Integer.parseInt(snapshot.getValue().toString());
                        if (value == 1) {
                            //Alive = on
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    //Please turned off now
                                    firebaseDatabase.getReference("dashboard/alive")
                                            .setValue(0).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    Log.i("Iphone "," Successful " );
                                                }
                                            });
                                }
                            }, 60000);

                        } else {
                            //Alive = off
                            //Notification Start Configure the channel
                            int importance = NotificationManager.IMPORTANCE_HIGH;
                            NotificationChannel channel = null;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                channel = new NotificationChannel("myChannelId",
                                        "My Channel", importance);
                                channel.setDescription("Reminders");
                            }
                            // Register the channel with the notifications manager
                            NotificationManager mNotificationManager =
                                    (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                mNotificationManager.createNotificationChannel(channel);
                            }
                            // Builder class for devices targeting API 26+ requires a channel ID
                            NotificationCompat.Builder mBuilder =
                                    new NotificationCompat.Builder(ctx, "myChannelId")
                                            .setSmallIcon(R.mipmap.ic_launcher_round)
                                            .setContentTitle("Home Automation")
                                            .setContentText("Your device has been turned off");

                            // mId allows you to update the notification later on.
                            mNotificationManager.notify(107, mBuilder.build());
                            //Notification End

                        }


                        Log.i("Checking ", "" + snapshot.getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                firebaseDatabase.getReference().addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Gson gson = new Gson();
                        String dashboard = gson.toJson(snapshot.child("dashboard").getValue());
                        String settings = gson.toJson(snapshot.child("settings").getValue());

                        //Gas Limit
                        try {
                            JSONObject jsonDashboard = new JSONObject(dashboard);
                            JSONObject jsonSettings = new JSONObject(settings);
                            if (jsonSettings.getInt("gas_limit") > jsonDashboard.getInt("gas")) {
                                //Notification Start Configure the channel
                                int importance = NotificationManager.IMPORTANCE_HIGH;
                                NotificationChannel channel = null;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    channel = new NotificationChannel("myChannelId",
                                            "My Channel", importance);
                                    channel.setDescription("Reminders");
                                }
                                // Register the channel with the notifications manager
                                NotificationManager mNotificationManager =
                                        (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    mNotificationManager.createNotificationChannel(channel);
                                }
                                // Builder class for devices targeting API 26+ requires a channel ID
                                NotificationCompat.Builder mBuilder =
                                        new NotificationCompat.Builder(ctx, "myChannelId")
                                                .setSmallIcon(R.mipmap.ic_launcher_round)
                                                .setContentTitle("Home Automation")
                                                .setContentText("Gas Limit Increase");

                                // mId allows you to update the notification later on.
                                mNotificationManager.notify(101, mBuilder.build());
                                //Notification End

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //humidity_inside_limit
                        try {
                            JSONObject jsonDashboard = new JSONObject(dashboard);
                            JSONObject jsonSettings = new JSONObject(settings);
                            if (jsonSettings.getInt("humidity_inside_limit") >
                                    jsonDashboard.getInt("humidity_inside")) {
                                //Notification Start Configure the channel
                                int importance = NotificationManager.IMPORTANCE_HIGH;
                                NotificationChannel channel = null;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    channel = new NotificationChannel("myChannelId",
                                            "My Channel", importance);
                                    channel.setDescription("Reminders");
                                }
                                // Register the channel with the notifications manager
                                NotificationManager mNotificationManager =
                                        (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    mNotificationManager.createNotificationChannel(channel);
                                }
                                // Builder class for devices targeting API 26+ requires a channel ID
                                NotificationCompat.Builder mBuilder =
                                        new NotificationCompat.Builder(ctx, "myChannelId")
                                                .setSmallIcon(R.mipmap.ic_launcher_round)
                                                .setContentTitle("Home Automation")
                                                .setContentText("Humidity Inside Limit Increase");

                                // mId allows you to update the notification later on.
                                mNotificationManager.notify(102, mBuilder.build());
                                //Notification End

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //humidity_outside_limit
                        try {
                            JSONObject jsonDashboard = new JSONObject(dashboard);
                            JSONObject jsonSettings = new JSONObject(settings);
                            if (jsonSettings.getInt("humidity_outside_limit") >
                                    jsonDashboard.getInt("humidity_outside")) {
                                //Notification Start Configure the channel
                                int importance = NotificationManager.IMPORTANCE_HIGH;
                                NotificationChannel channel = null;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    channel = new NotificationChannel("myChannelId",
                                            "My Channel", importance);
                                    channel.setDescription("Reminders");
                                }
                                // Register the channel with the notifications manager
                                NotificationManager mNotificationManager =
                                        (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    mNotificationManager.createNotificationChannel(channel);
                                }
                                // Builder class for devices targeting API 26+ requires a channel ID
                                NotificationCompat.Builder mBuilder =
                                        new NotificationCompat.Builder(ctx, "myChannelId")
                                                .setSmallIcon(R.mipmap.ic_launcher_round)
                                                .setContentTitle("Home Automation")
                                                .setContentText("Humidity Outside Limit Increase");

                                // mId allows you to update the notification later on.
                                mNotificationManager.notify(103, mBuilder.build());
                                //Notification End

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //temperature_inside_limit
                        try {
                            JSONObject jsonDashboard = new JSONObject(dashboard);
                            JSONObject jsonSettings = new JSONObject(settings);
                            if (jsonSettings.getInt("temperature_inside_limit") >
                                    jsonDashboard.getInt("temperature_inside")) {
                                //Notification Start Configure the channel
                                int importance = NotificationManager.IMPORTANCE_HIGH;
                                NotificationChannel channel = null;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    channel = new NotificationChannel("myChannelId",
                                            "My Channel", importance);
                                    channel.setDescription("Reminders");
                                }
                                // Register the channel with the notifications manager
                                NotificationManager mNotificationManager =
                                        (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    mNotificationManager.createNotificationChannel(channel);
                                }
                                // Builder class for devices targeting API 26+ requires a channel ID
                                NotificationCompat.Builder mBuilder =
                                        new NotificationCompat.Builder(ctx, "myChannelId")
                                                .setSmallIcon(R.mipmap.ic_launcher_round)
                                                .setContentTitle("Home Automation")
                                                .setContentText("Temperature Inside Limit Increase");

                                // mId allows you to update the notification later on.
                                mNotificationManager.notify(104, mBuilder.build());
                                //Notification End

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //temperature_outside_limit
                        try {
                            JSONObject jsonDashboard = new JSONObject(dashboard);
                            JSONObject jsonSettings = new JSONObject(settings);
                            if (jsonSettings.getInt("temperature_outside_limit") >
                                    jsonDashboard.getInt("temperature_outside")) {
                                //Notification Start Configure the channel
                                int importance = NotificationManager.IMPORTANCE_HIGH;
                                NotificationChannel channel = null;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    channel = new NotificationChannel("myChannelId",
                                            "My Channel", importance);
                                    channel.setDescription("Reminders");
                                }
                                // Register the channel with the notifications manager
                                NotificationManager mNotificationManager =
                                        (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    mNotificationManager.createNotificationChannel(channel);
                                }
                                // Builder class for devices targeting API 26+ requires a channel ID
                                NotificationCompat.Builder mBuilder =
                                        new NotificationCompat.Builder(ctx, "myChannelId")
                                                .setSmallIcon(R.mipmap.ic_launcher_round)
                                                .setContentTitle("Home Automation")
                                                .setContentText("Temperature Outside Limit Increase");

                                // mId allows you to update the notification later on.
                                mNotificationManager.notify(105, mBuilder.build());
                                //Notification End

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //water_max_limit
                        try {
                            JSONObject jsonDashboard = new JSONObject(dashboard);
                            JSONObject jsonSettings = new JSONObject(settings);
                            if (jsonSettings.getInt("water_level_max") <
                                    jsonDashboard.getInt("water")) {
                                //Notification Start Configure the channel
                                int importance = NotificationManager.IMPORTANCE_HIGH;
                                NotificationChannel channel = null;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    channel = new NotificationChannel("myChannelId",
                                            "My Channel", importance);
                                    channel.setDescription("Reminders");
                                }
                                // Register the channel with the notifications manager
                                NotificationManager mNotificationManager =
                                        (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    mNotificationManager.createNotificationChannel(channel);
                                }
                                // Builder class for devices targeting API 26+ requires a channel ID
                                NotificationCompat.Builder mBuilder =
                                        new NotificationCompat.Builder(ctx, "myChannelId")
                                                .setSmallIcon(R.mipmap.ic_launcher_round)
                                                .setContentTitle("Home Automation")
                                                .setContentText("Water Limit Increase");

                                // mId allows you to update the notification later on.
                                mNotificationManager.notify(105, mBuilder.build());
                                //Notification End

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //water_min_limit
                        try {
                            JSONObject jsonDashboard = new JSONObject(dashboard);
                            JSONObject jsonSettings = new JSONObject(settings);
                            if (jsonSettings.getInt("water_level_min") > jsonDashboard.getInt("water")) {
                                //Notification Start Configure the channel
                                int importance = NotificationManager.IMPORTANCE_HIGH;
                                NotificationChannel channel = null;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    channel = new NotificationChannel("myChannelId",
                                            "My Channel", importance);
                                    channel.setDescription("Reminders");
                                }
                                // Register the channel with the notifications manager
                                NotificationManager mNotificationManager =
                                        (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    mNotificationManager.createNotificationChannel(channel);
                                }
                                // Builder class for devices targeting API 26+ requires a channel ID
                                NotificationCompat.Builder mBuilder =
                                        new NotificationCompat.Builder(ctx, "myChannelId")
                                                .setSmallIcon(R.mipmap.ic_launcher_round)
                                                .setContentTitle("Home Automation")
                                                .setContentText("Water Limit Decrease");

                                // mId allows you to update the notification later on.
                                mNotificationManager.notify(105, mBuilder.build());
                                //Notification End

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                Thread.sleep(60000);
            }
        } catch (Exception e) {
            Log.i("Checking ", " " + e);
        }

        return Result.success();
    }
}
