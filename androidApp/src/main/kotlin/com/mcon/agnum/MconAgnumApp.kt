package com.mcon.agnum

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mcon.agnum.feature.dotbomi.DotBomiScreen
import com.mcon.agnum.feature.dotbomi.DotBomiViewModel
import com.mcon.agnum.feature.readalert.ReadAlertScreen
import com.mcon.agnum.feature.readalert.ReadAlertViewModel
import com.mcon.agnum.feature.settings.SettingsScreen
import com.mcon.agnum.feature.settings.SettingsViewModel
import com.mcon.agnum.ui.theme.MconAgnumTheme
import kotlinx.coroutines.launch

private enum class AppDestination(
    val label: String,
    val icon: ImageVector,
) {
    ReadAlert("알림 읽기", Icons.Default.Notifications),
    DotBomi("닷보미", Icons.Default.Home),
    Settings("설정", Icons.Default.Settings),
}

@Composable
fun MconAgnumApp() {
    MconAgnumTheme {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        var selectedDestination by remember { mutableStateOf(AppDestination.ReadAlert) }

        val configuration = LocalConfiguration.current
        val isTablet = configuration.screenWidthDp >= 600

        val drawerItems: @Composable () -> Unit = {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Mcon Agnum",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
            )
            Spacer(modifier = Modifier.height(8.dp))
            AppDestination.entries.forEach { destination ->
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            imageVector = destination.icon,
                            contentDescription = destination.label,
                        )
                    },
                    label = { Text(destination.label) },
                    selected = selectedDestination == destination,
                    onClick = {
                        selectedDestination = destination
                        if (!isTablet) scope.launch { drawerState.close() }
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                )
            }
        }

        val screenContent: @Composable (onMenuClick: () -> Unit) -> Unit = { onMenuClick ->
            when (selectedDestination) {
                AppDestination.ReadAlert -> ReadAlertScreen(
                    viewModel = viewModel<ReadAlertViewModel>(),
                    onMenuClick = onMenuClick,
                )
                AppDestination.DotBomi -> DotBomiScreen(
                    viewModel = viewModel<DotBomiViewModel>(),
                    onMenuClick = onMenuClick,
                )
                AppDestination.Settings -> SettingsScreen(
                    viewModel = viewModel<SettingsViewModel>(),
                    onMenuClick = onMenuClick,
                )
            }
        }

        if (isTablet) {
            PermanentNavigationDrawer(
                drawerContent = {
                    PermanentDrawerSheet {
                        drawerItems()
                    }
                },
            ) {
                screenContent {}
            }
        } else {
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    ModalDrawerSheet {
                        drawerItems()
                    }
                },
                gesturesEnabled = true,
            ) {
                screenContent { scope.launch { drawerState.open() } }
            }
        }
    }
}
