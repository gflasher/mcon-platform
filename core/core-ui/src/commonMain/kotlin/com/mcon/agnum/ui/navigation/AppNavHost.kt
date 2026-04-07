package com.mcon.agnum.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 * Mcon.Agnum 앱 NavHost (Compose Multiplatform Navigation)
 *
 * 앱의 최상위 내비게이션 그래프를 정의합니다.
 * 각 화면 컴포저블은 feature 모듈에서 주입됩니다.
 *
 * @param modifier Modifier
 * @param navController NavHostController (기본: rememberNavController())
 * @param startDestination 시작 목적지 (기본: AppDestination.Start)
 * @param readAlertScreen ReadAlert 화면 컴포저블
 * @param dotBomiScreen DotBomi 화면 컴포저블
 * @param settingsScreen Settings 화면 컴포저블
 */
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: AppDestination = AppDestination.Start,
    readAlertScreen: @Composable () -> Unit = {},
    dotBomiScreen: @Composable () -> Unit = {},
    settingsScreen: @Composable () -> Unit = {},
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route,
        modifier = modifier,
    ) {
        composable(route = AppDestination.ReadAlert.route) {
            readAlertScreen()
        }
        composable(route = AppDestination.DotBomi.route) {
            dotBomiScreen()
        }
        composable(route = AppDestination.Settings.route) {
            settingsScreen()
        }
    }
}
