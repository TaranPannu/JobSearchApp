package com.example.jobsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.jobsearch.JobSearch.JobSearchFragment
import com.example.jobsearch.MVVM.JobViewModel
import com.example.jobsearch.MVVM.JobViewModelFactory
import com.example.jobsearch.MVVM.Repo
import com.example.jobsearch.Retrofit.ApiDataClass.JobDataClass
import com.example.jobsearch.Retrofit.RetrofitBuilder
import com.example.jobsearch.Room.JobDataBase
import com.example.jobsearch.SavedJob.SavedJobFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var Bottom_Nav:BottomNavigationView
    private lateinit var ApiLivedata:MutableLiveData<JobDataClass>

    private lateinit var repo: Repo
    private lateinit var jobViewModel: JobViewModel
    private lateinit var jobViewModelFactory: JobViewModelFactory
    private lateinit var jobDataBase: JobDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
//        jobViewModel.ApiLiveData.observe(this@MainActivity)
//        {
//            Log.d("s232",it.toString())
//        }
//        val retro_services = RetrofitBuilder.getApiInstance()
//        lifecycleScope.launch(Dispatchers.IO) {
//            try {
//
//            }
//            catch(e: Exception)
//            {
//                Log.d("s22",e.toString())
//            }
//        }

        Bottom_Nav.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.JobSearchFragment ->{Toast.makeText(this,"JobSearchFragment",Toast.LENGTH_LONG).show()
                    supportFragmentManager.beginTransaction().replace(R.id.frag_cont,
                        JobSearchFragment()
                    ).commit()
                }
                R.id.SavedJobsFragment ->{Toast.makeText(this,"SavedJobsFragment",Toast.LENGTH_LONG).show()
                    supportFragmentManager.beginTransaction().replace(R.id.frag_cont,
                        SavedJobFragment()
                    ).commit()
                }
            }
            true
        }
    }

    fun getViewModel(): JobViewModel {
        return jobViewModel
    }
    private fun init()
    {
        Bottom_Nav =findViewById(R.id.bottom_nav)
        jobDataBase = JobDataBase(this)
        repo = Repo(RetrofitBuilder.getApiInstance(),jobDataBase.getJobDao())
        jobViewModelFactory = JobViewModelFactory(repo)
        jobViewModel = ViewModelProvider(this, jobViewModelFactory).get(JobViewModel::class.java)
    }


}

