package br.com.app.futebolnatv.match.presentation.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.app.futebolnatv.channel.domain.model.Channel
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.core.color.DSColor
import br.com.app.futebolnatv.designsystem.core.dimen.DSMargin
import br.com.app.futebolnatv.designsystem.core.dimen.DSRadiusSize
import br.com.app.futebolnatv.match.domain.model.Championship
import br.com.app.futebolnatv.match.domain.model.Match
import br.com.app.futebolnatv.team.domain.model.Team
import com.valentinilk.shimmer.shimmer

@Composable
fun MatchListLoadingCellView() {
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
            modifier = Modifier
                .padding(vertical = DSMargin.xxs, horizontal = DSMargin.xs)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .width(158.dp)
                    .height(18.dp)
                    .shimmer(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(DSColor.backgroundShimmerGray)
                )
            }

            Row(
                modifier = Modifier
                    .width(138.dp)
                    .height(24.dp)
                    .padding(top = DSMargin.xxxxs)
                    .shimmer(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(DSColor.backgroundShimmerGray)
                )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = DSMargin.xxs),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {

                    Row(
                        modifier = Modifier
                            .width(36.dp)
                            .height(46.dp)
                            .shimmer(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .background(DSColor.backgroundShimmerGray)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(top = DSMargin.xxxs)
                            .width(36.dp)
                            .height(16.dp)
                            .shimmer(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .background(DSColor.backgroundShimmerGray)
                        )
                    }

                }
                Row(
                    modifier = Modifier
                        .padding(horizontal = DSMargin.lg)
                        .width(12.dp)
                        .height(26.dp)
                        .shimmer(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(DSColor.backgroundShimmerGray)
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                    Row(
                        modifier = Modifier
                            .width(36.dp)
                            .height(46.dp)
                            .shimmer(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .background(DSColor.backgroundShimmerGray)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .padding(top = DSMargin.xxxs)
                            .width(36.dp)
                            .height(16.dp)
                            .shimmer(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .background(DSColor.backgroundShimmerGray)
                        )
                    }
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .width(66.dp)
                        .height(36.dp)
                        .shimmer(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(DSColor.backgroundShimmerGray)
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(start = DSMargin.xs)
                        .width(66.dp)
                        .height(36.dp)
                        .shimmer(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(DSColor.backgroundShimmerGray)
                    )
                }

            }


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