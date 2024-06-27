package com.example.jobsearch

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobsearch.MVVM.JobViewModel
import com.example.jobsearch.MVVM.JobViewModelFactory
import com.example.jobsearch.MVVM.Repo
import com.example.jobsearch.Retrofit.ApiDataClass.Job
import com.example.jobsearch.Retrofit.ApiDataClass.JobDataClass
import com.example.jobsearch.Retrofit.RetrofitBuilder
import com.example.jobsearch.Room.JobDataBase
import com.example.jobsearch.Room.Job_Room
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JobSearchFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
//    private lateinit var adapter: Adapter
//
//    private lateinit var ApiLivedata: MutableLiveData<JobDataClass>
//    private lateinit var repo: Repo
    private lateinit var jobViewModel: JobViewModel
//    private lateinit var jobViewModelFactory: JobViewModelFactory
//    private lateinit var jobDataBase: JobDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_job_search, container, false)
        init(view)

        recyclerView.layoutManager = LinearLayoutManager(context)
val l = listOf<String>("s","a")
        jobViewModel = (activity as MainActivity).getViewModel()
        jobViewModel.ApiLiveData.observe(viewLifecycleOwner)
        {
           recyclerView.adapter = Adapter(it.jobs)
            lifecycleScope.launch(Dispatchers.IO) {
//                repo.insert(
////                    Job("","","","",56989789,"","","",l ,
////                        "","","",l,"","","")
//           )
            }
        }

            jobViewModel.getAllSavedJobs().observe(viewLifecycleOwner) {
                Log.d("a168a", it.toString())
            }

        return view
    }
    private fun init(view: View) {
//        jobDataBase = JobDataBase(view.context)
        recyclerView = view.findViewById(R.id.rcv)
//        repo = Repo(RetrofitBuilder.getApiInstance(),jobDataBase.getJobDao())
//        jobViewModelFactory = JobViewModelFactory(repo)
//        jobViewModel = ViewModelProvider(this, jobViewModelFactory).get(JobViewModel::class.java)

    }
}
