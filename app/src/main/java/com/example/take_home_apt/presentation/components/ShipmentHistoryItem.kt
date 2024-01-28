package com.example.take_home_apt.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.take_home_apt.R
import com.example.take_home_apt.utils.Dimens
import com.example.take_home_apt.utils.Dimens.ExtraSmallPadding2
import com.example.take_home_apt.utils.Dimens.IconSize
import com.example.take_home_apt.utils.Dimens.SmallPadding

@Composable
fun ShipmentHistoryItem(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier.fillMaxWidth()
    ) {

        Column(
            modifier = modifier.weight(1f)
        ) {

            ShippingStatusComponent(
                text = "pending",
                iconRes = R.drawable.ic_loading
            )
            Text(
                text = "Arriving today",
                modifier = Modifier
                    .wrapContentWidth(),
                fontFamily = FontFamily.SansSerif,
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
            Text(
                text = "Your delivery, #NEJ20089934122231 from Atlanta, Is arriving today!",
                modifier = Modifier
                    .wrapContentWidth(),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                maxLines = 2
            )
        }
        Image(
            painter = painterResource(id = R.drawable.move_mate_box),
            contentDescription = "Truck",
            modifier = Modifier
                .size(Dimens.VehicleImageHeight)
        )
    }
}

@Composable
fun ShippingStatusComponent(
    modifier: Modifier = Modifier,
    text: String = "",
    iconRes: Int,
    backgroundColor: Color = Color.LightGray,
    shape: RoundedCornerShape = RoundedCornerShape(corner = CornerSize(16.dp)),
    iconResTint: Color = Color(0xFFFFA500),
    textColor: Color = Color(0xFFFFA500)
) {
    var textTitle by remember { mutableStateOf(text) }
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
                tint = iconResTint
            )

            Text(
                text = text,
                modifier = Modifier
                    .wrapContentWidth(),
                fontFamily = FontFamily.SansSerif,
                style = MaterialTheme.typography.bodyMedium,
                color = textColor
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewShipmentHistoryItem() {
    ShipmentHistoryItem()
}
