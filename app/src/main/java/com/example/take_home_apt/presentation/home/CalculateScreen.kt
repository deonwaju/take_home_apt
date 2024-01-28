package com.example.take_home_apt.presentation.home

import androidx.compose.foundation.background
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.take_home_apt.R
import com.example.take_home_apt.presentation.components.ToolBarComponent
import com.example.take_home_apt.utils.Dimens
import com.example.take_home_apt.utils.Dimens.SmallPadding
import com.example.take_home_apt.utils.Dimens.SmallPadding1

@Composable
fun CalculateScreen(
    modifier: Modifier = Modifier,
    name: String = "CalculateScreen"
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ToolBarComponent(
            title = "Calculate",
            onClick = {}
        )
        DestinationSection()
    }
}

@Composable
fun DestinationSection(modifier: Modifier = Modifier) {

    var text by remember { mutableStateOf("") }

    Card(
        modifier = modifier
            .padding(SmallPadding1),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = modifier.padding(SmallPadding)
        ) {
            TextFieldWithIconAndDivider(
                hintText = "Sender location",
                icon = R.drawable.ic_calculate,
                onValueChange = {
                    text = it
                },
            )
            Spacer(modifier = Modifier.height(Dimens.SmallPadding))

            TextFieldWithIconAndDivider(
                hintText = "Receiver location",
                icon = R.drawable.ic_calculate,
                onValueChange = {
                    text = it
                },
            )
            Spacer(modifier = Modifier.height(Dimens.SmallPadding))

            TextFieldWithIconAndDivider(
                hintText = "Approx weight",
                icon = R.drawable.ic_calculate,
                onValueChange = {
                    text = it
                },
                text = text
            )
        }
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
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Divider(
                color = Color.Gray,
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
                    color = if(text.isEmpty()) Color.Gray else Color.Black,
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
