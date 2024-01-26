package com.example.take_home_apt.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.take_home_apt.utils.Dimens.MediumPadding1

@Composable
fun TrackingCard(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.padding(MediumPadding1)
    ) {
        Text(text = "Tracking")
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Shipment Number")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrackingCardPreview() {
    TrackingCard()
}