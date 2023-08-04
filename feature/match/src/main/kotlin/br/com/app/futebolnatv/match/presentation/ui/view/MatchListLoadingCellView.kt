package br.com.app.futebolnatv.match.presentation.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.core.color.DSColor
import br.com.app.futebolnatv.designsystem.core.dimen.DSMargin
import br.com.app.futebolnatv.designsystem.core.dimen.DSRadiusSize
import com.valentinilk.shimmer.shimmer

@Composable
fun MatchListLoadingCellView() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(vertical = DSMargin.xxs),
        shape = RoundedCornerShape(DSRadiusSize.medium),
        colors = CardDefaults.cardColors(
            containerColor = DSColor.backgroundWhite,
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .shimmer(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(DSColor.backgroundShimmerGray)

            )
        }


    }
}

@Preview(showBackground = true)
@Preview(name = "Full Preview", showSystemUi = true)
@Composable
private fun MatchLoadingViewPreview() {
    DSTheme {
        Surface {
            MatchListLoadingCellView()
        }
    }
}