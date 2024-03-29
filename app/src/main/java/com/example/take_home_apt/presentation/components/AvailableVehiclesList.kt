package com.example.take_home_apt.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.take_home_apt.R
import com.example.take_home_apt.data.models.AvailableVehicle
import com.example.take_home_apt.data.models.availableVehicles
import com.example.take_home_apt.utils.Dimens
import com.example.take_home_apt.utils.Dimens.ExtraSmallPadding
import com.example.take_home_apt.utils.Dimens.VehicleImageHeight


@Composable
fun AvailableVehiclesList(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier.padding(horizontal = Dimens.SmallPadding1)
    ) {
        items(availableVehicles.size) { i ->
            val vehicles = availableVehicles[i]
            AvailableVehiclesItem(vehicle = vehicles)
        }
    }
}

@Composable
fun AvailableVehiclesItem(modifier: Modifier = Modifier, vehicle: AvailableVehicle) {
    val imagePainter: Painter = painterResource(id = vehicle.image)

    Card(
        modifier = Modifier
            .padding(end = Dimens.SmallPadding1)
            .height(VehicleImageHeight),
        elevation = CardDefaults.cardElevation(ExtraSmallPadding),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = modifier
        ) {
            Text(
                text = vehicle.name,
                style = MaterialTheme.typography.labelSmall,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                modifier = modifier
                    .padding(ExtraSmallPadding)
            )
            Text(
                text = vehicle.mode,
                style = MaterialTheme.typography.labelSmall,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraLight,
                modifier = modifier
                    .padding(start = ExtraSmallPadding)
            )
        }
        Image(
            painter = imagePainter,
            contentDescription = stringResource(R.string.mode),
            modifier = Modifier
                .size(Dimens.VehicleCardSize)
                .clip(MaterialTheme.shapes.medium),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AvailableVehiclesItemPreview() {
    AvailableVehiclesList()
}
