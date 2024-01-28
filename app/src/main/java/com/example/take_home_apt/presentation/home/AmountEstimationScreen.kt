package com.example.take_home_apt.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.take_home_apt.R
import com.example.take_home_apt.presentation.components.ContainedButtonComp
import com.example.take_home_apt.utils.Dimens.SmallPadding

@Composable
fun AmountEstimationScreen(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.movemate_logo_and_box),
            contentDescription = "Truck",
            modifier = Modifier
                .size(300.dp)
        )
        Text(
            text = "Total Estimated Amount",
            style = MaterialTheme.typography.titleLarge,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
        )
        Row {
            Text(
                text = "$1439",
                style = MaterialTheme.typography.titleLarge,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Light,
                color = Color.Green,
            )
            Text(
                text = "USD",
                style = MaterialTheme.typography.titleSmall,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Light,
                color = Color.Green,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp)
            )
        }
        Text(
            text = "This amount is estimated, this will vary if you change your location or weight",
            style = MaterialTheme.typography.bodyLarge,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(SmallPadding)
        )
        ContainedButtonComp(
            text = " to home",
            onClick = {
                onClick?.invoke()
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun AmountEstimationScreenPreview() {
    AmountEstimationScreen()
}
