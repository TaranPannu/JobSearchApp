package com.example.jobsearch.Retrofit.ApiDataClass

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "JobTable")
data class Job(
    val annualSalaryMax: String = "",
    val annualSalaryMin: String = "",
    val companyLogo: String = "",
    val companyName: String = "",
    @PrimaryKey
    val id: Int,
    val jobDescription: String = "",
    val jobExcerpt: String = "",
    val jobGeo: String = "",
    val jobIndustry: List<String> = listOf(""),
    val jobLevel: String = "",
    val jobSlug: String = "",
    val jobTitle: String = "",
    val jobType: List<String> = listOf(""),
    val pubDate: String = "",
    val salaryCurrency: String = "",
    val url: String = ""
)