package com.ehan.tutasting.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class ScreenPhase() : Parcelable {
    SPLASH,
    LOADING,
    MAINMENU,
    CHANGEMODE,
    PLAYING,
    SETTINGS,
    PAUSED
}


@Parcelize
data class PlayerGame(
    val name: String,
    var pilih: Pilihan? = null
) : Parcelable


@Parcelize
enum class Pilihan(
    val label: String 
) : Parcelable {
    BATU("Batu"),
    KERTAS("Kertas"),
    GUNTING("Gunting");
}