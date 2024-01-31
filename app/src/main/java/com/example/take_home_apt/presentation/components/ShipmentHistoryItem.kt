package com.example.take_home_apt.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.take_home_apt.R
import com.example.take_home_apt.data.models.ShipmentHistory
import com.example.take_home_apt.utils.Dimens
import com.example.take_home_apt.utils.Dimens.ExtraSmallPadding
import com.example.take_home_apt.utils.Dimens.ExtraSmallPadding2
import com.example.take_home_apt.utils.Dimens.IconSize
import com.example.take_home_apt.utils.Dimens.IconSizeLarge
import com.example.take_home_apt.utils.Dimens.SmallPadding

@Composable
fun ShipmentHistoryItem(
    modifier: Modifier = Modifier,
    shipmentHistory: ShipmentHistory = ShipmentHistory(
        "In progress",
        "$1400 USD",
        "Sep 20, 2024",
        R.drawable.ic_loading,
        R.color.orange,
        R.color.orange
    )
) {
    var textTitle by remember { mutableStateOf(shipmentHistory.status) }
    var textColor by remember { mutableIntStateOf(shipmentHistory.statusColor) }
    var priceText by remember { mutableStateOf(shipmentHistory.price) }
    var dateText by remember { mutableStateOf(shipmentHistory.date) }
    var icon by remember { mutableIntStateOf(shipmentHistory.icon) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Dimens.SmallPadding1),
        elevation = CardDefaults.cardElevation(Dimens.ExtraSmallPadding),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(Dimens.SmallPadding1),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Column(
                modifier = modifier.weight(1f)
            ) {

                ShippingStatusComponent(
                    text = textTitle,
                    iconRes = icon,
                    textColor = textColor,
                )
                Spacer(modifier = Modifier.height(Dimens.ExtraSmallPadding2))
                Text(
                    text = stringResource(R.string.arriving_today),
                    modifier = Modifier
                        .wrapContentWidth(),
                    fontFamily = FontFamily.SansSerif,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(ExtraSmallPadding2))
                Text(
                    text = stringResource(R.string.your_delivery_nej20089934122231_from_atlanta_is_arriving_today),
                    modifier = Modifier
                        .wrapContentWidth(),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.DarkGray,
                    maxLines = 2
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = priceText,
                        modifier = Modifier
                            .wrapContentWidth(),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodySmall,
                        color = colorResource(id = R.color.purple_500)
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_dot),
                        contentDescription = null,
                        modifier = Modifier
                            .size(IconSizeLarge)
                            .padding(horizontal = ExtraSmallPadding),
                        tint = Color.Gray
                    )
                    Text(
                        text = dateText,
                        modifier = Modifier
                            .wrapContentWidth(),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.move_mate_box),
                contentDescription = stringResource(R.string.truck),
                modifier = Modifier
                    .size(Dimens.VehicleCardSize),
            )
        }
    }
}

@Composable
fun ShippingStatusComponent(
    modifier: Modifier = Modifier,
    text: String = "",
    iconRes: Int,
    backgroundColor: Color = MaterialTheme.colorScheme.inverseOnSurface,
    shape: RoundedCornerShape = RoundedCornerShape(corner = CornerSize(16.dp)),
    textColor: Int =  R.color.orange
) {
    var textTitle by remember { mutableStateOf(text) }
    var textTitleColor by remember { mutableIntStateOf(textColor) }
    var icon by remember { mutableIntStateOf(iconRes) }

    Box(
        modifier = modifier
            .background(color = backgroundColor, shape = shape)
    ) {
        Row(
            modifier = Modifier
                .padding(ExtraSmallPadding2)
                .border(
                    width = 1.dp,
                    color = Color.Transparent,
                    shape = MaterialTheme.shapes.extraLarge
                )
                .wrapContentWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(IconSize)
                    .padding(end = SmallPadding),
                tint = colorResource(id = textTitleColor)
            )

            Text(
                text = textTitle,
                modifier = Modifier
                    .wrapContentWidth(),
                fontFamily = FontFamily.SansSerif,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = textTitleColor)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewShipmentHistoryItem() {
    ShipmentHistoryItem(

    )
}
