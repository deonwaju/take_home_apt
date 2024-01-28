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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.take_home_apt.R
import com.example.take_home_apt.utils.Dimens
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
        }
        Image(
            painter = painterResource(id = R.drawable.move_mate_box),
            contentDescription = "Truck",
            modifier = Modifier
                .size(Dimens.IconSizeLarge)
        )
    }
}

@Composable
fun ShippingStatusComponent(
    modifier: Modifier = Modifier,
    text: String = "",
    iconRes: Int,
    backgroundColor: Color = Color.LightGray,
    shape: RoundedCornerShape = RoundedCornerShape(corner = CornerSize(16.dp))
) {
    var textTitle by remember { mutableStateOf(text) }
    var icon by remember { mutableIntStateOf(iconRes) }

    Box(
        modifier = modifier
            .background(color = backgroundColor, shape = shape)
    ) {
        Row(
            modifier = Modifier
                .padding(SmallPadding)
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
                tint =
            )

            Text(
                text = text,
                modifier = Modifier
                    .wrapContentWidth(),
                fontSize = 16.sp
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewShipmentHistoryItem() {
    ShipmentHistoryItem()
}
