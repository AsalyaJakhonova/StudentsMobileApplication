package com.example.studentapp.data.network

import android.util.Log
import com.example.studentapp.data.network.lesson.LessonRequest
import com.example.studentapp.data.network.lesson.LessonResponse
import com.example.studentapp.models.Lesson




class LessonRepository{
    suspend fun getLessonList(): List<Lesson>{
        val lessons = mutableListOf<Lesson>()
        try {


            val response: MyListResponse<LessonResponse> =
                RetrofitInstance.lessonService.getAllLessons("lesson")
            val lessonsFromResponse = response.data
            if (lessonsFromResponse != null) {
                for (lessonsFromResponse in lessonsFromResponse) {
                    if (lessonsFromResponse.TeacherName!= null) {
                        lessons.add(
                            Lesson(
                                lessonsFromResponse.Id,
                                lessonsFromResponse.TeacherName.uppercase(),
                                lessonsFromResponse.DateTime,
                                lessonsFromResponse.LessonType,
                                lessonsFromResponse.Duration



                            )
                        )
                    }
                }
            }
        } catch (ex: Exception){
            ex.printStackTrace()

        }
        return lessons
    }
    suspend fun insertNewLesson(lesson: Lesson): MyResponse?{
        var response: MyResponse
        try {
            val lessonRequest=
                LessonRequest(lesson.Id, lesson.TeacherName, lesson.DateTime,lesson.LessonType, lesson.Duration)
            response = RetrofitInstance.lessonService.insertNewLesson("lesson", lessonRequest)
            Log.d("Update_response", response.toString())
        }catch (e: Exception){
            e.printStackTrace()
            return null
        }
        return response
    }

    suspend fun getLessonById(lessonId: String): Lesson? {

        try {


            val response: MyItemResponse<LessonResponse> =
                RetrofitInstance.lessonService.getOneLessonById(lessonId, "lesson")
            val lessonFromResponse = response.data
            if (lessonFromResponse != null) {
                if (lessonFromResponse.TeacherName != null){
                    return Lesson(
                        Id = lessonId,
                        DateTime = lessonFromResponse.DateTime,
                        LessonType = lessonFromResponse.LessonType,
                        TeacherName = lessonFromResponse.TeacherName,
                        Duration = lessonFromResponse.Duration
                    )
                }

            }
        } catch (ex: Exception){
            ex.printStackTrace()

        }
        return null
    }
}


