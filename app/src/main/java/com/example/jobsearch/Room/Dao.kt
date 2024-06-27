package com.example.jobsearch.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.jobsearch.Retrofit.ApiDataClass.Job

@Dao
interface Dao {
    @Insert
    fun insert(job: Job)
    @Query("SELECT * FROM JobTable")
    fun getAllSavedJobs(): LiveData<List<Job>>
}