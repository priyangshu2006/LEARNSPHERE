package com.example.learnsphere

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.*
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JeeAdvancedScreen(navController: NavController) {
    val darkBg = Color(0xFF0F172A)
    val cardBg = Color(0xFF1E293B)
    val accentGold = Color(0xFFFFD700)
    val accentBlue = Color(0xFF38BDF8)
    val surfaceText = Color(0xFFF8FAFC)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("JEE Advanced Premium", fontWeight = FontWeight.ExtraBold, color = surfaceText) },
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
            // --- Premium Banner ---
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color(0xFF1E3A8A), Color(0xFF1E40AF))
                            )
                        )
                        .padding(24.dp)
                ) {
                    Column {
                        Text("Master JEE Advanced", color = surfaceText, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                        Text("Expert-led curriculum for IIT aspirants", color = surfaceText.copy(alpha = 0.7f), fontSize = 14.sp)
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

            // --- Subject-wise Video Sections ---
            item {
                SectionHeader("Video Lectures", accentBlue)
            }
            item {
                val subjects = listOf(
                    SubjectData("Physics", Icons.Default.FlashOn, Color(0xFFF59E0B)),
                    SubjectData("Chemistry", Icons.Default.Science, Color(0xFF10B981)),
                    SubjectData("Mathematics", Icons.Default.Functions, Color(0xFFEF4444))
                )
                LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(subjects) { subject ->
                        SubjectCard(subject)
                    }
                }
            }

            // --- Mock Tests Section ---
            item {
                SectionHeader("Mock Tests & Practice", accentGold)
            }
            item {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    TestItem("All India Mock Test 2024", "3 Hours • 180 Marks", accentGold)
                    TestItem("Previous Year Paper 2023", "Full Length • Solutions Included", accentBlue)
                }
            }

            // --- Doubt Clearing Area ---
            item {
                SectionHeader("Doubt Clearing", accentBlue)
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
        }
    }
}

data class SubjectData(val name: String, val icon: ImageVector, val color: Color)

@Composable
fun SectionHeader(title: String, accentColor: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.size(4.dp, 18.dp).background(accentColor))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
    }
}

@Composable
fun SubjectCard(subject: SubjectData) {
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
            Text("240+ Videos", color = Color.Gray, fontSize = 12.sp)
        }
    }
}

@Composable
fun TestItem(title: String, sub: String, color: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.PlayCircleOutline, contentDescription = null, tint = color)
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title, color = Color.White, fontWeight = FontWeight.Bold)
                Text(sub, color = Color.Gray, fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Color.Gray)
        }
    }
}
