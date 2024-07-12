package com.example.a3gradesmartcontent.Post

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a3gradesmartcontent.Login.UtilCode
import com.example.a3gradesmartcontent.R
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class AddPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)
        // Firebase Firestore 및 Auth 인스턴스 초기화
        var auth: FirebaseAuth = FirebaseAuth.getInstance()
        // UI 요소 초기화
        val titleEditText = findViewById<EditText>(R.id.addpost_title_edittext)
        val contentEditText = findViewById<EditText>(R.id.addpost_content_edittext)
        val uploadButton = findViewById<Button>(R.id.addpost_upload_button)

        // 작성하기 버튼 클릭 리스너 설정
        uploadButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val content = contentEditText.text.toString()
            val user = auth?.currentUser
            if (title.isNotEmpty() && content.isNotEmpty() && user != null) {
                val db = Firebase.firestore
//                var cnt : Int = 0
//                db.collection("posts")
//                    .document("postcnt")
//                    .get()
//                    .addOnSuccessListener { it ->
//                        cnt = it.data!!.get("cnt").toString().toInt()
//                    }
//                cnt = cnt+1
                val post = hashMapOf(
                    "writer" to user.email,
                    "title" to title,
                    "content" to content
                )
                db.collection("posts")
                    .add(post)
                    .addOnSuccessListener { documentReference ->
                        Log.d("AddPostActivity", "DocumentSnapshot added with ID: ${documentReference.id}")
                    }
                    .addOnFailureListener { e ->
                        Log.w("AddPostActivity", "Error adding document", e)
                    }
                Toast.makeText(this, "Authentication success.", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                // 제목이나 내용이 비어 있는 경우 경고 메시지를 표시하거나 적절한 처리를 합니다.
                Log.d("AddPostActivity", "Title or Content is empty or user is not authenticated")
            }
        }
    }
}