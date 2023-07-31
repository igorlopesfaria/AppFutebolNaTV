package br.com.app.futebolnatv.designsystem.core.font

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import br.com.app.futebolnatv.designsystem.core.dimen.DSFontSize

val DSTypography = Typography(

    labelSmall = TextStyle(
        fontFamily = DSFontFamily.regular,
        fontSize = DSFontSize.us
    ),
    labelMedium = TextStyle(
        fontFamily = DSFontFamily.regular,
        fontSize = DSFontSize.xxxs
    ),
    labelLarge = TextStyle(
        fontFamily = DSFontFamily.regular,
        fontSize = DSFontSize.xxs
    ),

    bodySmall = TextStyle(
        fontFamily = DSFontFamily.regular,
        fontSize = DSFontSize.xs
    ),
)