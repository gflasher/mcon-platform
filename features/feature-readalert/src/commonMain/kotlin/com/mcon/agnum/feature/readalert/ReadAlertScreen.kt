package com.mcon.agnum.feature.readalert

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mcon.agnum.ui.components.atoms.MconAgnumText
import com.mcon.agnum.ui.components.organisms.MconAgnumNotificationList
import com.mcon.agnum.ui.components.organisms.NotificationItem

/**
 * ReadAlert 화면
 *
 * 수신된 알림 목록을 표시하는 메인 화면입니다.
 *
 * @param viewModel ReadAlertViewModel
 * @param modifier Modifier
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReadAlertScreen(
    viewModel: ReadAlertViewModel,
    onMenuClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    MconAgnumText(
                        text = "알림 읽기",
                        style = MaterialTheme.typography.titleLarge,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onMenuClick) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "메뉴 열기",
                        )
                    }
                },
            )
        },
        modifier = modifier,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            when (val state = uiState) {
                is ReadAlertUiState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is ReadAlertUiState.Success -> {
                    MconAgnumNotificationList(
                        notifications = state.notifications.map { it.toNotificationItem() },
                        onNotificationClick = { id -> viewModel.markAsRead(id) },
                        modifier = Modifier.fillMaxWidth(),
                    )
                }

                is ReadAlertUiState.Error -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        MconAgnumText(
                            text = state.message,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.error,
                        )
                    }
                }
            }
        }
    }
}

private fun ReadAlertNotification.toNotificationItem() = NotificationItem(
    id = id,
    title = title,
    body = body,
    timestamp = postedAtMillis.toRelativeTimeString(),
    isRead = isRead,
)

private fun Long.toRelativeTimeString(): String {
    val now = System.currentTimeMillis()
    val diff = now - this
    return when {
        diff < 60_000L -> "방금"
        diff < 3_600_000L -> "${diff / 60_000}분 전"
        diff < 86_400_000L -> "${diff / 3_600_000}시간 전"
        else -> "${diff / 86_400_000}일 전"
    }
}
