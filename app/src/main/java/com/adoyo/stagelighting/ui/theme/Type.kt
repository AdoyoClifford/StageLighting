package com.adoyo.stagelighting.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.adoyo.stagelighting.R

// Set of Material typography styles to start with
private val avenir = FontFamily(
    listOf(
        Font(
            resId = R.font.avenir_bold,
            weight = FontWeight.Bold
        ),
        Font(
            resId = R.font.avenir_regular,
            weight = FontWeight.Medium
        ),
        Font(
            resId = R.font.avenir_light,
            weight = FontWeight.Light
        ),
    )
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)