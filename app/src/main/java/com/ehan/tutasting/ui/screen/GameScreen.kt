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
    onTakeRandom: () -> Pilihan,
    onCekWin: (Pilihan, Pilihan) -> Pilihan?,
    onMainMenu: () -> Unit
    // Cara alternatif jika ingin tetap ada nama labelnya
// onCekWin: ((a: PlayerGame, b: PlayerGame) -> PlayerGame?), 
) {
    val context: Context = LocalContext.current

    var refreshScreen: Boolean by rememberSaveable { mutableStateOf(false) }

    var dia: Pilihan? = null
    var bot: Pilihan? = null

    fun _refreshScreen() {
        refreshScreen = !refreshScreen
    }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        if (dia == null) {
            Text(text = "Pilih")
            Button(
                onClick = {
                    bot = onTakeRandom()
                    dia = Pilihan.BATU
                    _refreshScreen()
                }
            ) {
                Text(text = "Batu")
            }
            Button(
                onClick = {
                    bot = onTakeRandom()
                    dia = Pilihan.KERTAS
                    _refreshScreen()
                }
            ) {
                Text(text = "KERTAS")
            }
            Button(
                onClick = {
                    bot = onTakeRandom()
                    dia = Pilihan.GUNTING
                    _refreshScreen()
                }
            ) {
                Text(text = "GUNTING")
            }
        } else {
            if (bot == null) {
                bot = onTakeRandom()
            }
            Text(text = "Pemain pilih $dia")
            Text(text = "Bot Pilih $bot")
            var tulisan: String = ""

            when (onCekWin(dia, bot)) {
                dia -> {
                    tulisan = "Pemain Win"
                }
                bot -> {
                    tulisan = "Bot Win"
                }
                else -> {
                    tulisan = "Draw"
                }
            }
            Text(text = tulisan)
            Button(
                onClick = {
                    dia = null
                    bot = null
                    _refreshScreen()
                }
            ) {
                Text(text = "Ulang")
            }
        }
        Button(
            onClick = {
                dia = null
                bot = null
                onMainMenu()
                _refreshScreen()
            }
        ) {
            Text(text = "Ke MainMenu")
        }
    }
}