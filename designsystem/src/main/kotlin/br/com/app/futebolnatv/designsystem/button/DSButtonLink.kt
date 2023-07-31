package br.com.app.futebolnatv.designsystem.button


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.app.futebolnatv.core.extentions.alphaVisibility
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.core.color.DSColor
import br.com.app.futebolnatv.designsystem.core.dimen.DSBorderSize
import br.com.app.futebolnatv.designsystem.core.dimen.DSCircularProgressSize
import br.com.app.futebolnatv.designsystem.core.dimen.DSRadiusSize
import br.com.app.futebolnatv.designsystem.core.dimen.DSStrokeSize
import br.com.app.futebolnatv.designsystem.core.font.DSTypography

@Composable
internal fun DSButtonLink (
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.height(45.dp),
        shape = RoundedCornerShape(DSRadiusSize.medium),
        border = BorderStroke(DSBorderSize.small, Color.Transparent)) {
        Box(contentAlignment = Alignment.Center){
            CircularProgressIndicator(
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .alpha(isLoading.alphaVisibility())
                    .progressSemantics()
                    .size(DSCircularProgressSize.medium),
                color = DSColor.green,
                strokeWidth = DSStrokeSize.medium
            )
            Text(
                text = text,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.align(alignment = Alignment.Center)
                    .alpha((!isLoading).alphaVisibility()),
                style = DSTypography.labelMedium,
                color= DSColor.green
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun DSButtonLinkPreview() {
    DSTheme {
        Surface {
            DSButtonLink(
                onClick = { /*TODO*/ },
                text = "Igor Dark")
        }
    }
}