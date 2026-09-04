package com.ehan.tutasting.game

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.ehan.tutasting.model.ScreenPhase
import com.ehan.tutasting.model.Pilihan
import com.ehan.tutasting.model.PlayerGame

class GameViewModel(application: Application) : AndroidViewModel(application) {
    val engine = GameEngine()

    val screenPhase = engine.screenPhase

    fun startNewGame() {
        engine.startNewGame()
    }
    fun mainMenu() {
        engine.toMainMenu()
    }
    fun takeRandom(): Pilihan {
        return engine.takeRandom()
    }
    fun cekWin(a: PlayerGame, b: PlayerGame): PlayerGame? {
        return engine.cekWin(a, b)
    }
}