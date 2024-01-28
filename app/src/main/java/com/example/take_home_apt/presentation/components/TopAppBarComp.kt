package com.example.take_home_apt.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.take_home_apt.R
import com.example.take_home_apt.utils.Dimens
import com.example.take_home_apt.utils.Dimens.ExtraSmallPadding
import com.example.take_home_apt.utils.Dimens.SmallPadding1

@Composable
fun TopAppBarComp(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    readOnly: Boolean = false
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        ProfileTab()
        SearcherBoxMe(
            readOnly = readOnly,
            onValueChanged = {},
            onClick = {
                onClick()
            }
        )
    }
}

@Composable
fun ProfileTab(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(SmallPadding1)
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        // Profile picture at the top left
        Image(
            painter = painterResource(R.drawable.profile_person_cropped),
            contentDescription = null,
            modifier = Modifier
                .size(Dimens.IconSizeMedium2)
                .clip(CircleShape)
        )

        // Text "your location" at the right of the profile picture
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(start = 8.dp),
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_location_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .size(Dimens.SmallIconSize)
                        .clip(MaterialTheme.shapes.medium)
                        .padding(end = ExtraSmallPadding),
                    tint = Color.White
                )

                Text(
                    text = "Your location",
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraLight,
                    color = Color.White
                )
            }
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Wertheimer, Illinois",
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier
                        .size(Dimens.SmallIconSize)
                        .clip(MaterialTheme.shapes.medium),
                    tint = Color.White
                )
            }
        }
        // Icon at far right
        Image(
            painter = painterResource(R.drawable.notification_bell_cropped),
            contentDescription = null,
            modifier = Modifier
                .size(Dimens.IconSizeMedium2)
                .clip(CircleShape)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearcherBoxMe(
    modifier: Modifier = Modifier,
    text: String = "",
    readOnly: Boolean = false,
    onValueChanged: (String) -> Unit,
    onClick: (() -> Unit)? = null,
) {
    var searchText by remember { mutableStateOf(text) }

    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isClicked = interactionSource.collectIsPressedAsState().value
    LaunchedEffect(key1 = isClicked) {
        if (isClicked) {
            onClick?.invoke()
        }
    }

    TextField(
        value = searchText,
        onValueChange = {
            onValueChanged.invoke(it)
        },
        readOnly = readOnly,
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.extraLarge,
            )
            .padding(SmallPadding1)
            .background(color = MaterialTheme.colorScheme.primary),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        placeholder = {
            Text(
                text = "Enter the receipt number...",
                style = MaterialTheme.typography.bodySmall,
                color = colorResource(id = R.color.placeholder)
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.size(Dimens.IconSizeMedium),
                tint = MaterialTheme.colorScheme.primary
            )
        },
        trailingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_scanner2), // Replace with your SVG resource ID
                contentDescription = null,
                modifier = Modifier
                    .size(Dimens.IconSizeMedium2)
                    .clip(CircleShape),
            )
        },
        shape = MaterialTheme.shapes.extraLarge,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = colorResource(id = R.color.input_background),
            focusedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
            cursorColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        singleLine = true,
        interactionSource = interactionSource
    )
}

@Composable
@Preview(showBackground = true)
fun TopAppBarCompScreenPreview() {
    TopAppBarComp(onClick = {})
}
