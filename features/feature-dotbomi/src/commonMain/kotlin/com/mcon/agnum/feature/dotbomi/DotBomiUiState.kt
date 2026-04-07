package com.mcon.agnum.feature.dotbomi

/**
 * DotBomi 화면 UI 상태
 */
sealed class DotBomiUiState {
    data object Loading : DotBomiUiState()

    data class Success(
        val items: List<DotBomiItem> = emptyList(),
    ) : DotBomiUiState()

    data class Error(
        val message: String,
    ) : DotBomiUiState()
}

/**
 * DotBomi 아이템 데이터 (UI 레이어 모델)
 */
data class DotBomiItem(
    val id: String,
    val label: String,
    val description: String,
)
