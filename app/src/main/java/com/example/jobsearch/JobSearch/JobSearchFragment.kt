package com.example.jobsearch.JobSearch

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobsearch.MVVM.JobViewModel
import com.example.jobsearch.MainActivity
import com.example.jobsearch.R
import com.example.jobsearch.Retrofit.ApiDataClass.Job
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JobSearchFragment : Fragment(), Save_Job_ClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var jobViewModel: JobViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_job_search, container, false)
        init(view)
        jobViewModel = (activity as MainActivity).getViewModel()
        jobViewModel.ApiLiveData.observe(viewLifecycleOwner)
        {
           recyclerView.adapter = Adapter(it.jobs,this)
            lifecycleScope.launch(Dispatchers.IO) {
 }
        }
  return view
    }
    private fun init(view: View) {
        recyclerView = view.findViewById(R.id.rcv)
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onSaveJobClick(job: Job) {
        jobViewModel.insertJob( assignDefaultValues(job))
        Toast.makeText(context,"Saved Successfully",Toast.LENGTH_SHORT).show()    }
}

interface Save_Job_ClickListener
{
    fun onSaveJobClick(job: Job)
}



fun assignDefaultValues(job: Job?): Job {
    return job?.copy(
        annualSalaryMax = job.annualSalaryMax ?: "",
        annualSalaryMin = job.annualSalaryMin ?: "",
        companyLogo = job.companyLogo ?: "",
        companyName = job.companyName ?: "",
        jobDescription = job.jobDescription ?: "",
        jobExcerpt = job.jobExcerpt ?: "",
        jobGeo = job.jobGeo ?: "",
        jobIndustry = job.jobIndustry ?: listOf(""),
        jobLevel = job.jobLevel ?: "",
        jobSlug = job.jobSlug ?: "",
        jobTitle = job.jobTitle ?: "",
        jobType = job.jobType ?: listOf(""),
        pubDate = job.pubDate ?: "",
        salaryCurrency = job.salaryCurrency ?: "",
        url = job.url ?: ""
    ) ?: Job(
        id = 0,
        annualSalaryMax = "",
        annualSalaryMin = "",
        companyLogo = "",
        companyName = "",
        jobDescription = "",
        jobExcerpt = "",
        jobGeo = "",
        jobIndustry = listOf(""),
        jobLevel = "",
        jobSlug = "",
        jobTitle = "",
        jobType = listOf(""),
        pubDate = "",
        salaryCurrency = "",
        url = ""
    )
}
