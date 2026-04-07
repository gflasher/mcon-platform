package com.mcon.agnum.ui.theme

import androidx.compose.ui.graphics.Color

// ──────────────────────────────────────────
// Global Color Tokens — MCON Agnum Color Palette
// ──────────────────────────────────────────
object MconAgnumColors {
    // Blue Palette (Primary)
    val Blue50  = Color(0xFFE8F0FE)
    val Blue100 = Color(0xFFC5D7FB)
    val Blue200 = Color(0xFF9DBDF8)
    val Blue300 = Color(0xFF6EA3F4)
    val Blue400 = Color(0xFF4D8EF1)
    val Blue500 = Color(0xFF1A73E8)  // MCON Primary
    val Blue600 = Color(0xFF1565D0)
    val Blue700 = Color(0xFF0D52B5)
    val Blue800 = Color(0xFF0642A0)
    val Blue900 = Color(0xFF002F7A)

    // Dark mode Blue
    val Blue200Dark = Color(0xFF82B4FF)  // Primary Dark
    val Blue800Dark = Color(0xFF0042A0)  // PrimaryContainer Dark

    // Teal Palette (Secondary)
    val Teal50  = Color(0xFFE0F2F1)
    val Teal200 = Color(0xFF80CBC4)
    val Teal400 = Color(0xFF26A69A)
    val Teal500 = Color(0xFF00897B)  // MCON Secondary
    val Teal600 = Color(0xFF00796B)
    val Teal700 = Color(0xFF00695C)

    // Dark mode Teal
    val Teal200Dark = Color(0xFF4DB6AC)  // Secondary Dark

    // Red Palette (Error / Warning)
    val Red100 = Color(0xFFFFCDD2)
    val Red200 = Color(0xFFEF9A9A)
    val Red300 = Color(0xFFE57373)
    val Red700 = Color(0xFFD32F2F)  // Error Light
    val Red800 = Color(0xFFC62828)
    val Red900 = Color(0xFFB71C1C)

    // Neutral Palette (Surface / On-Surface)
    val Neutral0   = Color(0xFFFFFFFF)  // Surface Light
    val Neutral5   = Color(0xFFF5F5F7)
    val Neutral10  = Color(0xFFEEEEF2)
    val Neutral20  = Color(0xFFE7E0EC)  // SurfaceVariant Light
    val Neutral30  = Color(0xFFCAC4D0)  // OnSurfaceVariant Dark
    val Neutral50  = Color(0xFF938F99)  // Outline Dark
    val Neutral60  = Color(0xFF79747E)  // Outline Light
    val Neutral80  = Color(0xFF49454F)  // OnSurfaceVariant Light / SurfaceVariant Dark
    val Neutral90  = Color(0xFF322F37)
    val Neutral95  = Color(0xFF1C1B1F)  // OnSurface Light
    val Neutral98  = Color(0xFF1E1E1E)  // NotificationRead Dark
    val Neutral99  = Color(0xFF121212)  // Surface Dark
    val Neutral100 = Color(0xFFE6E1E5)  // OnSurface Dark

    // Scrim & Overlay
    val Scrim = Color(0xFF000000)
    val OverlayLight = Color(0x1A000000)   // 10% black
    val OverlayMedium = Color(0x33000000)  // 20% black
}
