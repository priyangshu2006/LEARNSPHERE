package com.example.learnsphere

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BusinessCenter
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Search
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

data class ExploreItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val primaryBlue = Color(0xFF1A73E8)
    val lightBlue = Color(0xFFE8F0FE)
    val darkBlue = Color(0xFF0D47A1)
    val surfaceWhite = Color(0xFFF8F9FA)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(surfaceWhite)
            .verticalScroll(rememberScrollState())
    ) {
        // --- Header Section ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(primaryBlue, darkBlue)
                    )
                )
                .padding(top = 48.dp, bottom = 32.dp, start = 24.dp, end = 24.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Welcome to",
                            color = Color.White.copy(alpha = 0.8f),
                            fontSize = 16.sp
                        )
                        Text(
                            text = "LearnSphere",
                            color = Color.White,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Professional Search Bar
                var searchQuery by remember { mutableStateOf("") }
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("What do you want to learn?") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = primaryBlue) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    singleLine = true
                )
            }
        }

        // --- Body Content ---
        Column(modifier = Modifier.padding(vertical = 24.dp)) {

            // --- Explore LS Section (Horizontal Slider) ---
            Text(
                text = "Explore LS",
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF1E293B), // Premium dark color
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            
            Spacer(modifier = Modifier.height(16.dp))

            val exploreOptions = listOf(
                ExploreItem("After 10th", Icons.Default.School, "after_tenth"),
                ExploreItem("After 12th", Icons.Default.MenuBook, "after_twelfth"),
                ExploreItem("After Graduation", Icons.Default.BusinessCenter, "after_graduation")
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                exploreOptions.forEach { item ->
                    ExploreCard(item) {
                        navController.navigate(item.route)
                    }
                }
                // Extra padding at the end for consistent scrolling feel
                Spacer(modifier = Modifier.width(8.dp))
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Continue Learning Section
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Text(
                    text = "Continue Learning",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = darkBlue
                )
                Spacer(modifier = Modifier.height(16.dp))

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
                                .size(50.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(primaryBlue.copy(alpha = 0.1f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("WD", color = primaryBlue, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(text = "Web Development", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            LinearProgressIndicator(
                                progress = { 0.5f },
                                modifier = Modifier.fillMaxWidth().height(6.dp).clip(CircleShape),
                                color = primaryBlue,
                                trackColor = lightBlue
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = "50% completed", fontSize = 12.sp, color = Color.Gray)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Career Path Section
                Button(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = darkBlue)
                ) {
                    Text("Find My Career Path", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                
                Spacer(modifier = Modifier.height(12.dp))
                
                OutlinedButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(16.dp),
                    border = ButtonDefaults.outlinedButtonBorder(enabled = true)
                ) {
                    Text("Explore All Courses", color = darkBlue, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun ExploreCard(item: ExploreItem, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .width(160.dp)
            .height(120.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                tint = Color(0xFF1A73E8),
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = item.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E293B)
            )
        }
    }
}
