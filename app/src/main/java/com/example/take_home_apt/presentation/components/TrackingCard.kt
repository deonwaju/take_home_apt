package com.example.take_home_apt.presentation.components

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.take_home_apt.R
import com.example.take_home_apt.utils.Dimens
import com.example.take_home_apt.utils.Dimens.ExtraSmallPadding
import com.example.take_home_apt.utils.Dimens.ExtraSmallPadding2
import com.example.take_home_apt.utils.Dimens.IconSizeMedium2
import com.example.take_home_apt.utils.Dimens.SmallPadding1

@Composable
fun TrackingCard(modifier: Modifier = Modifier) {

    Column {
        Text(
            text = "Tracking",
            style = MaterialTheme.typography.titleLarge,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )
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
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(
                        modifier = modifier.weight(1f)
                    ) {
                        Text(
                            text = "Shipment Number",
                            color = Color.Gray,
                            style = MaterialTheme.typography.titleMedium,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Light
                        )
                        Spacer(modifier = Modifier.height(ExtraSmallPadding2))
                        Text(
                            text = "NEJ20089934122231",
                            fontFamily = FontFamily.SansSerif,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.ic_move_truck),
                        contentDescription = "Truck",
                        modifier = Modifier
                            .size(Dimens.IconSizeLarge)
                            .clip(MaterialTheme.shapes.medium),
                    )
                }
                Spacer(modifier = Modifier.height(SmallPadding1))
                Divider(modifier = Modifier.padding(vertical = ExtraSmallPadding))
                Spacer(modifier = Modifier.height(SmallPadding1))
                TrackingCardItems()
                Divider(modifier = Modifier.padding(vertical = ExtraSmallPadding))
                Spacer(modifier = Modifier.height(SmallPadding1))
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = colorResource(id = R.color.orange) // Change the icon color
                    )
                    Text(
                        text = "Add Stop",
                        color = colorResource(id = R.color.orange),
                        style = MaterialTheme.typography.titleMedium,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold
                    )
                }
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

            Image(
                painter = painterResource(id = R.drawable.ic_send), // Replace with your SVG resource ID
                contentDescription = null,
                modifier = Modifier
                    .size(IconSizeMedium2)
                    .clip(CircleShape),
            )
            Column(
                modifier = modifier
                    .padding(SmallPadding1)
                    .weight(1f)
            ) {
                Text(
                    text = "Sender",
                    style = MaterialTheme.typography.labelMedium,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = "Atlanta, 5243",
                    style = MaterialTheme.typography.labelMedium,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = modifier.width(SmallPadding1))
            Column(
                modifier = modifier
                    .padding(ExtraSmallPadding)
                    .weight(1f)

            ) {
                Text(
                    text = "Time",
                    style = MaterialTheme.typography.labelMedium,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = "2 day - 3 days",
                    style = MaterialTheme.typography.labelMedium,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_receive), // Replace with your SVG resource ID
                contentDescription = null,
                modifier = Modifier
                    .size(IconSizeMedium2)
                    .clip(CircleShape),
            )
            Column(
                modifier = modifier
                    .padding(SmallPadding1)
                    .weight(1f)
            ) {
                Text(
                    text = "Receiver",
                    style = MaterialTheme.typography.labelMedium,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = "Chicago, 6342",
                    style = MaterialTheme.typography.labelMedium,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = modifier.width(SmallPadding1))
            Column(
                modifier = modifier
                    .padding(ExtraSmallPadding)
                    .weight(1f)
            ) {
                Text(
                    text = "Time",
                    style = MaterialTheme.typography.labelMedium,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = "Waiting to collect",
                    style = MaterialTheme.typography.labelMedium,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrackingCardPreview() {
    TrackingCard()
}