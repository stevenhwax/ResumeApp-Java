package com.swax.resumeapp.UI;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swax.resumeapp.R;

import java.util.List;

import Model.Job;

public class JobAdaptor extends RecyclerView.Adapter<JobAdaptor.JobViewHolder>{

    private List<Job> mJobList;
    private final Context mContext;
    private final LayoutInflater mInflator;

    public JobAdaptor(Context context){
        mInflator=LayoutInflater.from(context);
        this.mContext = context;
    }

    class JobViewHolder extends RecyclerView.ViewHolder {
        private final TextView jobTitle;
        private final TextView companyName;
        private final TextView dates;

        private JobViewHolder(View itemView){
            super(itemView);
            jobTitle = itemView.findViewById(R.id.joblist_title);
            companyName = itemView.findViewById(R.id.company_name);
            dates = itemView.findViewById(R.id.dates);

            itemView.setOnClickListener(view -> {

                int position = getAdapterPosition();
                final Job current = mJobList.get(position);

                final Dialog dialog = new Dialog(mContext);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.job_history_dialog);
                int width = (int)(mContext.getResources().getDisplayMetrics().widthPixels*0.90);
                int height = (int)(mContext.getResources().getDisplayMetrics().heightPixels*0.90);
                dialog.getWindow().setLayout(width, height);
                dialog.show();

                TextView companyName = dialog.findViewById(R.id.company_name);
                companyName.setText(current.getJobName());

                TextView jobTitle = dialog.findViewById(R.id.job_title);
                jobTitle.setText(current.getJobTitle());

                TextView jobDates = dialog.findViewById(R.id.job_dates);
                jobDates.setText(current.getDates());

                RecyclerView jobRecyclerView = dialog.findViewById(R.id.job_recyclerview);
                final JobHistoryAdaptor adaptor = new JobHistoryAdaptor(mContext);
                jobRecyclerView.setAdapter(adaptor);
                jobRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                adaptor.setJobsList(current.getResponsibilities());

                TextView closeButton = dialog.findViewById(R.id.close_button);
                closeButton.setOnClickListener(view2 -> {
                    dialog.dismiss();
                });
            });
        }
    }

    @NonNull
    @Override
    public JobAdaptor.JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View jobView = mInflator.inflate(R.layout.job_listitem, parent, false);
        return new JobAdaptor.JobViewHolder(jobView);
    }

    @Override
    public void onBindViewHolder(@NonNull JobAdaptor.JobViewHolder holder, int position){
        if(mJobList != null) {
            Job current = mJobList.get(position);
            holder.jobTitle.setText(current.getJobTitle());
            holder.companyName.setText(current.getJobName());
            holder.dates.setText(current.getDates());
        }
    }

    @Override
    public int getItemCount() {
        if(mJobList != null) {
            return mJobList.size();
        } else {
            return 0;
        }
    }

    public void setJobs(List<Job> jobs){
        mJobList = jobs;
        notifyDataSetChanged();
    }
}
