package com.mcon.agnum.ui.components.atoms

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * 아이콘 크기 토큰 — 디자인 시스템 정의 크기
 */
object MconAgnumIconSize {
    val Small  = 16.dp  // 인라인 아이콘
    val Medium = 24.dp  // 기본 아이콘 (Material 기본값)
    val Large  = 32.dp  // 강조 아이콘
    val XLarge = 40.dp  // 앱 아이콘 / 썸네일
    val XXLarge = 48.dp // 대형 일러스트 아이콘
}

/**
 * Mcon.Agnum 공통 아이콘 컴포넌트 (Atom)
 *
 * 크기와 색상 토큰을 적용한 아이콘 래퍼입니다.
 * 모든 화면에서 일반 Icon() 대신 이 컴포넌트를 사용합니다.
 *
 * @param imageVector ImageVector 아이콘
 * @param contentDescription 접근성 설명 (null이면 장식용 아이콘)
 * @param modifier Modifier
 * @param tint 아이콘 색상 (기본: 현재 LocalContentColor)
 * @param size 아이콘 크기 (기본: MconAgnumIconSize.Medium = 24dp)
 */
@Composable
fun MconAgnumIcon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    size: Dp = MconAgnumIconSize.Medium,
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = modifier.size(size),
        tint = tint,
    )
}

/**
 * 주요 액션 아이콘 — onSurface 색상 적용
 */
@Composable
fun MconAgnumActionIcon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    size: Dp = MconAgnumIconSize.Medium,
) {
    MconAgnumIcon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = modifier,
        tint = MaterialTheme.colorScheme.onSurface,
        size = size,
    )
}

/**
 * Primary 색상 아이콘
 */
@Composable
fun MconAgnumPrimaryIcon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    size: Dp = MconAgnumIconSize.Medium,
) {
    MconAgnumIcon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = modifier,
        tint = MaterialTheme.colorScheme.primary,
        size = size,
    )
}
