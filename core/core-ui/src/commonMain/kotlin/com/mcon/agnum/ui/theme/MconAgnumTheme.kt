package com.mcon.agnum.ui.theme

import androidx.compose.runtime.Composable

// TODO: [MCO-621] UXDesigner가 디자인 토큰 체계 구현 예정
// TODO: [MCO-625] CTO가 MconAgnumTheme Composable 완성 예정
@Composable
expect fun MconAgnumTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
)
