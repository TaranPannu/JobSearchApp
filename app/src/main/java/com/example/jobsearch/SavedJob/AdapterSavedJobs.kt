package com.example.jobsearch.SavedJob

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobsearch.R
import com.example.jobsearch.Retrofit.ApiDataClass.Job

class AdapterSavedJobs(private val list:List<Job>,private val listener_delete_job: Delete_Job_ClickListener): RecyclerView.Adapter<AdapterSavedJobs.ViewHolder>() {
     class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
val textView:TextView = itemView.findViewById(R.id.job_title)
         val delete_btn:ImageView = itemView.findViewById(R.id.save_job_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_job_search,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
return list.size   }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=list[position]
holder.textView.text =item.jobTitle
        holder.delete_btn.setOnClickListener(){
            listener_delete_job.onDeleteJobClick(item)
        }

    }
}