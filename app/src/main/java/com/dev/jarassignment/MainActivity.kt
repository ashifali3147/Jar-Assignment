package com.dev.jarassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.jarassignment.ui.onboarding.OnboardingLoaderScreen
import com.dev.jarassignment.ui.onboarding.OnboardingScreen
import com.dev.jarassignment.ui.theme.JarAssignmentTheme
import com.dev.jarassignment.viewmodel.OnboardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val vieModel: OnboardingViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JarAssignmentTheme {
                AppNavigation(vieModel)
            }
        }
    }
}

@Composable
fun AppNavigation(vieModel: OnboardingViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "onboarding_loader_screen") {
        composable("onboarding_loader_screen") { OnboardingLoaderScreen(navController) }
        composable("onboarding_screen") { OnboardingScreen(navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JarAssignmentTheme {
//        AppNavigation(vieModel)
    }
}