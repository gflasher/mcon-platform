package com.mcon.agnum.feature.settings

/**
 * Settings 화면 UI 상태
 */
sealed class SettingsUiState {
    data object Loading : SettingsUiState()

    data class Success(
        val notificationEnabled: Boolean = true,
        val darkModeEnabled: Boolean = false,
        val appVersion: String = "",
    ) : SettingsUiState()

    data class Error(
        val message: String,
    ) : SettingsUiState()
}
