package com.mcon.agnum.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.mcon.agnum.ui.components.atoms.MconAgnumIcon
import com.mcon.agnum.ui.components.atoms.MconAgnumIconSize
import com.mcon.agnum.ui.components.atoms.MconAgnumText
import com.mcon.agnum.ui.components.molecules.MconAgnumFilterChip

/**
 * 필터 옵션 데이터 모델
 *
 * @param key 고유 키
 * @param label 표시 라벨
 */
data class FilterOption(
    val key: String,
    val label: String,
)

/**
 * Mcon.Agnum 검색바 + 필터 행 컴포넌트 (Organism)
 *
 * 검색 입력 필드와 필터 칩 행을 조합한 복합 컴포넌트입니다.
 *
 * @param query 현재 검색어
 * @param onQueryChange 검색어 변경 콜백
 * @param filters 표시할 필터 옵션 목록
 * @param selectedFilterKeys 선택된 필터 키 집합
 * @param onFilterToggle 필터 토글 콜백 (키 전달)
 * @param placeholder 검색창 힌트 텍스트
 * @param onSearch 검색 실행 콜백 (IME 액션)
 * @param modifier Modifier
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MconAgnumSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    filters: List<FilterOption> = emptyList(),
    selectedFilterKeys: Set<String> = emptySet(),
    onFilterToggle: (String) -> Unit = {},
    placeholder: String = "검색",
    onSearch: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                MconAgnumText(
                    text = placeholder,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            },
            leadingIcon = {
                MconAgnumIcon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "검색",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    size = MconAgnumIconSize.Medium,
                )
            },
            trailingIcon = if (query.isNotEmpty()) {
                {
                    MconAgnumIcon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "검색어 초기화",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        size = MconAgnumIconSize.Medium,
                    )
                }
            } else null,
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { onSearch?.invoke() }),
        )

        if (filters.isNotEmpty()) {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                filters.forEach { filter ->
                    MconAgnumFilterChip(
                        label = filter.label,
                        selected = filter.key in selectedFilterKeys,
                        onToggle = { onFilterToggle(filter.key) },
                    )
                }
            }
        }
    }
}
