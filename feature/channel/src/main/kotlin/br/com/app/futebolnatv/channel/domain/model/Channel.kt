package br.com.app.futebolnatv.channel.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Channel(
    var id: Int,
    var name: String,
    var logoUrl: String
): Parcelable