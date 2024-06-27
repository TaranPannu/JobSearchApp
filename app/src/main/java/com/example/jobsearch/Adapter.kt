package com.example.jobsearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.jobsearch.Retrofit.ApiDataClass.Job
import com.example.jobsearch.Retrofit.ApiDataClass.JobDataClass

class Adapter(val list: List<Job>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
val Job_Title:TextView = itemView.findViewById(R.id.job_title)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_job_search, parent, false)
    return ViewHolder(view)
    }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val item=list[position]
//         val l:List<Job> = item.jobs
         holder.Job_Title.text = item.jobTitle  //l[position].jobTitle
     }


     override fun getItemCount(): Int {
return list.size   }


}