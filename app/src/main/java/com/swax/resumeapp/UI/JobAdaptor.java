package com.swax.resumeapp.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.swax.resumeapp.R;

import java.util.List;

import Model.Job;

public class JobAdaptor extends RecyclerView.Adapter<JobAdaptor.JobViewHolder> {

    private Job thingy;
    private List<String> mJobsList;
    private final Context mContext;
    private final LayoutInflater mInflater;

    public JobAdaptor(Context context){
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    class JobViewHolder extends RecyclerView.ViewHolder {
        private final TextView jobTask;

        private JobViewHolder(View itemView) {
            super(itemView);
            jobTask = itemView.findViewById(R.id.job_task);
        }
    }

    @NonNull
    @Override
    public JobAdaptor.JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View jobView = mInflater.inflate(R.layout.job_history_listitem, parent, false);
        return new JobViewHolder(jobView);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position){
        if(mJobsList != null){
            String current = mJobsList.get(position);
            holder.jobTask.setText(current);
        }
    }

    @Override
    public int getItemCount(){
        if (mJobsList != null) {
            return mJobsList.size();
        } else {
            return 0;
        }
    }

    public void setJobsList(List<String> list){
        mJobsList = list;
        notifyDataSetChanged();
    }

}
