package com.mcon.agnum.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

/**
 * Mcon.Agnum 공통 테마 Composable
 *
 * 모든 화면은 반드시 MconAgnumTheme{} 블록 안에서 렌더링되어야 합니다.
 *
 * @param darkTheme 다크 모드 강제 지정. 기본값: 시스템 설정 따름
 * @param content 테마가 적용될 컴포저블 콘텐츠
 */
@Composable
fun MconAgnumTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        MconAgnumDarkColorScheme
    } else {
        MconAgnumLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography  = MconAgnumTypography,
        shapes      = MconAgnumShapes,
        content     = content
    )
}

/** MconAgnumTheme 안에서 현재 테마의 간격 토큰 접근 */
val MaterialTheme.mconSpacing get() = MconAgnumSpacing
