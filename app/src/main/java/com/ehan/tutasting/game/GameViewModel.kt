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

    val dia = engine.dia
    val bot = engine.bot

    fun startNewGame() {
        engine.startNewGame()
    }
    fun resetGame() {
        engine.resetGame()
    }
    fun mainMenu() {
        engine.toMainMenu()
    }
    fun setDia(a: Pilihan?) {
        engine.setDia(a)
    }
    fun setBot(a: Pilihan?) {
        engine.setBot(a)
    }
    fun takeRandom(): Pilihan {
        return engine.takeRandom()
    }
    fun cekWin(a: Pilihan, b: Pilihan): Pilihan? {
        return engine.cekWin(a, b)
    }
}