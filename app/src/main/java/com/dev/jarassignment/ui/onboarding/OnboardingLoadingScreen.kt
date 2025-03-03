package com.dev.jarassignment.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dev.jarassignment.viewmodel.OnboardingViewModel

@Composable
fun OnboardingLoaderScreen(navController: NavController, viewModel: OnboardingViewModel = hiltViewModel()) {
    val apiData by viewModel.onboardingData.observeAsState()

    LaunchedEffect(apiData) {
        apiData?.let {
            navController.navigate("onboarding_screen") // Navigate when data is available
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF251D3A)), // Dark background color
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "Onboarding",
                color = Color(0xFFFFD700), // Gold color
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOnboardingScreen() {
//    OnboardingLoaderScreen()
}
