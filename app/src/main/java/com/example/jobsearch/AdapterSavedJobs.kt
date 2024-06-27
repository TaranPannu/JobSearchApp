package com.example.jobsearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobsearch.Retrofit.ApiDataClass.Job

class AdapterSavedJobs(private val list:List<Job>): RecyclerView.Adapter<AdapterSavedJobs.ViewHolder>() {
     class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
val textView:TextView = itemView.findViewById(R.id.job_title)
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
    }
}