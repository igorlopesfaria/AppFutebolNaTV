package br.com.app.futebolnatv

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FutebolNaTVApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }

}