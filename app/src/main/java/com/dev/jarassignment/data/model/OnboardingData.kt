package com.dev.jarassignment.data.model

data class OnboardingData(
    val toolBarText: String,
    val introTitle: String,
    val introSubtitle: String,
    val educationCardList: List<EducationCard>,
    val saveButtonCta: SaveButtonCta,
    val ctaLottie: String,
    val screenType: String,
    val cohort: String,
    val combination: String,
    val collapseCardTiltInterval: Long,
    val collapseExpandIntroInterval: Long,
    val bottomToCenterTranslationInterval: Long,
    val expandCardStayInterval: Long,
    val seenCount: Long,
)
