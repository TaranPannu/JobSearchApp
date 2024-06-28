package com.example.jobsearch.SavedJob

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobsearch.MVVM.JobViewModel
import com.example.jobsearch.MainActivity
import com.example.jobsearch.R
import com.example.jobsearch.Retrofit.ApiDataClass.Job

class SavedJobFragment : Fragment(), Delete_Job_ClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterSavedJobs: AdapterSavedJobs
    private lateinit var jobViewModel:JobViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_saved_job, container, false)
        init(view)

        jobViewModel = (activity as MainActivity).getViewModel()
        jobViewModel.getAllSavedJobs().observe(viewLifecycleOwner)
        {
            val adaptersavedjobs = AdapterSavedJobs(it,this)
            recyclerView.adapter = adaptersavedjobs
            Log.d("a3a", it.toString())
        }
        return view
    }

    fun init(view: View) {
    recyclerView = view.findViewById(R.id.rcv_saved_jobs)
    recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onDeleteJobClick(job: Job) {
      jobViewModel.deleteJob(job)
    }

}

interface Delete_Job_ClickListener
{
    fun onDeleteJobClick(job: Job)
}
