package com.mcon.agnum.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mcon.agnum.ui.theme.BadgeTokens

/**
 * Mcon.Agnum 배지 컴포넌트 (Atom)
 *
 * 알림 카운트 등을 표시하는 배지입니다.
 * BadgeTokens의 디자인 토큰을 사용합니다.
 *
 * @param count 표시할 숫자 (null이면 점(dot) 배지)
 * @param modifier Modifier
 * @param maxCount 최대 표시 숫자 (초과 시 "99+" 형태로 표시), 기본 99
 * @param containerColor 배지 배경 색상 (기본: error 색상)
 * @param contentColor 텍스트 색상 (기본: onError 색상)
 */
@Composable
fun MconAgnumBadge(
    count: Int?,
    modifier: Modifier = Modifier,
    maxCount: Int = 99,
    containerColor: Color = BadgeTokens.background(),
    contentColor: Color = BadgeTokens.onBackground(),
) {
    if (count != null && count <= 0) return

    val badgeText = when {
        count == null      -> null
        count > maxCount   -> "$maxCount+"
        else               -> count.toString()
    }

    if (badgeText == null) {
        // 점(dot) 배지 — count가 null일 때
        Box(
            modifier = modifier
                .defaultMinSize(minWidth = BadgeTokens.size, minHeight = BadgeTokens.size)
                .clip(CircleShape)
                .background(containerColor),
        )
    } else {
        // 숫자 배지
        Box(
            modifier = modifier
                .defaultMinSize(minWidth = BadgeTokens.size, minHeight = BadgeTokens.size)
                .clip(RoundedCornerShape(BadgeTokens.size / 2))
                .background(containerColor)
                .padding(horizontal = BadgeTokens.paddingHorizontal),
            contentAlignment = Alignment.Center,
        ) {
            MconAgnumText(
                text = badgeText,
                style = BadgeTokens.labelStyle(),
                color = contentColor,
            )
        }
    }
}

/**
 * 점(dot) 배지 — 간단한 알림 존재 표시
 */
@Composable
fun MconAgnumDotBadge(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.error,
) {
    Box(
        modifier = modifier
            .defaultMinSize(minWidth = 8.dp, minHeight = 8.dp)
            .clip(CircleShape)
            .background(color),
    )
}
