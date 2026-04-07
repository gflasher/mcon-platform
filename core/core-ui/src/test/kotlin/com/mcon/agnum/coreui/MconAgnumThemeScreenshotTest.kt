/**
 * MconAgnumTheme + Atom 컴포넌트 Screenshot 테스트 (Paparazzi)
 *
 * MCO-621 (MconAgnumTheme 구현 완료), MCO-625 (Atom 컴포넌트 구현 완료) 기반
 *
 * 실행 방법:
 *   ./gradlew :core:core-ui:recordPaparazziDebug   → 골든 이미지 생성
 *   ./gradlew :core:core-ui:verifyPaparazziDebug   → 골든 이미지와 비교
 */
package com.mcon.agnum.coreui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.mcon.agnum.ui.components.atoms.MconAgnumActionIcon
import com.mcon.agnum.ui.components.atoms.MconAgnumBadge
import com.mcon.agnum.ui.components.atoms.MconAgnumBodyText
import com.mcon.agnum.ui.components.atoms.MconAgnumDivider
import com.mcon.agnum.ui.components.atoms.MconAgnumDotBadge
import com.mcon.agnum.ui.components.atoms.MconAgnumLabelText
import com.mcon.agnum.ui.components.atoms.MconAgnumPrimaryIcon
import com.mcon.agnum.ui.components.atoms.MconAgnumStrongDivider
import com.mcon.agnum.ui.components.atoms.MconAgnumText
import com.mcon.agnum.ui.components.atoms.MconAgnumTitleText
import com.mcon.agnum.ui.components.atoms.MconAgnumVerticalDivider
import com.mcon.agnum.ui.theme.MconAgnumTheme
import org.junit.Rule
import org.junit.Test

// ──────────────────────────────────────────────────────────────────────────────
// 1. 테마 라이트/다크 모드 스크린샷 테스트
// ──────────────────────────────────────────────────────────────────────────────

class MconAgnumThemeScreenshotTest {

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig.PIXEL_6,
        theme = "android:Theme.Material3.DayNight",
    )

    @Test
    fun `MconAgnumTheme 라이트 모드 기본 배경 검증`() {
        paparazzi.snapshot {
            MconAgnumTheme(darkTheme = false) {
                Surface {
                    Column(modifier = Modifier.padding(16.dp)) {
                        MconAgnumTitleText(text = "Mcon.Agnum 라이트 테마")
                        Spacer(modifier = Modifier.height(8.dp))
                        MconAgnumBodyText(text = "Primary Color, Typography 확인")
                        Spacer(modifier = Modifier.height(4.dp))
                        MconAgnumLabelText(text = "labelSmall 스타일")
                    }
                }
            }
        }
    }

    @Test
    fun `MconAgnumTheme 다크 모드 기본 배경 검증`() {
        paparazzi.snapshot {
            MconAgnumTheme(darkTheme = true) {
                Surface {
                    Column(modifier = Modifier.padding(16.dp)) {
                        MconAgnumTitleText(text = "Mcon.Agnum 다크 테마")
                        Spacer(modifier = Modifier.height(8.dp))
                        MconAgnumBodyText(text = "Primary Color, Typography 확인")
                        Spacer(modifier = Modifier.height(4.dp))
                        MconAgnumLabelText(text = "labelSmall 스타일")
                    }
                }
            }
        }
    }
}

// ──────────────────────────────────────────────────────────────────────────────
// 2. Atom 컴포넌트 스크린샷 테스트
// ──────────────────────────────────────────────────────────────────────────────

class MconAgnumAtomScreenshotTest {

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig.PIXEL_6,
    )

    // MconAgnumText

    @Test
    fun `MconAgnumText 기본 bodyMedium 검증`() {
        paparazzi.snapshot {
            MconAgnumTheme(darkTheme = false) {
                Surface {
                    Column(modifier = Modifier.padding(16.dp)) {
                        MconAgnumText(text = "bodyMedium 기본 텍스트")
                        MconAgnumTitleText(text = "titleLarge 제목")
                        MconAgnumBodyText(text = "bodyMedium 본문")
                        MconAgnumLabelText(text = "labelSmall 라벨")
                    }
                }
            }
        }
    }

    // MconAgnumIcon

    @Test
    fun `MconAgnumIcon 24dp 기본 크기 검증`() {
        paparazzi.snapshot {
            MconAgnumTheme(darkTheme = false) {
                Surface {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        MconAgnumActionIcon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "홈 아이콘",
                        )
                        MconAgnumPrimaryIcon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "즐겨찾기 아이콘",
                        )
                        MconAgnumActionIcon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "알림 아이콘",
                            size = 32.dp,
                        )
                    }
                }
            }
        }
    }

    // MconAgnumBadge

    @Test
    fun `MconAgnumBadge 숫자 배지 검증`() {
        paparazzi.snapshot {
            MconAgnumTheme(darkTheme = false) {
                Surface {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        MconAgnumBadge(count = 1)
                        MconAgnumBadge(count = 5)
                        MconAgnumBadge(count = 99)
                        MconAgnumBadge(count = 100) // → "99+"
                        MconAgnumBadge(count = null) // → 점 배지
                        MconAgnumDotBadge()
                    }
                }
            }
        }
    }

    @Test
    fun `MconAgnumBadge 99 초과 처리 검증`() {
        paparazzi.snapshot {
            MconAgnumTheme(darkTheme = false) {
                Surface {
                    Row(modifier = Modifier.padding(16.dp)) {
                        MconAgnumBadge(count = 999) // → "99+"
                    }
                }
            }
        }
    }

    // MconAgnumDivider

    @Test
    fun `MconAgnumDivider 수평 수직 Strong 변형 검증`() {
        paparazzi.snapshot {
            MconAgnumTheme(darkTheme = false) {
                Surface {
                    Column(modifier = Modifier.padding(16.dp)) {
                        MconAgnumText(text = "섹션 1")
                        Spacer(modifier = Modifier.height(8.dp))
                        MconAgnumDivider(modifier = Modifier.fillMaxWidth())
                        Spacer(modifier = Modifier.height(8.dp))
                        MconAgnumText(text = "섹션 2")
                        Spacer(modifier = Modifier.height(8.dp))
                        MconAgnumStrongDivider(modifier = Modifier.fillMaxWidth())
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.height(40.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            MconAgnumText(text = "항목 A")
                            MconAgnumVerticalDivider()
                            MconAgnumText(text = "항목 B")
                            MconAgnumVerticalDivider()
                            MconAgnumText(text = "항목 C")
                        }
                    }
                }
            }
        }
    }
}
