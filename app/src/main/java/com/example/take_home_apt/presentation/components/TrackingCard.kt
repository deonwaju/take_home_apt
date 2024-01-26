package com.example.take_home_apt.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.take_home_apt.utils.Dimens
import com.example.take_home_apt.utils.Dimens.ExtraSmallPadding
import com.example.take_home_apt.utils.Dimens.MediumPadding1
import com.example.take_home_apt.utils.Dimens.SmallPadding1

@Composable
fun TrackingCard(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.padding(MediumPadding1)
    ) {
        Text(text = "Tracking")
        Spacer(modifier = Modifier.height(SmallPadding1))
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = MaterialTheme.shapes.small
        ) {
            Column(
                modifier = Modifier.padding(SmallPadding1)
            ) {
                Text(text = "Shipment Number")
                Spacer(modifier = Modifier.height(SmallPadding1))
                Text(text = "Shipment Number")
                Spacer(modifier = Modifier.height(SmallPadding1))
                Divider(modifier = Modifier.padding(vertical = ExtraSmallPadding))
                Spacer(modifier = Modifier.height(SmallPadding1))
                TrackingCardItems()
            }
        }
    }
}

@Composable
fun TrackingCardItems(modifier: Modifier = Modifier) {
    Column {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ){
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Account Circle",
                modifier = Modifier
                    .size(Dimens.IconSizeMedium2)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )
            Column (
                modifier = Modifier
                    .padding(ExtraSmallPadding)
            ){
                Text(text = "Sender")
                Text(text = "Atlanta, 5243")
            }
            Spacer(modifier = Modifier.width(SmallPadding1))
            Column (
                modifier = Modifier.padding(ExtraSmallPadding)

            ){
                Text(text = "Time")
                Text(text = "2 day - 3 days")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrackingCardPreview() {
    TrackingCard()
}