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
         val company_name:TextView = itemView.findViewById(R.id.job_company)
         val job_type:TextView = itemView.findViewById(R.id.job_type)
         val job_loc:TextView = itemView.findViewById(R.id.job_location)
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_saved_jobs,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
return list.size   }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=list[position]
        holder.textView.text =item.jobTitle
        holder.textView.setOnClickListener(){
            listener_delete_job.onDetailJobClick(item.url)
        }
        holder.delete_btn.setOnClickListener(){
            listener_delete_job.onDeleteJobClick(item)
        }
        holder.company_name.text = item.companyName
        holder.job_loc.text = ", "+item.jobGeo
        holder.job_type.text = item.jobType[0]
    }
}