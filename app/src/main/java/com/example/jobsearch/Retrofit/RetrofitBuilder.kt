package com.example.jobsearch.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    companion object
    {
        var retroServices:RetrofitServices?=null

        fun getApiInstance():RetrofitServices
        {
            if (retroServices == null)
            {
                if(RetrofitBuilder.retroServices == null)
                {
                    RetrofitBuilder.retroServices = Retrofit
                        .Builder()
                        .baseUrl("https://jobicy.com/api/v2/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(RetrofitServices::class.java)
                }
            }

            return retroServices!!
        }


    }
}