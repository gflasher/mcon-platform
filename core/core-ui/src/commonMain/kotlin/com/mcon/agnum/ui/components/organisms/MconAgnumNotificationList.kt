package com.mcon.agnum.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.mcon.agnum.ui.components.atoms.MconAgnumText
import com.mcon.agnum.ui.components.molecules.MconAgnumNotificationCard

/**
 * 알림 아이템 데이터 모델
 *
 * @param id 고유 식별자
 * @param title 알림 제목
 * @param body 알림 본문
 * @param timestamp 표시용 시각 문자열
 * @param appIcon 앱 아이콘 (선택)
 * @param isRead 읽음 여부
 */
data class NotificationItem(
    val id: String,
    val title: String,
    val body: String,
    val timestamp: String,
    val appIcon: ImageVector? = null,
    val isRead: Boolean = false,
)

/**
 * Mcon.Agnum 알림 목록 컴포넌트 (Organism)
 *
 * LazyColumn 기반으로 MconAgnumNotificationCard 목록을 렌더링합니다.
 *
 * @param notifications 표시할 알림 목록
 * @param onNotificationClick 알림 클릭 콜백 (id 전달)
 * @param emptyContent 목록이 비었을 때 표시할 컴포저블 (기본 메시지 제공)
 * @param contentPadding LazyColumn 내부 패딩
 * @param modifier Modifier
 */
@Composable
fun MconAgnumNotificationList(
    notifications: List<NotificationItem>,
    onNotificationClick: (String) -> Unit = {},
    emptyContent: @Composable (() -> Unit)? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    modifier: Modifier = Modifier,
) {
    if (notifications.isEmpty()) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            if (emptyContent != null) {
                emptyContent()
            } else {
                MconAgnumText(
                    text = "알림이 없습니다",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
        return
    }

    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            items = notifications,
            key = { it.id },
        ) { item ->
            MconAgnumNotificationCard(
                title = item.title,
                body = item.body,
                timestamp = item.timestamp,
                appIcon = item.appIcon,
                isRead = item.isRead,
                onClick = { onNotificationClick(item.id) },
            )
        }
    }
}
