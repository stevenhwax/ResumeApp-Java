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

public class JobHistoryAdaptor extends RecyclerView.Adapter<JobHistoryAdaptor.JobHistoryViewHolder> {


    private List<String> mJobTaskList;
    private final Context mContext;
    private final LayoutInflater mInflater;

    public JobHistoryAdaptor(Context context){
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    class JobHistoryViewHolder extends RecyclerView.ViewHolder {
        private final TextView jobTask;

        private JobHistoryViewHolder(View itemView) {
            super(itemView);
            jobTask = itemView.findViewById(R.id.job_task);
        }
    }

    @NonNull
    @Override
    public JobHistoryAdaptor.JobHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View jobView = mInflater.inflate(R.layout.job_history_listitem, parent, false);
        return new JobHistoryViewHolder(jobView);
    }

    @Override
    public void onBindViewHolder(@NonNull JobHistoryViewHolder holder, int position){
        if(mJobTaskList != null){
            String current = mJobTaskList.get(position);
            holder.jobTask.setText(current);
        }
    }

    @Override
    public int getItemCount(){
        if (mJobTaskList != null) {
            return mJobTaskList.size();
        } else {
            return 0;
        }
    }

    public void setJobsList(List<String> list){
        mJobTaskList = list;
        notifyDataSetChanged();
    }

}
