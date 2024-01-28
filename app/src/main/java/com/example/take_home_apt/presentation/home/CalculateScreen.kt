package com.example.take_home_apt.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.take_home_apt.utils.Dimens

@Composable
fun CalculateScreen(
    modifier: Modifier = Modifier,
    name: String = "CalculateScreen"
) {
    Column {
        AppBarScreen(onClick = {})
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarScreen(
    onClick: (() -> Unit)? = null,
) {
    CenterAlignedTopAppBar(
        title = {

            Text(
                text = "Calculate",
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
                tint = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
@Preview(showBackground = true)
fun CalculateScreenPreview() {
    Column(
    ) {
        CalculateScreen()
    }
}
