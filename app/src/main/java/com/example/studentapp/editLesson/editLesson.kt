package com.example.studentapp.editLesson

import android.content.Intent
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentapp.models.Lesson
import com.example.teachersapp.R
import java.time.Duration

@Composable
fun EditLesson(
    lesson: Lesson?,
    onLessonEdited: (Lesson) -> Unit,
){
    if (lesson != null) {
        val id = remember {
            mutableStateOf(lesson.Id)
        }
        val teacherName = remember {
            mutableStateOf(lesson.TeacherName)
        }
        val lessonType = remember {
            mutableStateOf(lesson.LessonType)
        }
        val duration = remember {
            mutableStateOf(lesson.Duration)
        }
        val dateTime = remember {
            mutableStateOf(lesson.DateTime)
        }

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                EditLessonPageTitle()
                IdInput(id = id.value, onIdChange = { id.value = it })
                Spacer(Modifier.height(16.dp))
                TeacherNameInput(
                    teacherName = teacherName.value,
                    onTeacherNameChange = { teacherName.value = it })
                Spacer(Modifier.height(16.dp))
                LessonTypeInput(
                    lessonType = lessonType.value,
                    onLessonTypeChange = { lessonType.value = it })
                Spacer(Modifier.height(16.dp))
                DurationTypeInput(
                    duration = duration.value,
                    onDurationChange = { duration.value = it })
                Spacer(Modifier.height(16.dp))
                DateTimeInput(
                    dateTime = dateTime.value,
                    onDateTimeChange = { dateTime.value = it })
                Spacer(Modifier.height(16.dp))


                AddNewButton {
                    onLessonEdited(
                        Lesson(
                            id.value,
                            teacherName.value,
                            lessonType.value,
                            dateTime.value,
                            duration.value
                        )
                    )
                }
            }
        }
    }
}
@Composable
private fun EditLessonPageTitle() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(id = R.string.title_activity_edit_lesson),
        color = Color.Black,
        fontSize = 26.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center
    )
}


@Composable
private fun IdInput(id: String, onIdChange: (String) -> Unit){
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = id,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onIdChange(it) },
        label = {
            Text(stringResource(id = R.string.lesson_id_input_hint))
        }
    )
}
@Composable
private fun TeacherNameInput(teacherName: String, onTeacherNameChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = teacherName,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onTeacherNameChange(it) },
        label = {
            Text(stringResource(id = R.string.lesson_teacherName_input_hint))
        }
    )
}
@Composable
private fun LessonTypeInput(lessonType: String, onLessonTypeChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = lessonType,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onLessonTypeChange(it) },
        label = {
            Text(stringResource(id = R.string.lesson_lessonType_input_hint))
        }
    )
}
@Composable
private fun DurationTypeInput(duration: String, onDurationChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = duration,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onDurationChange(it) },
        label = {
            Text(stringResource(id = R.string.lesson_duration_input_hint))
        }
    )
}

@Composable
private fun DateTimeInput(dateTime: String, onDateTimeChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = dateTime,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onDateTimeChange(it) },
        label = {
            Text(stringResource(id = R.string.lesson_datetime_input_hint))
        }
    )
}
@Composable
private fun AddNewButton(onClick: () -> Unit) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .padding(vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.bleak_yellow),
            contentColor = Color.Black
        )

    ) {
        Text(
            fontSize = 16.sp,
            text = stringResource(id = R.string.save_btn_text)
        )
    }
}

