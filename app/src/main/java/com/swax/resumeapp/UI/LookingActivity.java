package com.swax.resumeapp.UI;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.swax.resumeapp.R;

public class LookingActivity extends AppCompatActivity {

    private LinearLayout lookingforButtons;
    private TextView lookingforSeattleButton;
    private TextView lookingforRemoteButton;
    private TextView lookingforStatementTextView;
    private LinearLayout lookingforOptions;
    private ImageView lookingforShow;
    private TextView lookingforLocationButton;
    private TextView lookingforHomeButton;


    private String seattleStatement;
    private String remoteStatement;

    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookingfor);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        lookingforButtons = findViewById(R.id.lookingfor_buttons);
        lookingforSeattleButton = findViewById(R.id.lookingfor_seattle_button);
        lookingforRemoteButton = findViewById(R.id.lookingfor_remote_button);
        lookingforStatementTextView = findViewById(R.id.lookingfor_statement_textview);
        lookingforOptions = findViewById(R.id.lookingfor_options);
        lookingforShow = findViewById(R.id.lookingfor_show);
        lookingforLocationButton = findViewById(R.id.show_location_button);
        lookingforHomeButton = findViewById(R.id.return_home_button);

        seattleStatement = getString(R.string.lookingfor_seattle_statement);

        remoteStatement = getString(R.string.lookingfor_remote_statement);

        getLocationAndPopulate();

        lookingforSeattleButton.setOnClickListener(view -> {
            lookingforStatementTextView.setText(seattleStatement);
        });

        lookingforRemoteButton.setOnClickListener(view -> {
           lookingforStatementTextView.setText(remoteStatement);
        });

        lookingforOptions.setOnClickListener(view -> {
            if(lookingforLocationButton.getVisibility() == View.GONE){
                lookingforLocationButton.setVisibility(View.VISIBLE);
                lookingforHomeButton.setVisibility(View.VISIBLE);
                lookingforShow.setImageResource(android.R.drawable.arrow_up_float);
            } else {
                lookingforLocationButton.setVisibility(View.GONE);
                lookingforHomeButton.setVisibility(View.GONE);
                lookingforShow.setImageResource(android.R.drawable.arrow_down_float);
            }
        });

        lookingforLocationButton.setOnClickListener(view -> {
            if(lookingforButtons.getVisibility() == View.GONE){
                lookingforButtons.setVisibility(View.VISIBLE);
                lookingforLocationButton.setText("Hide location buttons");
            } else {
                lookingforButtons.setVisibility(View.GONE);
                lookingforLocationButton.setText("Show location buttons");
            }

        });

        lookingforHomeButton.setOnClickListener(view -> {
            Intent intent = new Intent(LookingActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1332: {
                if (grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED || grantResults[1] == PackageManager.PERMISSION_GRANTED)) {
                    getLocationAndPopulate();
                } else {
                    if (lookingforButtons.getVisibility() == View.GONE) {
                        lookingforButtons.setVisibility(View.VISIBLE);
                    }
                    lookingforStatementTextView.setText(remoteStatement);
                }
                return;
            }
        }
    }

    public void getLocationAndPopulate() {

        int requestCode = 1332;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(LookingActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(LookingActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, requestCode);
        } else {
            fusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (lookingforButtons.getVisibility() == View.VISIBLE) {
                        lookingforButtons.setVisibility(View.GONE);
                    }
                    float[] result = new float[1];
                    Location.distanceBetween(47.82705, -122.28770, location.getLatitude(), location.getLongitude(), result);

                    Log.i("LookingActivity", "getLocationAndPopulate(): distanceBetween == " + result[0]);

                    if(result[0] <= 50000){
                        lookingforStatementTextView.setText(seattleStatement);
                    } else {
                        lookingforStatementTextView.setText(remoteStatement);
                    }
                }
            });
        }
    }

}