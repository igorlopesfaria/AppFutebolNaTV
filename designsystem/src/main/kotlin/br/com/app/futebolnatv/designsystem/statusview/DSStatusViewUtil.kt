package br.com.app.futebolnatv.designsystem.statusview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import br.com.app.futebolnatv.designsystem.R


@Composable
fun DSStatusViewType.getIcon()  =
    when (this) {
        DSStatusViewType.NoInternet -> {
            Image(
                modifier = Modifier.size(102.dp),
                painter = painterResource(id = R.drawable.ic_wifi),
                contentDescription = "Google Button"
            )

        }
        DSStatusViewType.GenericError -> {
            Image(
                modifier = Modifier.size(102.dp),
                painter = painterResource(id = R.drawable.ic_error),
                contentDescription = "Google Button"
            )
        }
    }