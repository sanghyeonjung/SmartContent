package com.example.a3gradesmartcontent

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a3gradesmartcontent.Post.Post
import com.example.a3gradesmartcontent.Post.PostDetailActivity

class CommunityAdapter(private val posts : List<Post>) : RecyclerView.Adapter<CommunityAdapter.CommunityViewHolder>() {
    class CommunityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val communityNameTextView: TextView = itemView.findViewById(R.id.community_name_recyclerview)
        val communityTitleTextView: TextView = itemView.findViewById(R.id.community_title_recyclerview)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_community_recyclerview, parent, false)
        return CommunityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommunityViewHolder, position: Int) {
        val post = posts[position]
        Log.e("post" + position , post.name + post.title)
        holder.communityNameTextView.setText(post.name)
        holder.communityTitleTextView.setText(post.title)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, PostDetailActivity::class.java).apply {
                putExtra("title", post.title)
                putExtra("content", post.content)
                putExtra("writer", post.name)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}