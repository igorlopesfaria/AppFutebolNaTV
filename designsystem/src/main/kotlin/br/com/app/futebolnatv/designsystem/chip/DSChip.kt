package br.com.app.futebolnatv.designsystem.chip

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.app.futebolnatv.designsystem.R
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.core.color.DSColor
import br.com.app.futebolnatv.designsystem.core.dimen.DSIconSize
import br.com.app.futebolnatv.designsystem.core.font.DSTypography
sealed interface DSChipSize {
    object Small : DSChipSize
    object Normal : DSChipSize
    object Big : DSChipSize
}

@Composable
fun DSChip(
    selected: Boolean,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconRight: ImageVector? = null,
    iconLeft: Int? = null,
    size: DSChipSize = DSChipSize.Normal
    ) {

    Surface(
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
        Box(modifier = Modifier.padding(start = 6.dp, end = 9.dp, top = 6.dp, bottom = 6.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(  modifier = when (size) {
                    DSChipSize.Big -> Modifier.size(DSIconSize.medium)
                    DSChipSize.Normal -> Modifier.size(DSIconSize.small)
                    DSChipSize.Small -> Modifier.size(DSIconSize.tinny)
                })

                iconLeft?.let {
                    Icon(
                        painter = painterResource(id = it),
                        modifier = when (size) {
                            DSChipSize.Big -> Modifier.size(DSIconSize.medium)
                            DSChipSize.Normal -> Modifier.size(DSIconSize.small)
                            DSChipSize.Small -> Modifier.size(DSIconSize.tinny)
                        },
                        contentDescription = "drawable_icons",
                        tint = when {
                            selected -> DSColor.green
                            else -> DSColor.textColorDark
                        }
                    )
                    Spacer(modifier =  when (size) {
                        DSChipSize.Big -> Modifier.width(5.dp)
                        DSChipSize.Normal -> Modifier.width(3.dp)
                        DSChipSize.Small -> Modifier.width(2.dp)
                    })
                }
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    style = when (size) {
                        DSChipSize.Big -> DSTypography.bodySmall
                        DSChipSize.Normal -> DSTypography.labelLarge
                        DSChipSize.Small -> DSTypography.labelMedium
                    },
                    color = when {
                        selected -> DSColor.green
                        else -> DSColor.textColorDark
                    },
                )
                Spacer(modifier =  when (size) {
                    DSChipSize.Big -> Modifier.width(8.dp)
                    DSChipSize.Normal -> Modifier.width(6.dp)
                    DSChipSize.Small -> Modifier.width(4.dp)
                })


                iconRight?.let {
                    Icon(
                        imageVector = iconRight,
                        modifier = when (size) {
                            DSChipSize.Big -> Modifier.size(DSIconSize.medium)
                            DSChipSize.Normal -> Modifier.size(DSIconSize.small)
                            DSChipSize.Small -> Modifier.size(DSIconSize.tinny)
                        },
                        contentDescription = "drawable_icons",
                        tint = when {
                            selected -> DSColor.green
                            else -> DSColor.textColorDark
                        }
                    )
                } ?: run {
                    Spacer( modifier = when (size) {
                        DSChipSize.Big -> Modifier.width(6.dp)
                        DSChipSize.Normal -> Modifier.width(4.dp)
                        DSChipSize.Small -> Modifier.width(2.dp)
                    })
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
            Column {
                DSChip(
                    selected = false,
                    iconLeft = R.drawable.ic_tv_sm,
                    onClick = { /*TODO*/ },
                    text = "Chip Dark",
                    size = DSChipSize.Big
                )
                DSChip(
                    selected = false,
                    iconLeft = R.drawable.ic_tv_sm,
                    onClick = { /*TODO*/ },
                    text = "Chip Dark",
                    size = DSChipSize.Normal
                )
                DSChip(
                    selected = false,
                    onClick = { /*TODO*/ },
                    text = "Chip Dark",
                    size = DSChipSize.Small,)

            }
        }
    }
}

