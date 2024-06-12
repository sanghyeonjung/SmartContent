package com.example.a3gradesmartcontent

import com.google.gson.annotations.SerializedName

data class JobRes(
    @SerializedName("humidity")
    val name : String, // 채용 제목
    @SerializedName("PM10")
    val content : String, // 채용 공고 내용
    @SerializedName("PM10")
    val startdate : String, // 채용 시작일
    @SerializedName("PM10")
    val enddate : String, // 채용 종료일
    @SerializedName("PM10")
    val company : String, // 채용 공고 회사

)
