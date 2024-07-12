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
import com.example.a3gradesmartcontent.CommunityAdapter
import com.example.a3gradesmartcontent.Login.SplashActivity
import com.example.a3gradesmartcontent.Post.AddPostActivity
import com.example.a3gradesmartcontent.Post.Post
import com.example.a3gradesmartcontent.R
import com.example.yourprojectname.ChatAdapter
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class CommunityFragment : Fragment() {
    private lateinit var firestore: FirebaseFirestore
    private lateinit var communityAdapter: CommunityAdapter
    private var postList: MutableList<Post> = mutableListOf()

    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_community, container, false)
        firestore = Firebase.firestore
        val communityRecyclerView = view.findViewById<RecyclerView>(R.id.community_recycler_view)
        communityRecyclerView.layoutManager = LinearLayoutManager(context)
        communityAdapter = CommunityAdapter(postList)
        fetchPosts()
        communityRecyclerView.adapter = communityAdapter





        val addpost_btn =view.findViewById<ImageButton>(R.id.community_addpost_btn)
        //setonclicklistener 문제 해결하기
        addpost_btn.setOnClickListener {
            val intent = Intent(activity, AddPostActivity::class.java)
            Log.e("dddd","buttonclick")
            startActivity(intent)
        }
        return view

    }
    private fun fetchPosts() {
        firestore.collection("posts")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    var post :Post = Post("example", "example")
                    post = Post(document.data["writer"].toString(),document.data["title"].toString())
                    Log.e("post", document.data["writer"].toString() + document.data["title"].toString())
                    postList.add(post)
                }
                communityAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.w("CommunityFragment", "Error getting documents: ", exception)
            }
    }


}