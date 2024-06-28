package com.example.jobsearch

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast


class JobDetailFragment : Fragment() {
private lateinit var progressBar:ProgressBar
private lateinit var webview:WebView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_job_detail, container, false)

        init(view)

        progressBar.visibility = View.VISIBLE
        try
        {
            webview.loadUrl(arguments?.getString("key").toString())
        }
        catch (e:Exception)
        {
            Toast.makeText(context,"Try again after sometime", Toast.LENGTH_SHORT).show()
        }
        webview.settings.javaScriptEnabled = true
        webview.webViewClient = WebViewClient()
        progressBar.visibility = View.GONE

        return view
    }

    private fun init(view: View) {
        progressBar  = view.findViewById(R.id.prog_bar)
        webview = view.findViewById(R.id.web)
    }
}