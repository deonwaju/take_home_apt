package com.example.take_home_apt.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.take_home_apt.utils.Dimens.ExtraSmallPadding
import com.example.take_home_apt.utils.Dimens.SmallPadding

private val categories = listOf(
    "Documents", "Glass", "Liquid", "Food", "Electronic", "Product", "Others"
)

@Composable
fun SelectableButtons() {
    var selectedCategories by remember { mutableStateOf(emptySet<String>()) }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 100.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = SmallPadding)
            .background(Color.White),
    ) {
        items(categories) { category ->
            SelectableButton(category, selectedCategories) {
                selectedCategories = selectedCategories.toggle(category)
            }
        }
    }
}

@Composable
fun SelectableButton(
    categoryName: String,
    selectedCategories: Set<String>,
    modifier: Modifier = Modifier,
    onCategorySelected: (String) -> Unit
) {
    val isSelected = categoryName in selectedCategories

    Column(
        modifier = modifier
            .padding(SmallPadding)
            .wrapContentWidth()
    ) {
        Row(
            modifier = Modifier
                .clip(MaterialTheme.shapes.small)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onSurface,
                    shape = MaterialTheme.shapes.small
                )
                .background(
                    if (isSelected) {
                        Color.DarkGray
                    } else {
                        Color.Transparent
                    }
                )
                .clickable {
                    onCategorySelected(categoryName)
                }
                .padding(SmallPadding)
                .fillMaxWidth()
                .wrapContentHeight(Alignment.CenterVertically),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Center// Expand horizontally
        ) {
            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(SmallPadding)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding))
            }
            Text(
                text = categoryName,
                color = if (isSelected) {
                    Color.White
                } else {
                    Color.DarkGray
                },
                style = MaterialTheme.typography.bodyMedium,
                fontFamily = FontFamily.SansSerif,
                modifier = modifier
            )
        }
    }
}


private fun Set<String>.toggle(element: String): Set<String> {
    return if (element in this) {
        this - element
    } else {
        this + element
    }
}

@Composable
@Preview(showBackground = true)
fun SelectableButtonsDemoPreview() {
    SelectableButtons()
}
