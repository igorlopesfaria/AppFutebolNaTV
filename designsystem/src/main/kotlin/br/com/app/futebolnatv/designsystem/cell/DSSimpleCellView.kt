package br.com.app.futebolnatv.designsystem.cell
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.app.futebolnatv.designsystem.R
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.core.color.DSColor
import br.com.app.futebolnatv.designsystem.core.dimen.DSMargin
import br.com.app.futebolnatv.designsystem.core.dimen.DSRadiusSize
import br.com.app.futebolnatv.designsystem.core.font.DSTypography
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DSSimpleCell(
    label: String,
    id: Int,
    isSelected: Boolean = false,
    urlImage: String? = null,
    placeholder: Int? = null,
    onClick: (Int) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = DSMargin.xxs),
        shape = RoundedCornerShape(DSRadiusSize.medium),
        colors = CardDefaults.cardColors(
            containerColor = DSColor.backgroundWhite,
        ),
        onClick = {
            onClick(id)
        }
    ) {
        Row(Modifier.padding(DSMargin.xs), verticalAlignment = Alignment.CenterVertically) {

            urlImage?.let {
                AsyncImage(
                    modifier = Modifier.height(22.dp),
                    model = it,
                    placeholder = painterResource(placeholder ?: R.drawable.baseline_image_24),// R.drawable.ic_shield,
                    error = painterResource(placeholder ?: R.drawable.baseline_image_24),
                    contentDescription = "Translated description of what the image contains"
                )
                Box(modifier = Modifier.padding(start= DSMargin.xxs))

            }
            Text(
                text = label,
                textAlign = TextAlign.Center,
                style = DSTypography.bodySmall,
                color= DSColor.textColorDark,
            )
            Spacer(Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.Check,
                tint = if(isSelected) DSColor.green else DSColor.backgroundWhite,
                contentDescription = ""
            )
        }
    }


}

@Preview(showBackground = true)
@Preview(name = "Full Preview", showSystemUi = true)
@Composable
private fun DarkFontPreview() {
    DSTheme {
        Surface {
            DSSimpleCell(
                label = "Bahia",
                id = 1,
                isSelected = true,
                onClick = {
                    println(it)
                }
            )
        }
    }
}