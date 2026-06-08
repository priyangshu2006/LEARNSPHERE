package com.example.learnsphere

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.learnsphere.ui.theme.LEARNSPHERETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LEARNSPHERETheme {
                AppNavigation()
            }
        }
    }
}
