package br.com.app.futebolnatv.designsystem.button

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.app.futebolnatv.designsystem.core.DSTheme

sealed interface DSButtonType {
    object Primary : DSButtonType
    object Link : DSButtonType
}

@Composable
fun DSButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    type: DSButtonType = DSButtonType.Primary,
) {
    when (type) {
        DSButtonType.Primary -> {
            DSButtonPrimary(onClick, text, modifier, isLoading)
        }
        DSButtonType.Link -> {
            DSButtonLink(onClick, text, modifier, isLoading)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DSButtonPreview() {
    DSTheme {
        Surface {
            DSButton(
                type = DSButtonType.Primary,
                isLoading = true,
                onClick = { /*TODO*/ },
                text = "Igor Light"
            )
        }
    }
}