package com.example.studentapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentapp.models.Lesson
import com.example.studentapp.ui.theme.StudentAppTheme

val lesson = Lesson(
    "as-01212",
    "12 January 12:00",
    "Regular",
    "Olga",
    "55 minutes",

)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailedView(lesson)

                }
            }
        }
    }
}
@Composable
fun DetailedView(lesson: Lesson){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            TeacherName(teacherName = lesson.TeacherName)

        }
        Spacer(modifier = Modifier.height(25.dp))
        Duration(duration = lesson.Duration)
        Spacer(modifier = Modifier.height(25.dp))
        MyDivider()
        Spacer(modifier = Modifier.height(25.dp))

        Spacer(Modifier.height(16.dp))
        MyDivider()
        Spacer(modifier = Modifier.height(25.dp))
        LessonType(lessonType = lesson.LessonType)
        Spacer(modifier = Modifier.height(25.dp))
        MyDivider()
        Spacer(modifier = Modifier.height(25.dp))
        DateTime(datetime = lesson.DateTime)


        }
    }

@Composable
fun DateTime(datetime: String){
    Text(
        text = datetime,
        color = Color.Black,
        fontSize = 15.sp,
        fontFamily = FontFamily.Serif,

    )

}
@Composable
fun LessonType(lessonType: String){
    Text(
        text = lessonType,
        color = Color.Black,
        fontSize = 15.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center



    )

}
@Composable
fun TeacherName(teacherName: String){
    Text(
        text = teacherName,
        color = Color.Black,
        fontSize = 30.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center
    )
}
@Composable
fun Duration(duration: String){
    Text(
        text = duration,
        color = Color.Black,
        fontSize = 15.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun MyDivider() {
    Divider(
        color = Color.LightGray
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StudentAppTheme {
        DetailedView(lesson)
    }
}