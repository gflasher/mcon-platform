package com.mcon.agnum.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.mcon.agnum.ui.theme.MconAgnumColors.Blue200Dark
import com.mcon.agnum.ui.theme.MconAgnumColors.Blue50
import com.mcon.agnum.ui.theme.MconAgnumColors.Blue500
import com.mcon.agnum.ui.theme.MconAgnumColors.Blue800Dark
import com.mcon.agnum.ui.theme.MconAgnumColors.Blue900
import com.mcon.agnum.ui.theme.MconAgnumColors.Neutral0
import com.mcon.agnum.ui.theme.MconAgnumColors.Neutral10
import com.mcon.agnum.ui.theme.MconAgnumColors.Neutral20
import com.mcon.agnum.ui.theme.MconAgnumColors.Neutral30
import com.mcon.agnum.ui.theme.MconAgnumColors.Neutral50
import com.mcon.agnum.ui.theme.MconAgnumColors.Neutral60
import com.mcon.agnum.ui.theme.MconAgnumColors.Neutral80
import com.mcon.agnum.ui.theme.MconAgnumColors.Neutral95
import com.mcon.agnum.ui.theme.MconAgnumColors.Neutral99
import com.mcon.agnum.ui.theme.MconAgnumColors.Neutral100
import com.mcon.agnum.ui.theme.MconAgnumColors.Red100
import com.mcon.agnum.ui.theme.MconAgnumColors.Red200
import com.mcon.agnum.ui.theme.MconAgnumColors.Red700
import com.mcon.agnum.ui.theme.MconAgnumColors.Red900
import com.mcon.agnum.ui.theme.MconAgnumColors.Scrim
import com.mcon.agnum.ui.theme.MconAgnumColors.Teal200Dark
import com.mcon.agnum.ui.theme.MconAgnumColors.Teal50
import com.mcon.agnum.ui.theme.MconAgnumColors.Teal500
import com.mcon.agnum.ui.theme.MconAgnumColors.Teal700

val MconAgnumLightColorScheme = lightColorScheme(
    primary              = Blue500,
    onPrimary            = Neutral0,
    primaryContainer     = Blue50,
    onPrimaryContainer   = Blue900,
    secondary            = Teal500,
    onSecondary          = Neutral0,
    secondaryContainer   = Teal50,
    onSecondaryContainer = Teal700,
    error                = Red700,
    onError              = Neutral0,
    errorContainer       = Red100,
    onErrorContainer     = Red900,
    background           = Neutral0,
    onBackground         = Neutral95,
    surface              = Neutral0,
    onSurface            = Neutral95,
    surfaceVariant       = Neutral20,
    onSurfaceVariant     = Neutral80,
    outline              = Neutral60,
    outlineVariant       = Neutral30,
    scrim                = Scrim,
    inverseSurface       = Neutral95,
    inverseOnSurface     = Neutral10,
    inversePrimary       = Blue200Dark,
    surfaceTint          = Blue500,
)

val MconAgnumDarkColorScheme = darkColorScheme(
    primary              = Blue200Dark,
    onPrimary            = Blue800Dark,
    primaryContainer     = Blue800Dark,
    onPrimaryContainer   = Blue50,
    secondary            = Teal200Dark,
    onSecondary          = Teal700,
    secondaryContainer   = Teal700,
    onSecondaryContainer = Teal50,
    error                = Red200,
    onError              = Red900,
    errorContainer       = Color(0xFF690005),
    onErrorContainer     = Red100,
    background           = Neutral99,
    onBackground         = Neutral100,
    surface              = Neutral99,
    onSurface            = Neutral100,
    surfaceVariant       = Neutral80,
    onSurfaceVariant     = Neutral30,
    outline              = Neutral50,
    outlineVariant       = Neutral80,
    scrim                = Scrim,
    inverseSurface       = Neutral100,
    inverseOnSurface     = Neutral95,
    inversePrimary       = Blue500,
    surfaceTint          = Blue200Dark,
)
