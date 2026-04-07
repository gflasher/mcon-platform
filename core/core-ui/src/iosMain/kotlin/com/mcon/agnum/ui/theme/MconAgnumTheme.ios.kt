package com.mcon.agnum.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

// TODO: [MCO-621] UXDesigner + [MCO-625] CTO가 디자인 토큰 기반 테마 구현 예정
@Composable
actual fun MconAgnumTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = content
    )
}
