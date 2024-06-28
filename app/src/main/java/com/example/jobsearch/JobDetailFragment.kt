package com.example.jobsearch

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient


class JobDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_job_detail, container, false)

        val webview = view.findViewById<WebView>(R.id.web)
        try{ webview.loadUrl(arguments?.getString("key").toString()) }
        catch (e:Exception){
        }
        webview.settings.javaScriptEnabled = true
        webview.webViewClient = WebViewClient()

        return view
    }

}