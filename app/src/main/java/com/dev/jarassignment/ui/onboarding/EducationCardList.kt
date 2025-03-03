package com.dev.jarassignment.ui.onboarding

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev.jarassignment.data.model.EducationCard
import com.dev.jarassignment.viewmodel.OnboardingViewModel

@Composable
fun EducationCardList(viewModel: OnboardingViewModel = hiltViewModel()) {
    val apiData by viewModel.onboardingData.observeAsState()
    var educationCards: List<EducationCard>? = null

    LaunchedEffect(apiData) {
        apiData?.let {
            println("Debug check loading: ${viewModel.cardData.size}")
            educationCards = apiData?.educationCardList
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(viewModel.cardData.size) { card ->
            ExpandableEducationCard(viewModel.cardData[card])
        }
    }
}
