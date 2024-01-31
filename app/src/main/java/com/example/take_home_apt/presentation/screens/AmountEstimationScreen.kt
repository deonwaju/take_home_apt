package com.example.take_home_apt.presentation.screens

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
import androidx.compose.ui.res.stringResource
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
            contentDescription = stringResource(id = R.string.truck),
            modifier = Modifier
                .size(300.dp)
        )
        Text(
            text = stringResource(R.string.total_estimated_amount),
            style = MaterialTheme.typography.titleLarge,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
        )
        Row {
            PumpRunningText()
            Text(
                text = stringResource(R.string.usd),
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
            text = stringResource(R.string.this_amount_is_estimated_this_will_vary_if_you_change_your_location_or_weight),
            style = MaterialTheme.typography.bodyLarge,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(SmallPadding)
        )
        ContainedButtonComp(
            text = "Back to home",
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
