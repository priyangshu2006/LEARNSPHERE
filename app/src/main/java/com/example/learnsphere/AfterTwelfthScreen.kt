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

data class StreamOption(
    val title: String,
    val description: String,
    val route: String
)

data class EntranceExam(
    val name: String,
    val description: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AfterTwelfthScreen(navController: NavController) {
    val primaryBlue = Color(0xFF1A73E8)
    val darkBlue = Color(0xFF0D47A1)
    val surfaceWhite = Color(0xFFF8F9FA)

    val streams = listOf(
        StreamOption(
            "Science",
            "Opportunities in Engineering, Medicine, Research, and Pure Sciences.",
            "science_details"
        ),
        StreamOption(
            "Commerce",
            "Focus on Finance, Accounting, Business Management, and Economics.",
            "commerce_details"
        ),
        StreamOption(
            "Arts & Humanities",
            "Explore Law, Design, Social Sciences, Media, and Liberal Arts.",
            "arts_details"
        )
    )

    val examsByStream = mapOf(
        "Science" to listOf(
            EntranceExam("JEE Main/Advanced", "For Engineering (B.Tech) in IITs, NITs, and IIITs."),
            EntranceExam("NEET-UG", "Main entrance for Medical (MBBS/BDS) and allied courses."),
            EntranceExam("BITSAT", "Entrance for BITS Pilani, Goa, and Hyderabad campuses."),
            EntranceExam("NDA", "National Defence Academy entrance for Army, Navy, and Air Force.")
        ),
        "Commerce" to listOf(
            EntranceExam("CA Foundation", "Entry-level exam for Chartered Accountancy."),
            EntranceExam("CUET (Commerce)", "Admission to UG programs in top Central Universities like DU."),
            EntranceExam("CSEET", "Entrance for Company Secretary (CS) course."),
            EntranceExam("IPMAT", "Entrance for 5-year Integrated Program in Management at IIMs.")
        ),
        "Arts & Humanities" to listOf(
            EntranceExam("CUET (Arts)", "Gateway to top colleges for History, Pol Science, Psychology, etc."),
            EntranceExam("CLAT", "Common Law Admission Test for National Law Universities."),
            EntranceExam("NID/NIFT", "Top entrances for Design and Fashion Technology."),
            EntranceExam("AILET", "All India Law Entrance Test for NLU Delhi.")
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Higher Studies After 12th", fontWeight = FontWeight.Bold) },
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
                    text = "Explore career streams and major entrance exams to plan your future:",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    lineHeight = 24.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            // Stream Sections
            streams.forEach { stream ->
                item {
                    Text(
                        text = "${stream.title} Stream",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = darkBlue,
                        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                    )
                }

                item {
                    StreamCard(
                        stream = stream,
                        primaryColor = primaryBlue,
                        onClick = {
                            navController.navigate(stream.route)
                        }
                    )
                }

                item {
                    Text(
                        text = "Major Entrance Exams:",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(start = 4.dp, bottom = 4.dp)
                    )
                }

                val exams = examsByStream[stream.title] ?: emptyList()
                items(exams) { exam ->
                    ExamCard(exam = exam, primaryColor = primaryBlue)
                }

                item {
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 8.dp),
                        thickness = 1.dp,
                        color = Color.LightGray.copy(alpha = 0.5f)
                    )
                }
            }
        }
    }
}

@Composable
fun StreamCard(stream: StreamOption, primaryColor: Color, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stream.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryColor
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stream.description,
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    lineHeight = 20.sp
                )
            }
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                tint = Color.Gray
            )
        }
    }
}

@Composable
fun ExamCard(exam: EntranceExam, primaryColor: Color, onClick: () -> Unit = {}) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = exam.name,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = primaryColor
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = exam.description,
                fontSize = 13.sp,
                color = Color.Gray,
                lineHeight = 18.sp
            )
        }
    }
}
