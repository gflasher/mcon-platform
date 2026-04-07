package com.mcon.agnum.ui.components.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mcon.agnum.ui.components.atoms.MconAgnumIcon
import com.mcon.agnum.ui.components.atoms.MconAgnumIconSize
import com.mcon.agnum.ui.components.atoms.MconAgnumText

/**
 * Mcon.Agnum 리스트 아이템 컴포넌트 (Molecule)
 *
 * 목록에서 단일 항목을 표시합니다.
 *
 * @param title 메인 타이틀
 * @param subtitle 서브타이틀 (선택)
 * @param leadingIcon 앞쪽 아이콘 (선택)
 * @param trailing 뒤쪽 영역에 표시할 컴포저블 (선택)
 * @param onClick 아이템 클릭 콜백 (선택)
 * @param modifier Modifier
 */
@Composable
fun MconAgnumListItem(
    title: String,
    subtitle: String? = null,
    leadingIcon: ImageVector? = null,
    trailing: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .then(if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // 앞쪽 아이콘
        if (leadingIcon != null) {
            MconAgnumIcon(
                imageVector = leadingIcon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                size = MconAgnumIconSize.Medium,
            )
            Spacer(modifier = Modifier.width(16.dp))
        }

        // 텍스트 영역
        Column(modifier = Modifier.weight(1f)) {
            MconAgnumText(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            if (subtitle != null) {
                MconAgnumText(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 2.dp),
                )
            }
        }

        // 뒤쪽 영역
        if (trailing != null) {
            Spacer(modifier = Modifier.width(16.dp))
            Box(contentAlignment = Alignment.CenterEnd) {
                trailing()
            }
        }
    }
}
