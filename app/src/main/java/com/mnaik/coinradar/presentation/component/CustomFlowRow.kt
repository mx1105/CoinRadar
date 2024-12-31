package com.mnaik.coinradar.presentation.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.mnaik.coinradar.common.Constants

/**
 * Created by Monil Naik on 31-12-2024.
 */

@Composable
fun <T> CustomFlowRow(
    items: List<T>,
    maxVisibleItems: Int = Constants.TAG_MAX_ITEM,
    onItemClick: (T) -> Unit,
//    tagMapper: @Composable (T, (T) -> Unit) -> Unit,
    toggleTextProvider: (Boolean) -> String = { if (it) "View Less" else "View All" }
) {
    var showAllItems by remember { mutableStateOf(false) }

    val displayItems = if (showAllItems) items else items.take(maxVisibleItems)

    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(animationSpec = tween(durationMillis = Constants.TAG_ITEM_ANIMATION)),
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp
    ) {
        displayItems.forEach { item ->
            Tag(item, onItemClick) // Pass item and click listener to the mapper
        }

        if (items.size > maxVisibleItems) {
            Box(
                modifier = Modifier
                    .clickable { showAllItems = !showAllItems }
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.secondary,
                        shape = RoundedCornerShape(120.dp)
                    )
                    .padding(10.dp)
            ) {
                Text(
                    text = toggleTextProvider(showAllItems),
                    color = MaterialTheme.colorScheme.secondary,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}