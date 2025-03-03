package com.dev.jarassignment.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dev.jarassignment.viewmodel.OnboardingViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(navController: NavController, viewModel: OnboardingViewModel = hiltViewModel()) {
//    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3D1E5A)) // Background color
    ) {
        TopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White,
            ),
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back screen",
                        tint = Color.White
                    )
                }
            },
            title = {
                Text(
                    "Onboarding",
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        )
        println("Debug check loading---: ${viewModel.cardData.size}")
        EducationCardList()
    }


}

//@Composable
//fun OnboardingCard(item: OnboardingItem) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Image(
//            painter = painterResource(item.imageRes),
//            contentDescription = "Onboarding Image",
//            modifier = Modifier
//                .size(250.dp)
//                .clip(RoundedCornerShape(16.dp))
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(
//            text = item.title,
//            color = Color.White,
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Bold
//        )
//    }
//}
//
//@Composable
//fun Indicator(isSelected: Boolean) {
//    Box(
//        modifier = Modifier
//            .size(if (isSelected) 12.dp else 8.dp)
//            .background(
//                if (isSelected) Color.White else Color.Gray,
//                shape = CircleShape
//            )
//            .padding(4.dp)
//    )
//}
