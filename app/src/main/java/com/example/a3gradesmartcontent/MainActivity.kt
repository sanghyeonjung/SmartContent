package com.example.a3gradesmartcontent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.a3gradesmartcontent.databinding.ActivityMainBinding
import com.example.a3gradesmartcontent.fragment.CommunityFragment
import com.example.a3gradesmartcontent.fragment.GptFragment
import com.example.a3gradesmartcontent.fragment.JobsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 첫 번째 프래그먼트로 ChatGPTFragment를 설정합니다.
        supportFragmentManager.beginTransaction().add(binding.frameContainer.id, GptFragment()).commit()

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_community -> {
                    replaceFragment(CommunityFragment())
                }
                R.id.navigation_chatgpt -> {
                    replaceFragment(GptFragment())
                }
                R.id.navigation_job -> {
                    replaceFragment(JobsFragment())
                }
            }
            true // 아이템 선택 처리가 완료되었음을 의미합니다.
        }
    }

    // 프래그먼트 교체를 위한 함수입니다.
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.frameContainer.id, fragment).commit()
    }
}
