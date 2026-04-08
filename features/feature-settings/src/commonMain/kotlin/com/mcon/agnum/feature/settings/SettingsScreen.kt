package com.mcon.agnum.feature.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mcon.agnum.ui.components.atoms.MconAgnumText
import com.mcon.agnum.ui.components.molecules.MconAgnumListItem

/**
 * Settings 화면
 *
 * 앱 설정을 표시하고 변경하는 화면입니다.
 *
 * @param viewModel SettingsViewModel
 * @param modifier Modifier
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    onMenuClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    MconAgnumText(
                        text = "설정",
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
        when (val state = uiState) {
            is SettingsUiState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator()
                }
            }

            is SettingsUiState.Success -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding),
                ) {
                    MconAgnumListItem(
                        title = "알림",
                        subtitle = "앱 알림 수신 여부",
                        leadingIcon = Icons.Default.Notifications,
                        trailing = {
                            Switch(
                                checked = state.notificationEnabled,
                                onCheckedChange = { viewModel.toggleNotification(it) },
                            )
                        },
                    )
                    HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))

                    MconAgnumListItem(
                        title = "다크 모드",
                        subtitle = "어두운 테마 사용",
                        leadingIcon = Icons.Default.DarkMode,
                        trailing = {
                            Switch(
                                checked = state.darkModeEnabled,
                                onCheckedChange = { viewModel.toggleDarkMode(it) },
                            )
                        },
                    )
                    HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))

                    if (state.appVersion.isNotEmpty()) {
                        MconAgnumListItem(
                            title = "앱 버전",
                            subtitle = state.appVersion,
                        )
                    }
                }
            }

            is SettingsUiState.Error -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
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
