package com.example.jobsearch.MVVM

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jobsearch.Retrofit.ApiDataClass.JobDataClass
import com.example.jobsearch.Room.Dao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JobViewModel(private val repo: Repo):ViewModel() {

    val ApiLiveData = MutableLiveData<JobDataClass>()
    val SavedLiveData = MutableLiveData<JobDataClass>()

    init {
        getAllJobsData()
    }
       fun getAllJobsData()
       {
        viewModelScope.launch(Dispatchers.IO)
         {
           ApiLiveData.postValue(repo.getAllJobs().body())
         }
       }

    fun getAllSavedJobs() = repo.getAllSavedJobs()


}

