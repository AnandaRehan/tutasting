package com.ehan.tutasting.ui.screen

import android.content.Context
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random
import com.ehan.tutasting.ShowMessage
import com.ehan.tutasting.model.PlayerGame
import com.ehan.tutasting.model.Pilihan

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    onCekWin: (a: PlayerGame, b: PlayerGame): PlayerGame? -> Unit,
    onMainMenu: () -> Unit
) {
    val context: Context = LocalContext.current
    var p1: PlayerGame by rememberSaveable { mutableStateOf<PlayerGame>(PlayerGame("P1")) }
    var bot: PlayerGame by rememberSaveable { mutableStateOf<PlayerGame>(PlayerGame("BOT")) }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        if (p1.pilih == null) {
            Text(text = "Pilih")
            Button(
                onClick = {
                    val listAngka: List<Int> = listOf(0, 1, 2)
                    val angka: Int = listAngka.shuffled().random()
                    bot.pilih = when (angka) {
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
                    p1.pilih = Pilihan.BATU
                }
            ) {
                Text(text = "Batu")
            }
            Button(
                onClick = {
                    val listAngka: List<Int> = listOf(0, 1, 2)
                    val angka: Int = listAngka.shuffled().random()
                    bot.pilih = when (angka) {
                        1 -> {
                            Pilihan.KERTAS
                        }
                        2 -> {
                            Pilihan.GUNTING
                        }
                        else -> {
                            Pilihan.BATU
                        }
                    p1.pilih = Pilihan.KERTAS
                }
            ) {
                Text(text = "KERTAS")
            }
            Button(
                onClick = {
                    val listAngka: List<Int> = listOf(0, 1, 2)
                    val angka: Int = listAngka.shuffled().random()
                    bot.pilih = when (angka) {
                        1 -> {
                            Pilihan.KERTAS
                        }
                        2 -> {
                            Pilihan.GUNTING
                        }
                        else -> {
                            Pilihan.BATU
                        }
                    p1.pilih = Pilihan.GUNTING
                }
            ) {
                Text(text = "GUNTING")
            }
        } else {
            if (bot.pilih == null) {
                val listAngka: List<Int> = listOf(0, 1, 2)
                val angka: Int = listAngka.shuffled().random()
                bot.pilih = when (angka) {
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
            Text(text = "Pemain pilih $p1.pilih.label")
            Text(text = "Bot Pilih $bot.pilih.label")
            var tulisan: String = ""

            when (onCekWin(p1, bot)) {
                p1 -> {
                    tulisan = "P1 Win"
                }
                bot -> {
                    tulisan = "Bot Win"
                }
                else {
                    tulisan = "Draw"
                }
            }
            Text(text = tulisan)
            Button(
                onClick = {
                    p1.pilih = null
                    bot.pilih = null
                }
            ) {
                Text(text = "Ulang")
            }
        }
        Button(
            onClick = {
                p1.pilih = null
                bot.pilih = null
                onMainMenu()
            }
        ) {
            Text(text = "Ke MainMenu")
        }
    }
}