package com.mcon.agnum.feature.readalert

/**
 * ReadAlert 화면 UI 상태
 */
sealed class ReadAlertUiState {
    data object Loading : ReadAlertUiState()

    data class Success(
        val notifications: List<ReadAlertNotification> = emptyList(),
        val unreadCount: Int = 0,
    ) : ReadAlertUiState()

    data class Error(
        val message: String,
    ) : ReadAlertUiState()
}

/**
 * 단일 알림 데이터 (UI 레이어 모델)
 */
data class ReadAlertNotification(
    val id: String,
    val packageName: String,
    val appLabel: String,
    val title: String,
    val body: String,
    val postedAtMillis: Long,
    val isRead: Boolean,
)
