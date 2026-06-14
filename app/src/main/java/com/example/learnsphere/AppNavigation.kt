package com.example.learnsphere

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        composable("splash") {
            SplashScreen(navController)
        }

        composable("login") {
            LoginScreen(navController)
        }

        composable("signup") {
            SignupScreen(navController)
        }

        composable("home") {
            MainScreen(navController)
        }

        composable("after_tenth") {
            AfterTenthScreen(navController)
        }

        composable("after_twelfth") {
            AfterTwelfthScreen(navController)
        }

        composable("after_graduation") {
            AfterGraduationScreen(navController)
        }

        composable("science_details") {
            ScienceDetailScreen(navController)
        }

        composable("commerce_details") {
            CommerceDetailScreen(navController)
        }

        composable("arts_details") {
            ArtsDetailScreen(navController)
        }

        composable("jee_advanced") {
            JeeAdvancedScreen(navController)
        }

        composable("premium_exam/{examId}") { backStackEntry ->
            val examId = backStackEntry.arguments?.getString("examId") ?: ""
            val examData = ExamDataProvider.getExamData(examId)
            if (examData != null) {
                PremiumExamScreen(navController, examData)
            }
        }

        composable("mock_test/{testName}") { backStackEntry ->
            val testName = backStackEntry.arguments?.getString("testName") ?: ""
            MockTestScreen(navController, testName)
        }

    }
}

