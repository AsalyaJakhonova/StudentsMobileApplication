package com.example.studentapp.navigation

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.studentapp.LessonsList
import com.example.studentapp.addnew.AddNewActivity
import com.example.studentapp.detailedView.DetailedView

@Composable
fun Navigation(navController: NavHostController, context: Context) {
    NavHost(navController = navController, startDestination = Screens.LessonsListScreen.route) {
        composable(Screens.LessonsListScreen.route) {
            LessonsList(onAddNewLessonClick = {
                context.startActivity(Intent(context, AddNewActivity::class.java))
            }, onLessonClick = { lessonId ->
                navController.navigate("detailedView/$lessonId")
            }
            )
        }



        composable(
            route = "detailedView/{movieId}"
        ) { backStackEntry ->
            DetailedView(lessonId = backStackEntry.arguments?.getString("lessonId")!!)
        }
    }
}