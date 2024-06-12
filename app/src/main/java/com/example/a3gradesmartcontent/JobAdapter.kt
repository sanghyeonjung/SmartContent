package com.example.a3gradesmartcontent

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JobAdapter(private val jobs : List<String>) : RecyclerView.Adapter<JobAdapter.JobViewHolder>() {
    class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val jobTextView: TextView = itemView.findViewById(R.id.job_text_view)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_job_recyclerview, parent, false)
        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobs[position]
        Log.e("job" + position , job)
        holder.jobTextView.setText(job)
    }

    override fun getItemCount(): Int {
        return jobs.size
    }
}