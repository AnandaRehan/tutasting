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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlin.random.Random
import com.ehan.tutasting.ShowMessage
import com.ehan.tutasting.game.GameViewModel
import com.ehan.tutasting.model.PlayerGame
import com.ehan.tutasting.model.Pilihan

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    viewModel: GameViewModel
    // Cara alternatif jika ingin tetap ada nama labelnya
// onCekWin: ((a: PlayerGame, b: PlayerGame) -> PlayerGame?), 
) {
    val context: Context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val screenPhase by viewModel.screenPhase.collectAsStateWithLifecycle(lifecycleOwner = lifecycleOwner)

    var refreshScreen: Boolean by rememberSaveable { mutableStateOf(false) }

    val dia by viewModel.dia.collectAsStateWithLifecycle(lifecycleOwner = lifecycleOwner)
    val bot by viewModel.bot.collectAsStateWithLifecycle(lifecycleOwner = lifecycleOwner)

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
                    viewModel.setDia(Pilihan.BATU)
                    _refreshScreen()
                }
            ) {
                Text(text = "Batu")
            }
            Button(
                onClick = {
                    viewModel.setDia(Pilihan.KERTAS)
                    _refreshScreen()
                }
            ) {
                Text(text = "KERTAS")
            }
            Button(
                onClick = {
                    viewModel.setDia(Pilihan.GUNTING)
                    _refreshScreen()
                }
            ) {
                Text(text = "GUNTING")
            }
        } else {
            viewModel.setBot(viewModel.takeRandom())
            /**val pilihanDia = dia
            val pilihanBot = bot*/
            if (dia != null && bot != null) {
                Text(text = "Pemain pilih ${dia.displayName}")
                Text(text = "Bot Pilih ${bot.displayName}")
                var tulisan: String = ""

                when (viewModel.cekWin(dia, bot)) {
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
                        viewModel.resetGame()
                        _refreshScreen()
                    }
                ) {
                    Text(text = "Ulang")
                }
            } else {
                resetGame()
                _refreshScreen()
            }
        }
        Button(
            onClick = {
                resetGame()
                viewModel.toMainMenu()
                _refreshScreen()
            }
        ) {
            Text(text = "Ke MainMenu")
        }
    }
}