package com.example.jobsearch.JobSearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobsearch.R
import com.example.jobsearch.Retrofit.ApiDataClass.Job

class Adapter(val list: List<Job>, val listener_saved_jobs: Save_Job_ClickListener): RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
val Job_Title:TextView = itemView.findViewById(R.id.job_title)
val Save_Job:ImageView =itemView.findViewById(R.id.save_job_btn)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_job_search, parent, false)
    return ViewHolder(view)
    }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val item=list[position]
//         val l:List<Job> = item.jobs
         holder.Job_Title.text = item.jobTitle  //l[position].jobTitle
         holder.Save_Job.setOnClickListener()
         {
             listener_saved_jobs.onSaveJobClick(item)
         }
     }

     override fun getItemCount(): Int {
return list.size   }


}