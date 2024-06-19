package com.example.a3gradesmartcontent.fragment

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a3gradesmartcontent.Login.SplashActivity
import com.example.a3gradesmartcontent.Post.AddPostActivity
import com.example.a3gradesmartcontent.R
import com.example.yourprojectname.ChatAdapter

class CommunityFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_community, container, false)
        val community_recyclerview = view.findViewById<RecyclerView>(R.id.community_recycler_view)
        //recyclerview 설정 해야됨

        val addpost_btn =view.findViewById<ImageButton>(R.id.community_addpost_btn)
        //setonclicklistener 문제 해결하기
        addpost_btn.setOnClickListener {
            val intent = Intent(activity, AddPostActivity::class.java)
            Log.e("dddd","buttonclick")
            startActivity(intent)


        }
        return inflater.inflate(R.layout.fragment_community, container, false)
    }


}