package br.com.app.futebolnatv.home.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import br.com.app.futebolnatv.designsystem.core.DSTheme
import br.com.app.futebolnatv.designsystem.topbar.DSTopBar
import br.com.app.futebolnatv.home.presentation.ui.view.HomeContentView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DSTheme {
                Scaffold(
                    topBar = { DSTopBar(hasMainLogo = true) },
                    content = ({ HomeContentView() })
                )
            }
        }
    }
}
