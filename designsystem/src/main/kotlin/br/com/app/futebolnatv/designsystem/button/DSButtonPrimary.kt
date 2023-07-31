package br.com.app.futebolnatv.designsystem.button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.app.futebolnatv.core.extentions.alphaVisibility
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.core.color.DSColor
import br.com.app.futebolnatv.designsystem.core.dimen.DSCircularProgressSize
import br.com.app.futebolnatv.designsystem.core.dimen.DSRadiusSize
import br.com.app.futebolnatv.designsystem.core.dimen.DSStrokeSize
import br.com.app.futebolnatv.designsystem.core.font.DSTypography

@Composable
internal fun DSButtonPrimary (
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().height(45.dp),
        colors = ButtonDefaults.buttonColors(containerColor = DSColor.yellow),
        shape = RoundedCornerShape(DSRadiusSize.medium),
    ) {
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
            Row {
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxHeight().wrapContentHeight(align = Alignment.CenterVertically)
                        .alpha((!isLoading).alphaVisibility()),
                    style = DSTypography.labelMedium,
                    color = DSColor.green
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DSButtonPrimaryPreview() {
    DSTheme {
        Surface {
            DSButtonPrimary(
                onClick = { /*TODO*/ },
                text = "Igor Dark")
        }
    }
}
