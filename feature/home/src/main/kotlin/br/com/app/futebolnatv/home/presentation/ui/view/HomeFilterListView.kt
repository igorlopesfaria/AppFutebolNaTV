package br.com.app.futebolnatv.home.presentation.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import br.com.app.futebolnatv.channel.domain.model.Channel
import br.com.app.futebolnatv.designsystem.chip.DSChip
import br.com.app.futebolnatv.designsystem.core.color.DSColor
import br.com.app.futebolnatv.designsystem.core.dimen.DSMargin
import br.com.app.futebolnatv.designsystem.core.font.DSTypography
import br.com.app.futebolnatv.team.domain.model.Team

@Composable
fun HomeFilterListView(
    teamSelected: Team ? = null,
    channelSelected: Channel? = null,
    filterTeamClick: () -> Unit,
    filterChannelClick: () -> Unit
) {
    var filterList: List<String> = listOf(
        teamSelected?.name ?: "Time",
        channelSelected?.name ?: "Canal"
    )
    Column(Modifier.padding(horizontal = DSMargin.xs )) {
        Text(
            text = "Filtrar por:",
            textAlign = TextAlign.Center,
            style = DSTypography.labelSmall,
            color = DSColor.textColorDark,
        )

        LazyRow {
            itemsIndexed(filterList) { index, item ->
                Row (Modifier.padding(end = DSMargin.xxs)){
                    DSChip(selected = item != "Time" &&  item != "Canal",
                        text = item,
                        onClick = {
                            when (index) {
                                0 -> filterTeamClick.invoke()
                                else -> filterChannelClick.invoke()
                            }
                        },
                        iconRight = Icons.Default.ArrowDropDown)
                }
            }
        }
    }



}

