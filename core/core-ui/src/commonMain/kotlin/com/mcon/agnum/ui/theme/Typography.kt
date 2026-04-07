package com.mcon.agnum.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Noto Sans KR 폰트 패밀리
// KMP에서 폰트 로딩은 플랫폼별 expect/actual 처리 필요 (Phase 2에서 구현)
// 현재는 기본 시스템 폰트 사용 (한국어 지원)
val MconAgnumFontFamily = FontFamily.Default

val MconAgnumTypography = Typography(
    displayLarge   = TextStyle(fontFamily = MconAgnumFontFamily, fontWeight = FontWeight.Normal,  fontSize = 57.sp, lineHeight = 64.sp, letterSpacing = (-0.25).sp),
    displayMedium  = TextStyle(fontFamily = MconAgnumFontFamily, fontWeight = FontWeight.Normal,  fontSize = 45.sp, lineHeight = 52.sp, letterSpacing = 0.sp),
    displaySmall   = TextStyle(fontFamily = MconAgnumFontFamily, fontWeight = FontWeight.Normal,  fontSize = 36.sp, lineHeight = 44.sp, letterSpacing = 0.sp),
    headlineLarge  = TextStyle(fontFamily = MconAgnumFontFamily, fontWeight = FontWeight.Normal,  fontSize = 32.sp, lineHeight = 40.sp, letterSpacing = 0.sp),
    headlineMedium = TextStyle(fontFamily = MconAgnumFontFamily, fontWeight = FontWeight.Normal,  fontSize = 28.sp, lineHeight = 36.sp, letterSpacing = 0.sp),
    headlineSmall  = TextStyle(fontFamily = MconAgnumFontFamily, fontWeight = FontWeight.Normal,  fontSize = 24.sp, lineHeight = 32.sp, letterSpacing = 0.sp),
    titleLarge     = TextStyle(fontFamily = MconAgnumFontFamily, fontWeight = FontWeight.Medium,  fontSize = 22.sp, lineHeight = 28.sp, letterSpacing = 0.sp),
    titleMedium    = TextStyle(fontFamily = MconAgnumFontFamily, fontWeight = FontWeight.Medium,  fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.15.sp),
    titleSmall     = TextStyle(fontFamily = MconAgnumFontFamily, fontWeight = FontWeight.Medium,  fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.1.sp),
    bodyLarge      = TextStyle(fontFamily = MconAgnumFontFamily, fontWeight = FontWeight.Normal,  fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.5.sp),
    bodyMedium     = TextStyle(fontFamily = MconAgnumFontFamily, fontWeight = FontWeight.Normal,  fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.25.sp),
    bodySmall      = TextStyle(fontFamily = MconAgnumFontFamily, fontWeight = FontWeight.Normal,  fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.4.sp),
    labelLarge     = TextStyle(fontFamily = MconAgnumFontFamily, fontWeight = FontWeight.Medium,  fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.1.sp),
    labelMedium    = TextStyle(fontFamily = MconAgnumFontFamily, fontWeight = FontWeight.Medium,  fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.5.sp),
    labelSmall     = TextStyle(fontFamily = MconAgnumFontFamily, fontWeight = FontWeight.Medium,  fontSize = 11.sp, lineHeight = 16.sp, letterSpacing = 0.5.sp),
)
