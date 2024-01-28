package com.example.take_home_apt.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.take_home_apt.R
import com.example.take_home_apt.presentation.components.ToolBarComponent
import com.example.take_home_apt.utils.Dimens.IconSizeMedium
import com.example.take_home_apt.utils.Dimens.SmallPadding
import com.example.take_home_apt.utils.Dimens.SmallPadding1

@Composable
fun CalculateScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ToolBarComponent(
            title = "Calculate",
            onClick = {}
        )
        Column(
            modifier = modifier.padding(SmallPadding1)
        ) {
            DestinationSection()
            Spacer(modifier = Modifier.height(SmallPadding1))
            PackagingSection()
        }
    }
}

@Composable
fun DestinationSection(modifier: Modifier = Modifier) {

    var text by remember { mutableStateOf("") }

    Text(
        text = "Destination",
        style = MaterialTheme.typography.titleMedium,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(vertical = SmallPadding1)
    )

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = modifier.padding(SmallPadding)
        ) {
            TextFieldWithIconAndDivider(
                hintText = "Sender location",
                icon = R.drawable.grey_send,
                onValueChange = {
                    text = it
                },
            )
            Spacer(modifier = Modifier.height(SmallPadding))

            TextFieldWithIconAndDivider(
                hintText = "Receiver location",
                icon = R.drawable.grey_receive,
                onValueChange = {
                    text = it
                },
            )
            Spacer(modifier = Modifier.height(SmallPadding))

            TextFieldWithIconAndDivider(
                hintText = "Approx weight",
                icon = R.drawable.hourglass,
                onValueChange = {
                    text = it
                },
                text = text
            )
        }
    }
}

@Composable
fun PackagingSection(modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableStateOf("Item 1") }
    var items by remember {
        mutableStateOf(listOf("Item 1", "Item 2", "Item 3"),)
    }

    Column {
        Text(
            text = "Packaging",
            style = MaterialTheme.typography.titleMedium,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "What are you sending?",
            style = MaterialTheme.typography.titleMedium,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
        )

        Card(
            modifier = modifier,
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = modifier.padding(SmallPadding)
            ) {
                SpinnerField(
                    hintText = "Select an item",
                    items = items,
                    selectedItem = selectedItem,
                    onItemSelected = {
                        selectedItem = it
                    }
                )
            }
        }
    }
}

@Composable
fun CategoriesSection(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Packaging",
            style = MaterialTheme.typography.titleMedium,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "What are you sending?",
            style = MaterialTheme.typography.titleMedium,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
        )

    }
}

@Composable
@Preview(showBackground = true)
fun CalculateScreenPreview() {
    Column(
    ) {
        CalculateScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithIconAndDivider(
    modifier: Modifier = Modifier,
    icon: Int,
    hintText: String = "",
    text: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Center
        ) {
            // Icon on the far left
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(IconSizeMedium)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Divider(
                color = Color.LightGray,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            BasicTextField(
                value = text.ifEmpty { hintText },
                onValueChange = {
                    text = it
                    onValueChange(it)
                },
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    color = if (text.isEmpty()) Color.Gray else Color.Black,
                    fontFamily = FontFamily.SansSerif
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = keyboardType
                ),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                singleLine = true,
            )
        }
    }
}


@Composable
fun SpinnerField(
    modifier: Modifier = Modifier,
    hintText: String,
    items: List<String>,
    selectedItem: String,
    onItemSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colorScheme.surface) // Set gray background for the spinner field
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon on the far left

            Image(
                painter = painterResource(id = R.drawable.grey_box),
                contentDescription = null,
                modifier = Modifier.size(IconSizeMedium)
            )

            // Spacer to separate icon and divider
            Spacer(modifier = Modifier.width(16.dp))

            // Vertical Divider
            Divider(
                color = Color.LightGray,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )

            // Spacer to separate divider and text input
            Spacer(modifier = Modifier.width(16.dp))

            // Text input (read-only)
            BasicTextField(
                value = selectedItem,
                onValueChange = {},
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                readOnly = true,
                modifier = Modifier
                    .weight(1f) // Takes up remaining space
                    .fillMaxHeight()
                    .clickable {
                        expanded = true
                    }
            )

            // Dropdown Icon
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = stringResource(id = R.string.cd_dropdown_icon),
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(IconSizeMedium)
            )
        }

        // Dropdown Menu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = item,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(SmallPadding)
                        )
                    },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
}
