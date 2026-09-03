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
import com.ehan.tutasting.ShowMessage
import com.ehan.tutasting.model.Pilihan

@Composable
fun GameScreen(
    modifier: Modifier = Modifier
) {
    val context: Context = LocalContext.current
    var p1: Pilihan? by rememberSaveable { mutableStateOf<Pilihan?>(null) }
    var p2: Pilihan? by rememberSaveable { mutableStateOf<Pilihan?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        if (p1 == null && p2 == null) {
            Text(text = if (p1 == null) { "Player 1"} else { "Player 2" })
            Button(
                onClick = {
                    if (p1 == null) {
                        p1 = Pilihan.BATU
                    } else {
                        p2 = Piilhan.BATU
                    }
                }
            ) {
                Text(text = "Batu")
            }
            Button(
                onClick = {
                    if (p1 == null) {
                        p1 = Pilihan.KERTAS
                    } else {
                        p2 = Piilhan.KERTAS
                    }
                }
            ) {
                Text(text = "KERTAS")
            }
            Button(
                onClick = {
                    if (p1 == null) {
                        p1 = Pilihan.GUNTING
                    } else {
                        p2 = Piilhan.GUNTING
                    }
                }
            ) {
                Text(text = "GUNTING")
            }
        } else {
            Text(text = "P1 " + p1.toString())
            Text(text = "P2 " + p2.toString())
            var tulisan: String
            if (p1 == p2) {
                tulisan = "Draw"
            }
            
            if (Pilihan.firstWin(p2, p1)) {
                tulisan = "P2 Win"
            } else {
                tulisan = "P1 Win"
            }
        }
    }
}