package br.com.app.futebolnatv.designsystem.chip

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.core.color.DSColor
import br.com.app.futebolnatv.designsystem.core.dimen.DSIconSize
import br.com.app.futebolnatv.designsystem.core.font.DSTypography


@Composable
fun DSChip(
    selected: Boolean,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconRight: ImageVector? = null,
) {

    Surface (
        color = when {
            selected -> DSColor.yellow
            else -> DSColor.backgroundWhite
        },
        shape = CircleShape,
        border = BorderStroke(
            width = 1.dp,
            color = when {
                selected -> DSColor.yellow
                else -> DSColor.textColorLight
            },
        ),
        modifier = modifier,
        onClick = onClick
    ) {
        Box(modifier = Modifier.padding(start = 6.dp, end = 9.dp, top = 6.dp,  bottom = 6.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically){
                if (iconRight != null)
                    Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    style = DSTypography.labelLarge,
                    color = when {
                        selected -> DSColor.green
                        else -> DSColor.textColorDark
                    },
                )

                if(iconRight != null) {
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        imageVector = iconRight,
                        modifier =Modifier.size(DSIconSize.small),
                        contentDescription = "drawable_icons",
                        tint = when {
                            selected -> DSColor.green
                            else -> DSColor.textColorDark
                        }
                    )
                }
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
private fun DarkFontPreview() {
    DSTheme {
        Surface {
            DSChip(
                selected = true,
                iconRight = Icons.Default.ArrowDropDown,
                onClick = { /*TODO*/ },
                text = " Chip Dark"
            )
        }
    }
}

