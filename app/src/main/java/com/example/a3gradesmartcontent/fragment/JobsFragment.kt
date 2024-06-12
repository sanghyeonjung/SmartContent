package com.example.a3gradesmartcontent.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a3gradesmartcontent.JobAdapter
import com.example.a3gradesmartcontent.R

// TODO: Rename parameter arguments, choose names that match
class JobsFragment : Fragment() {
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }*/
    private val jobs = mutableListOf<String>()
    private var adapter = JobAdapter(jobs)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_jobs,container, false)
        val job_recycler_view = view.findViewById<RecyclerView>(R.id.job_recycler_view)

        job_recycler_view.layoutManager = LinearLayoutManager(container!!.context)
        job_recycler_view.adapter = adapter
        Log.e("jobs : ", jobs.toString())
        jobs.add("dsd1")
        jobs.add("dsd2")
        jobs.add("dsd3")
        jobs.add("dsd4")
        jobs.add("dsd5")

        adapter.notifyDataSetChanged()

        // Inflate the layout for this fragment
        return view

    }
}