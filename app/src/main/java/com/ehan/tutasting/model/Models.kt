package com.ehan.tutasting.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

enum class ScreenPhase {
    SPLASH,
    LOADING,
    MAINMENU,
    CHANGEMODE,
    PLAYING,
    SETTINGS,
    PAUSED
}
