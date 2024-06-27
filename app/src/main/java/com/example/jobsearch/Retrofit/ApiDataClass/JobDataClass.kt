package com.example.jobsearch.Retrofit.ApiDataClass

data class JobDataClass(
    val apiVersion: String,
    val clientKey: String,
    val documentationUrl: String,
    val friendlyNotice: String,
    val jobCount: Int,
    val jobs: List<Job>,
    val lastUpdate: String,
    val xRayHash: String
)