package com.swax.resumeapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.swax.resumeapp.R;



public class MainActivity extends AppCompatActivity {

    Context mContext;

    TextView aboutMe;

    CardView cardViewExpertise;
    ImageView showArrowExpertise;
    LinearLayout hiddenGroupExpertise;

    CardView cardViewTech;
    ImageView showArrowTech;
    LinearLayout hiddenGroupTech;

    CardView cardViewEducation;
    ImageView showArrowEducation;
    LinearLayout hiddenGroupEducation;

    TextView experienceButton;

    TextView lookingForButton;

    CardView cardViewReferences;
    ImageView showArrowReferences;
    LinearLayout hiddenGroupReferences;
    TextView scottzEmail;
    TextView scottzPhone;
    TextView joeEmail;
    TextView joePhone;
    TextView jimEmail;
    TextView jimPhone;

    CardView cardViewContact;
    ImageView showArrowContact;
    LinearLayout hiddenGroupContact;
    TextView swaxEmail;
    TextView swaxPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;

        aboutMe = findViewById(R.id.learn_more_button);

        cardViewExpertise = findViewById(R.id.cardview_expertise);
        showArrowExpertise = findViewById(R.id.expertise_show);
        hiddenGroupExpertise = findViewById(R.id.expertise_hidden_layout);

        cardViewTech = findViewById(R.id.cardview_tech);
        showArrowTech = findViewById(R.id.tech_show);
        hiddenGroupTech = findViewById(R.id.tech_hidden_layout);

        cardViewEducation = findViewById(R.id.cardview_education);
        showArrowEducation = findViewById(R.id.education_show);
        hiddenGroupEducation = findViewById(R.id.education_hidden_layout);

        experienceButton = findViewById(R.id.experience_button);

        lookingForButton = findViewById(R.id.looking_for_button);

        cardViewReferences = findViewById(R.id.cardview_references);
        showArrowReferences = findViewById(R.id.references_show);
        hiddenGroupReferences = findViewById(R.id.references_hidden_layout);
        scottzEmail = findViewById(R.id.scottz_email);
        scottzPhone = findViewById(R.id.scottz_phone);
        joeEmail = findViewById(R.id.joe_email);
        joePhone = findViewById(R.id.joe_phone);
        jimEmail = findViewById(R.id.jim_email);
        jimPhone = findViewById(R.id.jim_phone);

        cardViewContact = findViewById(R.id.cardview_contact);
        showArrowContact = findViewById(R.id.contact_show);
        hiddenGroupContact = findViewById(R.id.contact_hidden_layout);
        swaxEmail = findViewById(R.id.swax_email);
        swaxPhone = findViewById(R.id.swax_phone);

        aboutMe.setOnClickListener(view -> {
            final Dialog dialog = new Dialog(mContext);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.about_me_dialog);
            dialog.show();
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
            lp.copyFrom(dialog.getWindow().getAttributes());
            dialog.getWindow().setAttributes(lp);
            final VideoView videoview = (VideoView) dialog.findViewById(R.id.about_me_video);
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.intro_vid);
            videoview.setVideoURI(uri);
            videoview.start();
            videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    dialog.dismiss();
                }
            });
        });


        showArrowExpertise.setOnClickListener(view -> {
            if(hiddenGroupExpertise.getVisibility() == View.VISIBLE){
                hiddenGroupExpertise.setVisibility(View.GONE);
                showArrowExpertise.setImageResource(android.R.drawable.arrow_down_float);
            } else {
                hiddenGroupExpertise.setVisibility(View.VISIBLE);
                showArrowExpertise.setImageResource(android.R.drawable.arrow_up_float);
            }
        });

        showArrowTech.setOnClickListener(view -> {
            if(hiddenGroupTech.getVisibility() == View.VISIBLE){
                hiddenGroupTech.setVisibility(View.GONE);
                showArrowTech.setImageResource(android.R.drawable.arrow_down_float);
            } else {
                hiddenGroupTech.setVisibility(View.VISIBLE);
                showArrowTech.setImageResource(android.R.drawable.arrow_up_float);
            }
        });

        showArrowEducation.setOnClickListener(view -> {
            if(hiddenGroupEducation.getVisibility() == View.VISIBLE){
                hiddenGroupEducation.setVisibility(View.GONE);
                showArrowEducation.setImageResource(android.R.drawable.arrow_down_float);
            } else {
                hiddenGroupEducation.setVisibility(View.VISIBLE);
                showArrowEducation.setImageResource(android.R.drawable.arrow_up_float);
            }
        });

        experienceButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ExperienceActivity.class);
            startActivity(intent);
        });

        lookingForButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LookingActivity.class);
            startActivity(intent);
        });

        showArrowReferences.setOnClickListener(view -> {
            if(hiddenGroupReferences.getVisibility() == View.VISIBLE){
                hiddenGroupReferences.setVisibility(View.GONE);
                showArrowReferences.setImageResource(android.R.drawable.arrow_down_float);
            } else {
                hiddenGroupReferences.setVisibility(View.VISIBLE);
                showArrowReferences.setImageResource(android.R.drawable.arrow_up_float);
            }
        });

        scottzEmail.setOnClickListener(view -> {
            sendEmail(scottzEmail.getText().toString(), "Questions about Steven Wax.");
        });

        scottzPhone.setOnClickListener(view -> {
            showDialog(scottzPhone.getText().toString());
        });

        joeEmail.setOnClickListener(view -> {
            sendEmail(joeEmail.getText().toString(), "Questions about Steven Wax");
        });

        joePhone.setOnClickListener(view -> {
            showDialog(joePhone.getText().toString());
        });

        jimEmail.setOnClickListener(view -> {
            sendEmail(jimEmail.getText().toString(), "Questions about Steven Wax");
        });

        jimPhone.setOnClickListener(view -> {
            showDialog(jimPhone.getText().toString());
        });

        showArrowContact.setOnClickListener(view -> {
            if(hiddenGroupContact.getVisibility() == View.VISIBLE){
                hiddenGroupContact.setVisibility(View.GONE);
                showArrowContact.setImageResource(android.R.drawable.arrow_down_float);
            } else {
                hiddenGroupContact.setVisibility(View.VISIBLE);
                showArrowContact.setImageResource(android.R.drawable.arrow_up_float);
            }
        });

        swaxEmail.setOnClickListener(view -> {
            sendEmail(swaxEmail.getText().toString(), "Was looking at your resume app");
        });

        swaxPhone.setOnClickListener(view -> {
            callPhone(swaxPhone.getText().toString());
        });

    }

    public void sendEmail(String address, String subject){
        final Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, address);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.setType("message/rfc822");

        try{
            startActivity(Intent.createChooser(emailIntent, "Choose client to send email"));
        } catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(mContext, "No email clients found.", Toast.LENGTH_SHORT).show();
        }
    }

    public void showDialog(String number){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("You are about to make a phone call. While my references have graciously agreed to answer questions please be sure that you are ready to talk before proceeding.")
                .setTitle("Calling Number")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callPhone(number);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    public void callPhone(String number){
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        number = number.replaceAll("-", "");
        phoneIntent.setData(Uri.parse("tel:" + number));
        int requestCode = 0;
        switch(number){
            case "9492857066":
                requestCode = 1;
                break;
            case "4153282645":
                requestCode = 2;
                break;
            case "4253131756":
                requestCode = 3;
                break;
        }

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, requestCode);
        } else {
            try{
                startActivity(phoneIntent);
            } catch(SecurityException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    phoneIntent.setData(Uri.parse("tel:9492857066"));
                    startActivity(phoneIntent);
                } else {

                }
                return;
            }
            case 2: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    phoneIntent.setData(Uri.parse("tel:4153282645"));
                    startActivity(phoneIntent);
                } else {

                }
                return;
            }
            case 3: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    phoneIntent.setData(Uri.parse("tel:4253131756"));
                    startActivity(phoneIntent);
                } else {

                }
                return;
            }
        }
    }

}