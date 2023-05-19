package com.swax.resumeapp.UI;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swax.resumeapp.R;

import java.util.ArrayList;
import java.util.List;

import Model.Job;

public class ExperienceActivity extends AppCompatActivity {

    LinearLayout smithMicroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        List<String> sMJobTasks = new ArrayList<>();
        sMJobTasks.add("String 1");
        sMJobTasks.add("String 2");
        sMJobTasks.add("String 3");

        Job smithMicro = new Job("Smith Micro Software", "Lead Software Engineer", "Jan 2019 - Mar 2023", sMJobTasks);

        smithMicroButton = findViewById(R.id.smith_micro_button);

        smithMicroButton.setOnClickListener(view -> {
            final Dialog dialog = new Dialog(ExperienceActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.job_history_dialog);
            dialog.show();

            TextView companyName = dialog.findViewById(R.id.company_name);
            companyName.setText(smithMicro.getJobName());

            TextView jobTitle = dialog.findViewById(R.id.job_title);
            jobTitle.setText(smithMicro.getJobTitle());

            TextView jobDates = dialog.findViewById(R.id.job_dates);
            jobDates.setText(smithMicro.getDates());

            RecyclerView jobRecyclerView = dialog.findViewById(R.id.job_recyclerview);
            final JobAdaptor adaptor = new JobAdaptor(this);
            jobRecyclerView.setAdapter(adaptor);
            jobRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            adaptor.setJobsList(smithMicro.getResponsibilities());
        });

    }
}
