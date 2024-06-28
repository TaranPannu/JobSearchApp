package com.example.jobsearch.MVVM

import com.example.jobsearch.Retrofit.ApiDataClass.Job
import com.example.jobsearch.Retrofit.RetrofitServices
import com.example.jobsearch.Room.Dao

class Repo(private val retrofitServices: RetrofitServices,private val dao: Dao) {
    suspend fun getAllJobs() = retrofitServices.getAllJobs()

    fun getAllSavedJobs() = dao.getAllSavedJobs()

    fun insert(jobRoom: Job)
    {
        dao.insert(jobRoom)
    }

    fun delete(job: Job)
    {
        dao.delete(job)
    }
}