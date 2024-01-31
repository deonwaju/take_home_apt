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
import androidx.compose.ui.res.stringResource
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

    Column (
        modifier = modifier.padding(SmallPadding1)
    ){
        Text(
            text = stringResource(R.string.tracking),
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
                            text = stringResource(R.string.shipment_number),
                            color = Color.Gray,
                            style = MaterialTheme.typography.titleMedium,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Light
                        )
                        Spacer(modifier = Modifier.height(ExtraSmallPadding2))
                        Text(
                            text = stringResource(R.string.nej20089934122231),
                            fontFamily = FontFamily.SansSerif,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.ic_moving_vehicle),
                        contentDescription = stringResource(id = R.string.truck),
                        modifier = Modifier
                            .size(Dimens.IconSizeLarge)
                            .clip(CircleShape),
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
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = colorResource(id = R.color.orange) // Change the icon color
                    )
                    Text(
                        text = stringResource(R.string.add_stop),
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
                painter = painterResource(id = R.drawable.ic_send_box), // Replace with your SVG resource ID
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
                    text = stringResource(R.string.sender),
                    style = MaterialTheme.typography.labelMedium,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = stringResource(R.string.atlanta_5243),
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
                    text = stringResource(id = R.string.time),
                    style = MaterialTheme.typography.labelMedium,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = stringResource(R.string._2_day_3_days),
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
                painter = painterResource(id = R.drawable.ic_receive_box), // Replace with your SVG resource ID
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
                    text = stringResource(R.string.receiver),
                    style = MaterialTheme.typography.labelMedium,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = stringResource(R.string.chicago_6342),
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
                    text = stringResource(R.string.time),
                    style = MaterialTheme.typography.labelMedium,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = stringResource(R.string.waiting_to_collect),
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