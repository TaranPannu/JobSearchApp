package com.example.jobsearch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SavedJobFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterSavedJobs: AdapterSavedJobs
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_saved_job, container, false)

        return view
    }


    fun init(view: View) {
    recyclerView = view.findViewById(R.id.rcv_saved_jobs)
    recyclerView.layoutManager = LinearLayoutManager(context)
    }

}