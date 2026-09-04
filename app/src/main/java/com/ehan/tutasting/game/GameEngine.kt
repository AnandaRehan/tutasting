package com.ehan.tutasting.game

import android.os.Parcelable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.parcelize.Parcelize
import com.ehan.tutasting.model.ScreenPhase
import com.ehan.tutasting.model.PlayerGame


@Parcelize
class GameEngine() : Parcelable {
    private val _screenPhase = MutableStateFlow(ScreenPhase.MAINMENU)
    val screenPhase: StateFlow<ScreenPhase> = _screenPhase.asStateFlow()

    fun startNewGame() {
        _screenPhase.value = ScreenPhase.PLAYING
    }
    fun toMainMenu() {
        _screenPhase.value = ScreenPhase.MAINMENU
    }

    fun cekWin(a: PlayerGame, b: PlayerGame): PlayerGame? {
        if (a.pilih == null && b.pilih == null) {
            return null
        } else if (a.pilih == null && b.pilih != null) {
            return b
        } else if (b.pilih == null && a.pilih != null) {
            return a
        }
        val cekA: Boolean = ((a.pilih == Pilihan.BATU && b.pilih == Pilihan.GUNTING) || (a.pilih == Pilihan.KERTAS && b.pilih == Pilihan.BATU) || (a.pilih == Pilihan.GUNTING && b.pilih == Pilihan.KERTAS))
        val cekB: Boolean = ((b.pilih == Pilihan.BATU && a.pilih == Pilihan.GUNTING) || (b.pilih == Pilihan.KERTAS && a.pilih == Pilihan.BATU) || (b.pilih == Pilihan.GUNTING && a.pilih == Pilihan.KERTAS))

        if (a.pilih == b.pilih) {
            return null
        } else if (cekA) {
            return a
        } else if (cekB) {
            return b
        }
        return null
    }
}
