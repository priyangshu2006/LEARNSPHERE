package com.example.learnsphere

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
@Suppress("FunctionName")
fun StudyOptionCard(
    title: String,
    description: String,
    primaryColor: Color,
    lightColor: Color,
    iconResId: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(lightColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = iconResId),
                    contentDescription = null,
                    tint = primaryColor,
                    modifier = Modifier.size(28.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(20.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryColor
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    lineHeight = 20.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = { /* Detail navigation can go here */ },
                    colors = ButtonDefaults.buttonColors(containerColor = lightColor),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
                    modifier = Modifier.height(36.dp)
                ) {
                    Text("Explore Details", color = primaryColor, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Suppress("FunctionName")
fun AfterTenthScreen(navController: NavController) {
    val primaryBlue = Color(0xFF1A73E8)
    val lightBlue = Color(0xFFE8F0FE)
    val darkBlue = Color(0xFF0D47A1)
    val surfaceWhite = Color(0xFFF8F9FA)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Higher Studies After 10th", fontWeight = FontWeight.Bold) },
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(surfaceWhite)
                .padding(innerPadding)
                .padding(24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Discover your path after secondary school. Here are some popular options:",
                fontSize = 16.sp,
                color = Color.Gray,
                lineHeight = 24.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            StudyOptionCard(
                title = "Diploma (Polytechnic)",
                description = "Technical courses in Engineering, Technology, and Architecture.",
                primaryColor = primaryBlue,
                lightColor = lightBlue,
                iconResId = R.drawable.ic_after_10th
            )

            Spacer(modifier = Modifier.height(16.dp))

            StudyOptionCard(
                title = "ITI (Industrial Training)",
                description = "Skill-based vocational training for technical jobs.",
                primaryColor = primaryBlue,
                lightColor = lightBlue,
                iconResId = R.drawable.ic_after_10th
            )

            Spacer(modifier = Modifier.height(16.dp))

            StudyOptionCard(
                title = "Higher Secondary (11th & 12th)",
                description = "Traditional academic route with Science, Commerce, or Arts streams.",
                primaryColor = primaryBlue,
                lightColor = lightBlue,
                iconResId = R.drawable.ic_after_12th
            )

            Spacer(modifier = Modifier.height(16.dp))

            StudyOptionCard(
                title = "Paramedical Courses",
                description = "Short-term courses in healthcare support roles like Nursing Assistant.",
                primaryColor = primaryBlue,
                lightColor = lightBlue,
                iconResId = R.drawable.ic_after_10th
            )
        }
    }
}
