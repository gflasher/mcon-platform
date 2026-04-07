package com.mcon.agnum.ui.components.atoms

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Mcon.Agnum 수평 구분선 컴포넌트 (Atom)
 *
 * 리스트 항목 사이, 섹션 사이 구분에 사용합니다.
 * 테마의 outlineVariant 색상을 기본값으로 사용합니다.
 *
 * @param modifier Modifier
 * @param thickness 두께 (기본: 1dp)
 * @param color 구분선 색상 (기본: outlineVariant)
 */
@Composable
fun MconAgnumDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = MaterialTheme.colorScheme.outlineVariant,
) {
    HorizontalDivider(
        modifier = modifier,
        thickness = thickness,
        color = color,
    )
}

/**
 * Mcon.Agnum 수직 구분선 컴포넌트 (Atom)
 *
 * 행(Row) 내부 아이템 사이 수직 구분에 사용합니다.
 *
 * @param modifier Modifier
 * @param thickness 두께 (기본: 1dp)
 * @param color 구분선 색상 (기본: outlineVariant)
 */
@Composable
fun MconAgnumVerticalDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = MaterialTheme.colorScheme.outlineVariant,
) {
    VerticalDivider(
        modifier = modifier,
        thickness = thickness,
        color = color,
    )
}

/**
 * 강조 구분선 — outline 색상 사용 (더 진한 구분)
 */
@Composable
fun MconAgnumStrongDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
) {
    MconAgnumDivider(
        modifier = modifier,
        thickness = thickness,
        color = MaterialTheme.colorScheme.outline,
    )
}
