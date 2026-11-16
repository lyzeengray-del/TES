package com.lvngx.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Night = Color(0xFF080D1B)
private val Panel = Color(0xFF121B30)
private val Crimson = Color(0xFFF20D50)
private val Muted = Color(0xFF9AA7C2)
private val White = Color(0xFFF6F7FB)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Night
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
private fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF10182B), Night, Color(0xFF090D18))
                )
            )
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 28.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "LVNG -X",
                    color = White,
                    fontSize = 29.sp,
                    fontWeight = FontWeight.Black,
                    letterSpacing = 1.2.sp
                )
                Text(
                    text = "RED GLASS GAMING SYSTEM",
                    color = Crimson,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.6.sp
                )
            }
            Box(
                modifier = Modifier
                    .background(Crimson.copy(alpha = 0.14f), RoundedCornerShape(14.dp))
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text("0.1.0", color = White, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Panel.copy(alpha = 0.92f), RoundedCornerShape(24.dp))
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("SYSTEM OVERVIEW", color = Muted, fontSize = 10.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.4.sp)
            Text("Your game space starts here.", color = White, fontSize = 21.sp, fontWeight = FontWeight.Bold)
            Text(
                "Fondasi aplikasi sudah disiapkan. Integrasi akses Android dan engine fitur akan ditambahkan bertahap.",
                color = Muted,
                fontSize = 13.sp,
                lineHeight = 19.sp
            )
            Spacer(Modifier.height(2.dp))
            StatusLine("Shizuku Access", "Belum diintegrasikan")
            StatusLine("Overlay Engine", "Belum diintegrasikan")
            StatusLine("Macro Engine", "Belum diintegrasikan")
        }

        Text("FEATURE MODULES", color = Muted, fontSize = 10.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.5.sp)

        FeatureCard(
            "GAME SPACE",
            "Game library, smart game detection, curved side panel, floating handle, auto-hide, dan game profiles.",
            "PLANNED"
        )
        FeatureCard(
            "MACRO ENGINE PRO",
            "Trigger dan target terpisah, hold-to-repeat, speed slider, saved profiles, dan emergency stop.",
            "PLANNED"
        )
        FeatureCard(
            "PERFORMANCE INTELLIGENCE",
            "CPU, RAM, suhu, baterai, FPS jika tersedia, thermal status, dan resource guard.",
            "PLANNED"
        )
        FeatureCard(
            "BACKUP & RESTORE",
            "Selective backup, file .lvngx, integrity check, conflict detection, snapshot, dan rollback.",
            "PLANNED"
        )
        FeatureCard(
            "DIAGNOSTICS CENTER",
            "Pemeriksaan izin, Shizuku, overlay, Accessibility, storage, service, device, dan kompatibilitas.",
            "PLANNED"
        )

        Text(
            "LVNG -X  •  Android foundation",
            color = Muted.copy(alpha = 0.72f),
            fontSize = 10.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 6.dp, bottom = 10.dp)
        )
    }
}

@Composable
private fun StatusLine(label: String, status: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, color = White, fontSize = 12.sp, fontWeight = FontWeight.Medium)
        Text(status, color = Crimson, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun FeatureCard(title: String, description: String, state: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Panel.copy(alpha = 0.88f), RoundedCornerShape(20.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title, color = White, fontSize = 13.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.4.sp)
            Text(state, color = Crimson, fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.8.sp)
        }
        Text(description, color = Muted, fontSize = 12.sp, lineHeight = 18.sp)
    }
}
