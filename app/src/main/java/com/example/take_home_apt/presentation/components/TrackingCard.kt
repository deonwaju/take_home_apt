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
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
            elevation = CardDefaults.cardElevation(ExtraSmallPadding),
            shape = MaterialTheme.shapes.small,
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
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
                Divider(modifier = Modifier.padding(vertical = ExtraSmallPadding))
                Spacer(modifier = Modifier.height(SmallPadding1))
                Text(
                    text = "Add Stop",
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .wrapContentSize(Alignment.Center)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun TrackingCardItems(modifier: Modifier = Modifier) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Account Circle",
                modifier = modifier
                    .size(Dimens.IconSizeMedium2)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )
            Column(
                modifier = modifier
                    .padding(SmallPadding1)
                    .weight(1f)
            ) {
                Text(text = "Sender")
                Text(text = "Atlanta, 5243")
            }
            Spacer(modifier = modifier.width(SmallPadding1))
            Column(
                modifier = modifier.padding(ExtraSmallPadding)

            ) {
                Text(text = "Time")
                Text(text = "2 day - 3 days")
            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Account Circle",
                modifier = modifier
                    .size(Dimens.IconSizeMedium2)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )
            Column(
                modifier = modifier
                    .padding(SmallPadding1)
                    .weight(1f)
            ) {
                Text(text = "Sender")
                Text(text = "Atlanta, 5243")
            }
            Spacer(modifier = modifier.width(SmallPadding1))
            Column(
                modifier = modifier.padding(ExtraSmallPadding)

            ) {
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