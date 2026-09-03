package com.ehan.tutasting.engine

import android.os.Parcelable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.parcelize.Parcelize
import com.ehan.tutasting.model.ScreenPhase


@Parcelize
class GameEngine() : Parcelable {
    private val _screenPhase = MutableStateFlow(ScreenPhase.MAINMENU)
    val screenPhase: StateFlow<ScreenPhase> = _screenPhase.asStateFlow()

    fun startNewGame() {
        _screenPhase.value = ScreenPhase.PLAYING
    }
}
