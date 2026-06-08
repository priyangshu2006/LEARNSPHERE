package com.example.learnsphere

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScienceDetailScreen(navController: NavController) {
    val primaryBlue = Color(0xFF1A73E8)
    val darkBlue = Color(0xFF0D47A1)
    val surfaceWhite = Color(0xFFF8F9FA)

    val exams = listOf(
        EntranceExam("JEE Main & Advanced", "For Engineering (B.Tech) in IITs, NITs, and IIITs."),
        EntranceExam("NEET-UG", "Main entrance for Medical (MBBS/BDS) and allied courses."),
        EntranceExam("NDA / NA", "National Defence Academy entrance for Army, Navy, and Air Force."),
        EntranceExam("IAT & NEST", "For IISERs and NISER Research programs."),
        EntranceExam("CUET UG Science", "Central Universities Test for B.Sc programs.")
    )

    val courses = listOf(
        "Bachelor of Technology (B.Tech/B.E)",
        "Bachelor of Medicine and Bachelor of Surgery (MBBS)",
        "Bachelor of Science (B.Sc) in Physics, Chem, Math, Bio",
        "Bachelor of Architecture (B.Arch)",
        "Bachelor of Pharmacy (B.Pharma)",
        "Bachelor of Dental Surgery (BDS)",
        "Commercial Pilot Training"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Science Stream Details", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = darkBlue,
                    navigationIconContentColor = darkBlue
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(surfaceWhite)
                .padding(innerPadding),
            contentPadding = PaddingValues(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Engineering, Medical, and Research paths for Science students.",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    lineHeight = 24.sp
                )
            }

            item {
                Text(
                    text = "Popular Courses",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = darkBlue
                )
            }

            items(courses) { course ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Text(
                        text = course,
                        modifier = Modifier.padding(16.dp),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            item {
                Text(
                    text = "Major Entrance Exams",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = darkBlue,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            items(exams) { exam ->
                ExamCard(
                    exam = exam,
                    primaryColor = primaryBlue,
                    onClick = {
                        when (exam.name) {
                            "JEE Main & Advanced" -> navController.navigate("premium_exam/jee_main_adv")
                            "NEET-UG" -> navController.navigate("premium_exam/neet")
                            "NDA / NA" -> navController.navigate("premium_exam/nda")
                            "IAT & NEST" -> navController.navigate("premium_exam/iat_nest")
                            "CUET UG Science" -> navController.navigate("premium_exam/cuet_sci")
                        }
                    }
                )
            }
        }
    }
}
