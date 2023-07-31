package br.com.app.futebolnatv.team.presentation.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.topbar.DSTopBar
import br.com.app.futebolnatv.team.domain.model.Team
import br.com.app.futebolnatv.team.presentation.ui.view.TeamListFilterScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamListFilterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val extras = intent.extras
        var team: Team? = null
        extras?.let { bundle ->
            team = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable("team", Team::class.java)
            } else {
                bundle.getParcelable("team")
            }
        }

        setContent {
            DSTheme {
                Scaffold(
                    topBar = {
                        DSTopBar(
                            title = "Selecionar Filtro - Clube",
                            backClick = {
                                onBackPressedDispatcher.onBackPressed()
                            }
                        )
                    },
                    content = ({
                        TeamListFilterScreen(
                            itemSelectedClick = ::itemSelected,
                            itemSelected = team
                        )
                    })


                )
            }
        }
    }

    private fun itemSelected(team: Team?) {
        println(team?.name?:"Nao selecionou item")
        setResult(RESULT_OK, Intent().putExtra("team", team));
        finish()
    }
}

