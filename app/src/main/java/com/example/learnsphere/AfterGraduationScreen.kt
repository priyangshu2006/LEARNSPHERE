package com.example.learnsphere

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AfterGraduationScreen(navController: NavController) {
    val primaryBlue = Color(0xFF1A73E8)
    val darkBlue = Color(0xFF0D47A1)
    val surfaceWhite = Color(0xFFF8F9FA)

    val streamCategories = listOf(
        StreamCategory(
            "Science & Technology",
            "GATE, JAM, CSIR NET for Research and Masters.",
            listOf(
                ExamBrief("GATE", "premium_exam/gate"),
                ExamBrief("IIT JAM", "premium_exam/jam"),
                ExamBrief("CSIR NET", "premium_exam/csir_net")
            )
        ),
        StreamCategory(
            "Management & Commerce",
            "CAT, XAT, and Professional Final levels.",
            listOf(
                ExamBrief("CAT", "premium_exam/cat"),
                ExamBrief("XAT", "premium_exam/xat"),
                ExamBrief("CA Final", "premium_exam/ca_final"),
                ExamBrief("CS Final", "premium_exam/cs_final")
            )
        ),
        StreamCategory(
            "Arts & Humanities",
            "UPSC, UGC NET, TISSNET, and CUET PG.",
            listOf(
                ExamBrief("UPSC CSE", "premium_exam/upsc_cse"),
                ExamBrief("UGC NET", "premium_exam/ugc_net"),
                ExamBrief("TISSNET", "premium_exam/tissnet"),
                ExamBrief("CUET PG", "premium_exam/cuet_pg")
            )
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Higher Studies After Graduation", fontWeight = FontWeight.Bold) },
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
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                Text(
                    text = "Specialize in your field with national-level entrance exams:",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    lineHeight = 24.sp
                )
            }

            items(streamCategories) { category ->
                Column {
                    Text(
                        text = category.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = darkBlue,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = category.description,
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    
                    category.exams.forEach { exam ->
                        ExamCard(
                            exam = EntranceExam(exam.name, ""), // Reusing EntranceExam for the card
                            primaryColor = primaryBlue,
                            onClick = { navController.navigate(exam.route) }
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}

data class StreamCategory(
    val title: String,
    val description: String,
    val exams: List<ExamBrief>
)

data class ExamBrief(
    val name: String,
    val route: String
)
