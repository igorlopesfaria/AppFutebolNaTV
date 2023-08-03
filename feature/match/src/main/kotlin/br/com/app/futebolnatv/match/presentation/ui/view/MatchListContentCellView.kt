package br.com.app.futebolnatv.match.presentation.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.app.futebolnatv.channel.domain.model.Channel
import br.com.app.futebolnatv.designsystem.R
import br.com.app.futebolnatv.designsystem.chip.DSChip
import br.com.app.futebolnatv.designsystem.chip.DSChipSize
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.core.color.DSColor
import br.com.app.futebolnatv.designsystem.core.dimen.DSMargin
import br.com.app.futebolnatv.designsystem.core.dimen.DSRadiusSize
import br.com.app.futebolnatv.designsystem.core.font.DSTypography
import br.com.app.futebolnatv.match.domain.model.Championship
import br.com.app.futebolnatv.match.domain.model.Match
import br.com.app.futebolnatv.team.domain.model.Team
import coil.compose.AsyncImage

@Composable
fun MatchListContentCellView(match: Match) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = DSMargin.xxs),
        shape = RoundedCornerShape(DSRadiusSize.medium),
        colors = CardDefaults.cardColors(
            containerColor = DSColor.backgroundWhite,
        ),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = DSMargin.xs, horizontal = DSMargin.xs).fillMaxWidth()
        ) {
            Text(
                text = match.championship.name,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = DSTypography.labelSmall,
                color= DSColor.textColorDark,
            )
            Text(
                text = "${match.date} - ${match.hour} ",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = DSTypography.bodySmall,
                color= DSColor.textColorDark,
            )
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = DSMargin.xxs),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        AsyncImage(
                            modifier = Modifier.height(46.dp),
                            model = match.teamHome.shieldUrl,
                            placeholder = painterResource(R.drawable.ic_shield_sm),// R.drawable.ic_shield,
                            error =  painterResource(R.drawable.ic_shield_sm),
                            contentDescription = "Translated description of what the image contains"
                        )

                        Text(match.teamHome.name,
                            modifier = Modifier.padding(top = DSMargin.xxxs),
                            textAlign = TextAlign.Center,
                            style = DSTypography.labelMedium,
                            color= DSColor.textColorDark,
                        )
                    }
                    Text("X",
                        modifier = Modifier.padding(horizontal = DSMargin.lg),
                        textAlign = TextAlign.Center,
                        style = DSTypography.titleLarge,
                        color= DSColor.textColorDark,
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        AsyncImage(
                            modifier = Modifier.height(46.dp),
                            model = match.teamAway.shieldUrl,
                            placeholder = painterResource(R.drawable.ic_shield_sm),// R.drawable.ic_shield,
                            error =  painterResource(R.drawable.ic_shield_sm),
                            contentDescription = "Translated description of what the image contains"
                        )

                        Text(match.teamAway.name,
                            modifier = Modifier.padding(top = DSMargin.xxxs),
                            textAlign = TextAlign.Center,
                            style = DSTypography.labelMedium,
                            color= DSColor.textColorDark,
                        )
                    }                     // Fill this with remaining space available

            }
            Row(
                Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                LazyRow {
                    itemsIndexed(match.channels) { index, item ->
                        Row (Modifier.padding(end = DSMargin.xxs)){
                            DSChip(
                                selected = false,
                                iconLeft = R.drawable.ic_tv_sm,
                                text = item.name,
                                size = DSChipSize.Small,
                            )
                        }
                    }
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Preview(name = "Full Preview", showSystemUi = true)
@Composable
private fun MatchCellViewPreview() {
    DSTheme {
        Surface {
            MatchListContentCellView(
                Match(
                    id = 1,
                    championship = Championship(id = 1, name = "Camp. Brasileiro da Série A", logoUrl = ""),
                    date = "28/09",
                    hour = "10:30",
                    channels = listOf(Channel(id = 1, name = "Globo", logoUrl = ""), Channel(id = 2, name = "SporTV", logoUrl = "")),
                    teamHome = Team(id= 1, name = "Bahia", shortName = "BAH", shieldUrl = ""),
                    teamAway = Team(id= 2, name = "Gremio", shortName = "GRE", shieldUrl = "")
                )
            )
        }
    }
}