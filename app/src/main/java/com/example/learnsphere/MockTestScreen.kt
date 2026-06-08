package com.example.learnsphere

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MockTestScreen(navController: NavController, testName: String) {
    val darkBg = Color(0xFF0F172A)
    val cardBg = Color(0xFF1E293B)
    val accentBlue = Color(0xFF38BDF8)
    val surfaceText = Color(0xFFF8FAFC)
    
    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    var timeLeft by remember { mutableLongStateOf(10800L) } // 3 hours in seconds

    LaunchedEffect(key1 = timeLeft) {
        if (timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
    }

    val hours = timeLeft / 3600
    val minutes = (timeLeft % 3600) / 60
    val seconds = timeLeft % 60
    val timerText = String.format("%02d:%02d:%02d", hours, minutes, seconds)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Column {
                        Text(testName, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = surfaceText)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Timer, contentDescription = null, tint = accentBlue, modifier = Modifier.size(14.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(timerText, fontSize = 12.sp, color = accentBlue)
                        }
                    }
                },
                actions = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.Close, contentDescription = "Exit", tint = surfaceText)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = darkBg)
            )
        },
        containerColor = darkBg,
        bottomBar = {
            Surface(
                color = cardBg,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = { if (currentQuestionIndex > 0) currentQuestionIndex-- },
                        enabled = currentQuestionIndex > 0,
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = surfaceText),
                        border = ButtonDefaults.outlinedButtonBorder(enabled = true)
                    ) {
                        Text("Previous")
                    }
                    
                    Button(
                        onClick = { if (currentQuestionIndex < 29) currentQuestionIndex++ },
                        colors = ButtonDefaults.buttonColors(containerColor = accentBlue),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(if (currentQuestionIndex == 29) "Submit Test" else "Save & Next", color = Color.Black, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp)
        ) {
            // Question Progress
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Question ${currentQuestionIndex + 1} of 30",
                    color = surfaceText.copy(alpha = 0.6f),
                    fontSize = 14.sp
                )
                Text(
                    text = "Marks: +4 -1",
                    color = Color(0xFF10B981),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Question Text
            Text(
                text = "What is the primary function of the Transformer in a power distribution system, and how does it affect the voltage and current relationship?",
                color = surfaceText,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 26.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Options
            val options = listOf(
                "Increases voltage and increases current",
                "Decreases voltage and increases current",
                "Decreases voltage and decreases current",
                "Increases voltage and keeps current constant"
            )

            options.forEachIndexed { index, option ->
                OptionItem(
                    index = index,
                    text = option,
                    isSelected = selectedOption == index,
                    onClick = { selectedOption = index },
                    accentColor = accentBlue,
                    cardBg = cardBg,
                    surfaceText = surfaceText
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            // Question Palette (Miniature)
            Text(
                text = "Question Palette",
                color = surfaceText.copy(alpha = 0.6f),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            
            LazyVerticalGrid(
                columns = GridCells.Fixed(6),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.height(100.dp)
            ) {
                items((1..30).toList()) { num ->
                    val isCurrent = num == currentQuestionIndex + 1
                    Box(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .background(if (isCurrent) accentBlue else cardBg)
                            .border(
                                width = 1.dp,
                                color = if (isCurrent) accentBlue else Color.Gray.copy(alpha = 0.3f),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable { currentQuestionIndex = num - 1 },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = num.toString(),
                            color = if (isCurrent) Color.Black else surfaceText,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun OptionItem(
    index: Int,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    accentColor: Color,
    cardBg: Color,
    surfaceText: Color
) {
    val borderColor = if (isSelected) accentColor else Color.Transparent
    val optionLabel = ('A' + index).toString()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .border(2.dp, borderColor, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = if (isSelected) accentColor.copy(alpha = 0.1f) else cardBg)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) accentColor else Color.Gray.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = optionLabel,
                    color = if (isSelected) Color.Black else surfaceText,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = text,
                color = surfaceText,
                fontSize = 15.sp
            )
        }
    }
}
