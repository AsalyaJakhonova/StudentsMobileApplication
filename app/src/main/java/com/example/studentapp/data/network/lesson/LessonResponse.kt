package com.example.studentapp.data.network.lesson

import com.google.gson.annotations.SerializedName

open class LessonResponse(
    @SerializedName("id")
    val Id: String,
    @SerializedName("studentName")
    val TeacherName: String,
    @SerializedName("dateTime")
    val DateTime: String,
    @SerializedName("lessonType")
    val LessonType: String,
    @SerializedName("duration")
    val Duration: String


)
