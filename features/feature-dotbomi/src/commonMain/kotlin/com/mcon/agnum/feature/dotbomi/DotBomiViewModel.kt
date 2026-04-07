package com.mcon.agnum.feature.dotbomi

import androidx.lifecycle.viewModelScope
import com.mcon.agnum.ui.base.MconViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * DotBomi 화면 ViewModel
 *
 * StateFlow<DotBomiUiState>로 화면 상태를 관리합니다.
 */
class DotBomiViewModel : MconViewModel() {

    private val _uiState = MutableStateFlow<DotBomiUiState>(DotBomiUiState.Loading)
    val uiState: StateFlow<DotBomiUiState> = _uiState.asStateFlow()

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            _uiState.value = DotBomiUiState.Loading
            // TODO: Repository 연동 시 실제 데이터 로드로 교체
            _uiState.value = DotBomiUiState.Success(items = emptyList())
        }
    }

    fun refresh() {
        load()
    }
}
