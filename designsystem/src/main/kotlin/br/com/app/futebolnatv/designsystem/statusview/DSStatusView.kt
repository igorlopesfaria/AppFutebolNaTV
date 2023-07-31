package br.com.app.futebolnatv.designsystem.statusview
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.app.futebolnatv.designsystem.R
import br.com.app.futebolnatv.designsystem.button.DSButton
import br.com.app.futebolnatv.designsystem.button.DSButtonType
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.core.color.DSColor
import br.com.app.futebolnatv.designsystem.core.dimen.DSMargin
import br.com.app.futebolnatv.designsystem.core.font.DSTypography


sealed interface DSStatusViewType {
    object NoInternet : DSStatusViewType
    object GenericError : DSStatusViewType
}

@Composable
fun DSStatusView(
    title:String,
    description: String,
    onClick: (() -> Unit)? = null,
    buttonText: String = "",
    type: DSStatusViewType = DSStatusViewType.GenericError) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        type.getIcon()
        Spacer(modifier = Modifier.height(DSMargin.sm))
        Text(
            text = title,
            textAlign = TextAlign.Center,
            style = DSTypography.bodySmall,
            color= DSColor.textColorDark,
        )

        Spacer(modifier = Modifier.height(DSMargin.xxs))
        Text(
            text = description,
            textAlign = TextAlign.Center,
            style = DSTypography.labelMedium,
            color= DSColor.textColorDark,
        )
        onClick?.let {
            Spacer(modifier = Modifier.height(DSMargin.xs))
            DSButton(type = DSButtonType.Primary,  onClick = onClick, text = buttonText)
        }


    }


}

@Preview(showBackground = true)
@Composable
private fun DarkFontPreview() {
    DSTheme {
        Surface {
            DSStatusView(
                type = DSStatusViewType.GenericError,
                description = " Chip LightChip LightChip LightChip LightChip LightChip LightChip Light",
                onClick = {},
                buttonText = "Tentar de novo",
                title = " Chip Light"
            )
        }
    }
}