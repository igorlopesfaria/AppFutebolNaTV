package br.com.app.futebolnatv.designsystem.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.app.futebolnatv.designsystem.R
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.core.color.DSColor
import br.com.app.futebolnatv.designsystem.core.font.DSTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DSTopBar(
    title: String? = null,
    hasMainLogo: Boolean? = false,
    backClick: (() -> Unit)? = null
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            backClick?.let { click ->
                IconButton(onClick = {
                    click.invoke()
                }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        tint = DSColor.green,
                        contentDescription = "Go Back"
                    )
                }
            }


        },
        title = {
            Row {
                title?.let {
                    Text(text = it,
                        textAlign = TextAlign.Center,
                        style = DSTypography.bodySmall,
                        color= DSColor.green,)
                }
                if(hasMainLogo == true){
                    Image(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.launcher),
                        contentDescription = "Google Button"
                    )
                }
            }
        },
        colors = topAppBarColors(DSColor.backgroundGray)
    )

}

@Preview(showBackground = true)
@Composable
private fun DarkFontPreview() {
    DSTheme {
        Surface {
            DSTopBar(
                hasMainLogo = true,
            )
        }
    }
}