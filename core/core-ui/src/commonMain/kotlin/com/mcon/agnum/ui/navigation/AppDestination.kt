package com.mcon.agnum.ui.navigation

/**
 * Mcon.Agnum 앱 내비게이션 목적지 정의
 *
 * sealed interface로 타입 안전한 화면 목적지를 정의합니다.
 * 각 구현체는 route 문자열을 제공해야 합니다.
 */
sealed interface AppDestination {
    val route: String

    /**
     * 알림 읽기 화면
     */
    data object ReadAlert : AppDestination {
        override val route: String = "read_alert"
    }

    /**
     * 닷보미(DotBomi) 화면
     */
    data object DotBomi : AppDestination {
        override val route: String = "dot_bomi"
    }

    /**
     * 설정 화면
     */
    data object Settings : AppDestination {
        override val route: String = "settings"
    }

    companion object {
        /** 시작 화면 */
        val Start: AppDestination = ReadAlert
    }
}
