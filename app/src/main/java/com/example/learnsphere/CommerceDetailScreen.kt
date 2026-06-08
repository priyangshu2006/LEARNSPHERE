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
fun CommerceDetailScreen(navController: NavController) {
    val primaryBlue = Color(0xFF1A73E8)
    val darkBlue = Color(0xFF0D47A1)
    val surfaceWhite = Color(0xFFF8F9FA)

    val exams = listOf(
        EntranceExam("CA Foundation", "Entry-level exam for Chartered Accountancy."),
        EntranceExam("CMA & CSEET", "For future CMAs and Company Secretaries."),
        EntranceExam("IPMAT & JIPMAT", "Join IIMs right after Class 12."),
        EntranceExam("CUET UG Commerce", "Admission to top UG programs like SRCC."),
        EntranceExam("SET & Christ", "For Symbiosis and Christ University.")
    )

    val courses = listOf(
        "Bachelor of Commerce (B.Com / B.Com Hons)",
        "Bachelor of Business Administration (BBA)",
        "Chartered Accountancy (CA)",
        "Company Secretary (CS)",
        "Bachelor of Management Studies (BMS)",
        "Bachelor of Economics",
        "Cost and Management Accountant (CMA)"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Commerce Stream Details", fontWeight = FontWeight.Bold) },
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
                    text = "Business, Finance, and Management paths for Commerce students.",
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
                            "CA Foundation" -> navController.navigate("premium_exam/ca_foundation")
                            "CMA & CSEET" -> navController.navigate("premium_exam/cma_cseet")
                            "IPMAT & JIPMAT" -> navController.navigate("premium_exam/ipmat_jipmat")
                            "CUET UG Commerce" -> navController.navigate("premium_exam/cuet_com")
                            "SET & Christ" -> navController.navigate("premium_exam/set_christ")
                        }
                    }
                )
            }
        }
    }
}
