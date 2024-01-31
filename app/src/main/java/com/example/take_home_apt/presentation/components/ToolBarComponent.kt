package com.example.take_home_apt.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.take_home_apt.R
import com.example.take_home_apt.utils.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBarComponent(
    title: String = "Hello",
    onClick: (() -> Unit)? = null,
) {
    val titleText by remember {
        mutableStateOf(title)
    }
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = titleText,
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                modifier = Modifier
                    .size(Dimens.IconSizeMedium2)
                    .clip(MaterialTheme.shapes.medium)
                    .clickable {
                        onClick?.invoke()
                    },
                tint = Color.White,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.purple_500)
        ),
    )
}