package com.mcon.agnum.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * 컴포넌트별 디자인 토큰 — Alias Token을 컴포넌트 시맨틱으로 래핑
 * 컴포넌트 내부에서 MaterialTheme.colorScheme 대신 이 토큰을 사용
 */
object NotificationCardTokens {
    @Composable fun unreadBackground(): Color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.15f)
    @Composable fun readBackground(): Color = MaterialTheme.colorScheme.surface
    @Composable fun appNameStyle() = MaterialTheme.typography.titleMedium
    @Composable fun contentStyle() = MaterialTheme.typography.bodyMedium
    @Composable fun timestampStyle() = MaterialTheme.typography.bodySmall
    @Composable fun dividerColor(): Color = MaterialTheme.colorScheme.outlineVariant
    val horizontalPadding = MconAgnumSpacing.Spacing4   // 16dp
    val verticalPadding   = MconAgnumSpacing.Spacing3   // 12dp
    val appIconSize       = 40.dp
    val appIconCorner     = MconAgnumSpacing.Spacing2   // 8dp
    val contentSpacing    = MconAgnumSpacing.Spacing2   // 8dp
}

object TopBarTokens {
    @Composable fun containerColor(): Color = MaterialTheme.colorScheme.surface
    @Composable fun titleStyle() = MaterialTheme.typography.titleLarge
    @Composable fun iconTint(): Color = MaterialTheme.colorScheme.onSurface
    val height = 64.dp
}

object FilterChipTokens {
    @Composable fun selectedBackground(): Color = MaterialTheme.colorScheme.primaryContainer
    @Composable fun selectedContent(): Color = MaterialTheme.colorScheme.onPrimaryContainer
    @Composable fun unselectedBackground(): Color = MaterialTheme.colorScheme.surface
    @Composable fun borderColor(): Color = MaterialTheme.colorScheme.outline
    @Composable fun labelStyle() = MaterialTheme.typography.labelMedium
    val cornerRadius       = MconAgnumSpacing.Spacing2   // 8dp
    val horizontalPadding  = MconAgnumSpacing.Spacing3   // 12dp
    val verticalPadding    = MconAgnumSpacing.Spacing1   // 4dp
}

object BadgeTokens {
    @Composable fun background(): Color = MaterialTheme.colorScheme.error
    @Composable fun onBackground(): Color = MaterialTheme.colorScheme.onError
    @Composable fun labelStyle() = MaterialTheme.typography.labelSmall
    val size              = 16.dp
    val paddingHorizontal = MconAgnumSpacing.Spacing1    // 4dp
}
