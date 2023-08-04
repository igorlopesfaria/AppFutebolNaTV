package br.com.app.futebolnatv.home.presentation.ui.view

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Build.VERSION
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import br.com.app.futebolnatv.channel.domain.model.Channel
import br.com.app.futebolnatv.channel.presentation.ui.ChannelListFilterActivity
import br.com.app.futebolnatv.designsystem.button.DSButton
import br.com.app.futebolnatv.designsystem.button.DSButtonType
import br.com.app.futebolnatv.designsystem.core.color.DSColor
import br.com.app.futebolnatv.match.presentation.ui.view.MatchListView
import br.com.app.futebolnatv.team.domain.model.Team
import br.com.app.futebolnatv.team.presentation.ui.TeamListFilterActivity


@Composable
fun HomeContentView(

) {
    val context = LocalContext.current

    val teamSelected = remember { mutableStateOf<Team?>(null) }
    val channelSelected = remember { mutableStateOf<Channel?>(null) }
    val shouldFilter= remember { mutableStateOf(false) }

    val launcherTeamFilter = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
        if(activityResult.resultCode == Activity.RESULT_OK) {
            activityResult.data?.let { intent ->
                teamSelected.value = if (VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    intent.getParcelableExtra("team", Team::class.java)
                } else {
                    intent.getParcelableExtra("team")
                }
                shouldFilter.value= true
            }

        }
    }
    val launcherChannelFilter = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
        if(activityResult.resultCode == Activity.RESULT_OK) {
            activityResult.data?.let { intent ->
                channelSelected.value = if (VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    intent.getParcelableExtra("channel", Channel::class.java)
                } else {
                    intent.getParcelableExtra("channel")
                }
                shouldFilter.value= true
            }

        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 64.dp)
            .background(DSColor.backgroundGray)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                HomeFilterListView(
                    teamSelected = teamSelected.value,
                    filterTeamClick = {
                        val intent = Intent(context, TeamListFilterActivity::class.java)
                        intent.putExtra("team", teamSelected.value)
                        launcherTeamFilter.launch(intent)
                    },
                    channelSelected = channelSelected.value,
                    filterChannelClick = {
                        val intent = Intent(context, ChannelListFilterActivity::class.java)
                        intent.putExtra("channel", channelSelected.value)
                        launcherChannelFilter.launch(intent)
                    }
                )
                Spacer(Modifier.weight(1f))
                DSButton(onClick = {
                    teamSelected.value = null
                    channelSelected.value = null
                    shouldFilter.value = true

                }, text = "Limpar",
                    type = DSButtonType.Link

                )

            }
            MatchListView(
                teamSelected = teamSelected.value,
                channelSelected = channelSelected.value,
                shouldFilter = shouldFilter.value,
                onClickClearFilter = {
                    teamSelected.value = null
                    channelSelected.value = null
                }
            )
        }
    }
}
