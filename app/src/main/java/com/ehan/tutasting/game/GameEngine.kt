package com.ehan.tutasting.game

import android.os.Parcelable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.parcelize.Parcelize
import com.ehan.tutasting.model.ScreenPhase
import com.ehan.tutasting.model.PlayerGame
import com.ehan.tutasting.model.Pilihan


@Parcelize
class GameEngine() : Parcelable {
    private val _screenPhase = MutableStateFlow<ScreenPhase>(ScreenPhase.SPLASH)
    val screenPhase: StateFlow<ScreenPhase> = _screenPhase.asStateFlow()
    
    private val _dia = MutableStateFlow<Pilihan?>(null)
    val dia: StateFlow<Pilihan?> = _dia.asStateFlow()
    
    private val _bot = MutableStateFlow<Pilihan?>(null)
    val bot: StateFlow<Pilihan?> = _bot.asStateFlow()

    fun startNewGame() {
        resetGame()
        _screenPhase.value = ScreenPhase.PLAYING
    }
    fun resetGame() {
        setDia(null)
        setBot(null)
    }
    fun toLoadingScreen() {
        _screenPhase.value = ScreenPhase.LOADING
    }
    fun toMainMenu() {
        _screenPhase.value = ScreenPhase.MAINMENU
    }
    fun setDia(a: Pilihan?) {
        _dia.value = a
    }
    fun setBot(a: Pilihan?) {
        _bot.value = a
    }
    fun takeRandom(): Pilihan {
        val listAngka: List<Int> = listOf(0, 1, 2)
        val angka: Int = listAngka.shuffled().random()
        return when (angka) {
            1 -> {
                Pilihan.KERTAS
            }
            2 -> {
                Pilihan.GUNTING
            }
            else -> {
                Pilihan.BATU
            }
        }
    }

    fun cekWin(a: Pilihan, b: Pilihan): Pilihan? {
        val cekA: Boolean = ((a == Pilihan.BATU && b == Pilihan.GUNTING) || (a == Pilihan.KERTAS && b == Pilihan.BATU) || (a == Pilihan.GUNTING && b == Pilihan.KERTAS))
        val cekB: Boolean = ((b == Pilihan.BATU && a == Pilihan.GUNTING) || (b == Pilihan.KERTAS && a == Pilihan.BATU) || (b == Pilihan.GUNTING && a == Pilihan.KERTAS))

        if (a == b) {
            return null
        } else if (cekA) {
            return a
        } else if (cekB) {
            return b
        }
        return null
    }
}
