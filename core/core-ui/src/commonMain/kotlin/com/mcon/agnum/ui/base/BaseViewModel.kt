package com.mcon.agnum.ui.base

import androidx.lifecycle.ViewModel

/**
 * Mcon.Agnum 공통 ViewModel 베이스 클래스 (KMP)
 *
 * KMP commonMain에서 사용 가능한 ViewModel 추상화입니다.
 * androidx.lifecycle:lifecycle-viewmodel KMP 아티팩트를 사용합니다.
 *
 * 모든 Feature ViewModel은 이 클래스를 상속받아야 합니다.
 */
abstract class MconViewModel : ViewModel()
