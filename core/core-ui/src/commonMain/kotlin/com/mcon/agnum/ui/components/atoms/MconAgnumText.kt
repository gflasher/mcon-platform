package com.mcon.agnum.ui.components.atoms

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

/**
 * Mcon.Agnum 공통 텍스트 컴포넌트 (Atom)
 *
 * MconAgnumTheme의 타이포그래피 토큰을 적용합니다.
 * 모든 화면에서 일반 Text() 대신 이 컴포넌트를 사용해야 합니다.
 *
 * @param text 표시할 텍스트
 * @param modifier Modifier
 * @param style 타이포그래피 스타일 (기본: bodyMedium)
 * @param color 텍스트 색상 (기본: 테마 onBackground)
 * @param fontWeight 폰트 두께 재지정 (선택)
 * @param textAlign 텍스트 정렬 (선택)
 * @param overflow 오버플로우 처리 방식
 * @param maxLines 최대 줄 수
 */
@Composable
fun MconAgnumText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        modifier = modifier,
        style = if (fontWeight != null) style.copy(fontWeight = fontWeight) else style,
        color = color,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
    )
}

/**
 * 타이틀 텍스트 변형 — titleLarge 스타일 적용
 */
@Composable
fun MconAgnumTitleText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    maxLines: Int = 1,
) {
    MconAgnumText(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge,
        color = color,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines,
    )
}

/**
 * 본문 텍스트 변형 — bodyMedium 스타일 적용
 */
@Composable
fun MconAgnumBodyText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    maxLines: Int = Int.MAX_VALUE,
) {
    MconAgnumText(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium,
        color = color,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines,
    )
}

/**
 * 라벨 텍스트 변형 — labelSmall 스타일 적용
 */
@Composable
fun MconAgnumLabelText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurfaceVariant,
) {
    MconAgnumText(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.labelSmall,
        color = color,
    )
}
