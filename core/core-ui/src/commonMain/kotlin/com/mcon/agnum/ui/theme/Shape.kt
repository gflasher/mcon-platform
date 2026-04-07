package com.mcon.agnum.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val MconAgnumShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),    // 칩, 태그
    small      = RoundedCornerShape(8.dp),    // 버튼, 입력 필드
    medium     = RoundedCornerShape(12.dp),   // 카드
    large      = RoundedCornerShape(16.dp),   // 바텀 시트 상단
    extraLarge = RoundedCornerShape(28.dp),   // FAB, 대형 버튼
)
