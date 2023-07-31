package br.com.app.futebolnatv.team.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    var id: Int,
    var name: String,
    var shortName: String,
    var shieldUrl: String
): Parcelable