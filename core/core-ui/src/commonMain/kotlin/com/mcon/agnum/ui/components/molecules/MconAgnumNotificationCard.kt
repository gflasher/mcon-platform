package com.mcon.agnum.ui.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mcon.agnum.ui.components.atoms.MconAgnumBadge
import com.mcon.agnum.ui.components.atoms.MconAgnumIcon
import com.mcon.agnum.ui.components.atoms.MconAgnumIconSize
import com.mcon.agnum.ui.components.atoms.MconAgnumLabelText
import com.mcon.agnum.ui.components.atoms.MconAgnumText

/**
 * Mcon.Agnum 알림 카드 컴포넌트 (Molecule)
 *
 * 알림 목록에서 개별 알림 항목을 표시합니다.
 *
 * @param title 알림 제목
 * @param body 알림 본문 내용
 * @param timestamp 알림 수신 시각 (표시용 문자열)
 * @param appIcon 앱 아이콘 (null이면 기본 아이콘 표시)
 * @param isRead 읽음 여부 (false면 미읽음 배지 표시)
 * @param onClick 카드 클릭 콜백
 * @param modifier Modifier
 */
@Composable
fun MconAgnumNotificationCard(
    title: String,
    body: String,
    timestamp: String,
    appIcon: ImageVector? = null,
    isRead: Boolean = false,
    onClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    val containerColor = if (isRead) {
        MaterialTheme.colorScheme.surface
    } else {
        MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.12f)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .then(if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isRead) 0.dp else 2.dp),
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.Top,
        ) {
            // 앱 아이콘 영역
            Box(
                modifier = Modifier
                    .size(MconAgnumIconSize.XLarge)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center,
            ) {
                if (appIcon != null) {
                    MconAgnumIcon(
                        imageVector = appIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSecondaryContainer,
                        size = MconAgnumIconSize.Medium,
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            // 콘텐츠 영역
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    MconAgnumText(
                        text = title,
                        style = MaterialTheme.typography.titleSmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f),
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    MconAgnumLabelText(
                        text = timestamp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }

                MconAgnumText(
                    text = body,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 2.dp),
                )
            }

            // 미읽음 배지
            if (!isRead) {
                Spacer(modifier = Modifier.width(8.dp))
                MconAgnumBadge(
                    count = null,
                    containerColor = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.align(Alignment.CenterVertically),
                )
            }
        }
    }
}
