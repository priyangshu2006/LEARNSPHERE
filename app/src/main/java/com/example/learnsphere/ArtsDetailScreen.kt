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
fun ArtsDetailScreen(navController: NavController) {
    val primaryBlue = Color(0xFF1A73E8)
    val darkBlue = Color(0xFF0D47A1)
    val surfaceWhite = Color(0xFFF8F9FA)

    val exams = listOf(
        EntranceExam("CUET UG Arts", "Gateway to top colleges for History, Pol Science, etc."),
        EntranceExam("CLAT & AILET", "Common Law Admission Test for NLUs."),
        EntranceExam("NID DAT", "Top entrances for Design schools."),
        EntranceExam("NIFT Entrance", "Leading exam for Fashion Technology."),
        EntranceExam("NATA & JEE P2", "For Bachelor of Architecture aspirants.")
    )

    val courses = listOf(
        "Bachelor of Arts (B.A / B.A Hons)",
        "Bachelor of Laws (LL.B - Integrated)",
        "Bachelor of Fine Arts (BFA)",
        "Bachelor of Hotel Management (BHM)",
        "Bachelor of Journalism & Mass Communication (BJMC)",
        "Bachelor of Design (B.Des)",
        "Social Work (BSW)"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Arts & Humanities Details", fontWeight = FontWeight.Bold) },
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
                    text = "Creative, Legal, and Social Science paths for Arts students.",
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
                            "CUET UG Arts" -> navController.navigate("premium_exam/cuet_arts")
                            "CLAT & AILET" -> navController.navigate("premium_exam/clat_ailet")
                            "NID DAT" -> navController.navigate("premium_exam/nid_dat")
                            "NIFT Entrance" -> navController.navigate("premium_exam/nift")
                            "NATA & JEE P2" -> navController.navigate("premium_exam/nata_jee_p2")
                        }
                    }
                )
            }
        }
    }
}
