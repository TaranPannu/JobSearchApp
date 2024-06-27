package com.example.jobsearch.Retrofit

import com.example.jobsearch.Retrofit.ApiDataClass.JobDataClass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {
   @GET("remote-jobs")
   suspend fun getAllJobs(): Response<JobDataClass>

}