package com.mcon.agnum.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "MconAgnumTheme — Light Mode", showBackground = true)
@Composable
private fun MconAgnumThemeLightPreview() {
    MconAgnumTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colorScheme.background) {
            ThemePreviewContent()
        }
    }
}

@Preview(name = "MconAgnumTheme — Dark Mode", showBackground = true, backgroundColor = 0xFF121212)
@Composable
private fun MconAgnumThemeDarkPreview() {
    MconAgnumTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colorScheme.background) {
            ThemePreviewContent()
        }
    }
}

@Composable
private fun ThemePreviewContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MconAgnumSpacing.Spacing4),
        verticalArrangement = Arrangement.spacedBy(MconAgnumSpacing.Spacing2),
    ) {
        Text(
            text = "Mcon.Agnum Theme",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Text(
            text = "Body Medium — 알림 목록 본문 텍스트",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            text = "Label Small — 타임스탬프",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(MconAgnumSpacing.Spacing2),
        ) {
            Text(
                text = "Primary",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = MconAgnumShapes.small,
                    )
                    .padding(
                        horizontal = MconAgnumSpacing.Spacing3,
                        vertical = MconAgnumSpacing.Spacing1,
                    ),
            )
            Text(
                text = "Secondary",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.secondary,
                        shape = MconAgnumShapes.small,
                    )
                    .padding(
                        horizontal = MconAgnumSpacing.Spacing3,
                        vertical = MconAgnumSpacing.Spacing1,
                    ),
            )
            Text(
                text = "Error",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onError,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.error,
                        shape = MconAgnumShapes.small,
                    )
                    .padding(
                        horizontal = MconAgnumSpacing.Spacing3,
                        vertical = MconAgnumSpacing.Spacing1,
                    ),
            )
        }
    }
}
