package br.com.app.futebolnatv.channel.presentation.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.topbar.DSTopBar
import br.com.app.futebolnatv.channel.domain.model.Channel
import br.com.app.futebolnatv.channel.presentation.ui.view.ChannelListFilterScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChannelListFilterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val extras = intent.extras
        var channel: Channel? = null
        extras?.let { bundle ->
            channel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable("channel", Channel::class.java)
            } else {
                bundle.getParcelable("channel")
            }
        }

        setContent {
            DSTheme {
                Scaffold(
                    topBar = {
                        DSTopBar(
                            title = "Selecionar Filtro - Canal",
                            backClick = {
                                onBackPressedDispatcher.onBackPressed()
                            }
                        )
                    },
                    content = ({
                        ChannelListFilterScreen(
                            itemSelectedClick = ::itemSelected,
                            itemSelected = channel
                        )
                    })


                )
            }
        }
    }

    private fun itemSelected(channel: Channel?) {
        println(channel?.name?:"Nao selecionou item")
        setResult(RESULT_OK, Intent().putExtra("channel", channel));
        finish()
    }
}

