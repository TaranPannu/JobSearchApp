package com.example.jobsearch.JobSearch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jobsearch.R
import com.example.jobsearch.Retrofit.ApiDataClass.Job

class Adapter(private val context: Context?, val list: List<Job>, val listener_saved_jobs: Save_Job_ClickListener): RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
val Job_Title:TextView = itemView.findViewById(R.id.job_title)
val Save_Job:ImageView =itemView.findViewById(R.id.save_job_btn)
val company_logo:ImageView = itemView.findViewById(R.id.logo)
val job_company:TextView = itemView.findViewById(R.id.job_company)
val job_location:TextView = itemView.findViewById(R.id.job_location)
val job_type:TextView = itemView.findViewById(R.id.job_type)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_job_search, parent, false)
    return ViewHolder(view)
    }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val item=list[position]
         holder.Job_Title.text = item.jobTitle
         holder.job_company.text = item.companyName
         holder.job_location.text = ", "+item.jobGeo
         holder.job_type.text = item.jobType[0]

         holder.Save_Job.setOnClickListener()
         {
             listener_saved_jobs.onSaveJobClick(item)
         }

         if (context != null) {
             Glide.with(context)
                 .load(item.companyLogo)
                 .apply(RequestOptions.circleCropTransform())
                 .into(holder.company_logo)
         }

     }

     override fun getItemCount(): Int {
return list.size   }


}