package com.mcon.agnum.feature.settings

import androidx.lifecycle.viewModelScope
import com.mcon.agnum.ui.base.MconViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Settings 화면 ViewModel
 *
 * StateFlow<SettingsUiState>로 화면 상태를 관리합니다.
 */
class SettingsViewModel : MconViewModel() {

    private val _uiState = MutableStateFlow<SettingsUiState>(SettingsUiState.Loading)
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    init {
        loadSettings()
    }

    private fun loadSettings() {
        viewModelScope.launch {
            _uiState.value = SettingsUiState.Loading
            // TODO: DataStore 연동 시 실제 설정 로드로 교체
            _uiState.value = SettingsUiState.Success()
        }
    }

    fun toggleNotification(enabled: Boolean) {
        val current = _uiState.value as? SettingsUiState.Success ?: return
        _uiState.value = current.copy(notificationEnabled = enabled)
        // TODO: DataStore에 저장 구현
    }

    fun toggleDarkMode(enabled: Boolean) {
        val current = _uiState.value as? SettingsUiState.Success ?: return
        _uiState.value = current.copy(darkModeEnabled = enabled)
        // TODO: DataStore에 저장 구현
    }
}
