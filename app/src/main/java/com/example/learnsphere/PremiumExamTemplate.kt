package com.example.learnsphere

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class PremiumExamData(
    val examName: String,
    val description: String,
    val bannerColors: List<Color>,
    val subjects: List<SubjectInfo>,
    val mockTests: List<MockTestInfo>,
    val practiceSheets: List<PracticeSheetInfo>
)

data class SubjectInfo(
    val name: String,
    val icon: ImageVector,
    val color: Color,
    val videoCount: String = "200+ Videos"
)

data class MockTestInfo(
    val title: String,
    val details: String,
    val color: Color = Color(0xFFFFD700)
)

data class PracticeSheetInfo(
    val title: String,
    val type: String, // e.g., "PYQ", "DPP", "Formula Sheet"
    val color: Color = Color(0xFF38BDF8)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PremiumExamScreen(
    navController: NavController,
    data: PremiumExamData
) {
    val darkBg = Color(0xFF0F172A)
    val cardBg = Color(0xFF1E293B)
    val accentBlue = Color(0xFF38BDF8)
    val accentGold = Color(0xFFFFD700)
    val surfaceText = Color(0xFFF8FAFC)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(data.examName, fontWeight = FontWeight.ExtraBold, color = surfaceText) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = surfaceText)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = darkBg)
            )
        },
        containerColor = darkBg
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // --- Pillar 0: Premium Banner ---
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(brush = Brush.horizontalGradient(colors = data.bannerColors))
                        .padding(24.dp)
                ) {
                    Column {
                        Text("Master ${data.examName}", color = surfaceText, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                        Text(data.description, color = surfaceText.copy(alpha = 0.7f), fontSize = 14.sp)
                        Spacer(modifier = Modifier.weight(1f))
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = accentGold),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Resume Learning", color = Color.Black, fontWeight = FontWeight.Bold)
                        }
                    }
                    Icon(
                        Icons.Default.WorkspacePremium,
                        contentDescription = null,
                        tint = accentGold.copy(alpha = 0.3f),
                        modifier = Modifier.size(100.dp).align(Alignment.CenterEnd)
                    )
                }
            }

            // --- Pillar 1: Subject-Wise Video Lectures ---
            item {
                PremiumSectionHeader("Video Lectures", accentBlue)
            }
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(data.subjects) { subject ->
                        PremiumSubjectCard(subject)
                    }
                }
            }

            // --- Pillar 2: Full-Length Mock Tests ---
            item {
                PremiumSectionHeader("Mock Tests & Practice", accentGold)
            }
            item {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    data.mockTests.forEach { test ->
                        PremiumTestItem(
                            test = test,
                            onClick = {
                                navController.navigate("mock_test/${test.title}")
                            }
                        )
                    }
                }
            }

            // --- Pillar 3: Targeted Practice Sheets ---
            item {
                PremiumSectionHeader("Targeted Practice Sheets", accentBlue)
            }
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(data.practiceSheets) { sheet ->
                        PracticeSheetCard(sheet)
                    }
                }
            }

            // --- Pillar 4: 24/7 Instant Doubt Clearing ---
            item {
                PremiumSectionHeader("Doubt Clearing", accentBlue)
            }
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = cardBg)
                ) {
                    Row(
                        modifier = Modifier.padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(accentBlue.copy(alpha = 0.1f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.QuestionAnswer, contentDescription = null, tint = accentBlue)
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("24/7 Doubt Resolution", color = surfaceText, fontWeight = FontWeight.Bold)
                            Text("Get answers within 30 minutes", color = surfaceText.copy(alpha = 0.6f), fontSize = 12.sp)
                        }
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = accentBlue),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text("Ask Now", fontSize = 12.sp)
                        }
                    }
                }
            }
            
            item { Spacer(modifier = Modifier.height(20.dp)) }
        }
    }
}

@Composable
fun PremiumSectionHeader(title: String, accentColor: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.size(4.dp, 18.dp).background(accentColor))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
    }
}

@Composable
fun PremiumSubjectCard(subject: SubjectInfo) {
    Card(
        modifier = Modifier.size(140.dp, 160.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B))
    ) {
        Column(
            modifier = Modifier.padding(16.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(subject.color.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(subject.icon, contentDescription = null, tint = subject.color, modifier = Modifier.size(28.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(subject.name, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(subject.videoCount, color = Color.Gray, fontSize = 12.sp)
        }
    }
}

@Composable
fun PremiumTestItem(test: MockTestInfo, onClick: () -> Unit = {}) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.PlayCircleOutline, contentDescription = null, tint = test.color)
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(test.title, color = Color.White, fontWeight = FontWeight.Bold)
                Text(test.details, color = Color.Gray, fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Color.Gray)
        }
    }
}

@Composable
fun PracticeSheetCard(sheet: PracticeSheetInfo) {
    Card(
        modifier = Modifier.size(160.dp, 100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(sheet.type, color = sheet.color, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(sheet.title, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold, lineHeight = 18.sp)
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.Default.Download, contentDescription = null, tint = Color.Gray, modifier = Modifier.size(16.dp).align(Alignment.End))
        }
    }
}
