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
enum class PlayerGame(
    val displayName: String
) : Parcelable {
    PLAYER1("PLAYER 1"),
    PLAYER2("PLAYER 2");
}

@Parcelize
enum class Pilihan(
    val displayName: String,
    val code: String
) : Parcelable {
    BATU("BATU", "A"),
    KERTAS("KERTAS", "B"),
    GUNTING("GUNTING", "C");
}