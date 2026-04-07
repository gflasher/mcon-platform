package com.mcon.agnum.feature.readalert

import androidx.lifecycle.viewModelScope
import com.mcon.agnum.ui.base.MconViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ReadAlert 화면 ViewModel
 *
 * StateFlow<ReadAlertUiState>로 화면 상태를 관리합니다.
 */
class ReadAlertViewModel : MconViewModel() {

    private val _uiState = MutableStateFlow<ReadAlertUiState>(ReadAlertUiState.Loading)
    val uiState: StateFlow<ReadAlertUiState> = _uiState.asStateFlow()

    init {
        loadNotifications()
    }

    private fun loadNotifications() {
        viewModelScope.launch {
            _uiState.value = ReadAlertUiState.Loading
            // TODO: Repository 연동 시 실제 데이터 로드로 교체
            _uiState.value = ReadAlertUiState.Success(
                notifications = emptyList(),
                unreadCount = 0,
            )
        }
    }

    fun markAsRead(notificationId: String) {
        val current = _uiState.value as? ReadAlertUiState.Success ?: return
        val updated = current.notifications.map { notification ->
            if (notification.id == notificationId) notification.copy(isRead = true)
            else notification
        }
        _uiState.value = current.copy(
            notifications = updated,
            unreadCount = updated.count { !it.isRead },
        )
    }

    fun refresh() {
        loadNotifications()
    }
}
