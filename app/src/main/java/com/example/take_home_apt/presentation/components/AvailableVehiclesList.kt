package com.example.take_home_apt.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.take_home_apt.R
import com.example.take_home_apt.presentation.models.AvailableVehicle
import com.example.take_home_apt.utils.Dimens

val availableVehicles = listOf(
    AvailableVehicle("Ocean freight", "International", R.drawable.ship),
    AvailableVehicle("Cargo freight", "Reliable", R.drawable.trailer),
    AvailableVehicle("Air freight", "International", R.drawable.ship),
    AvailableVehicle("Road freight", "Reliable", R.drawable.trailer),
    AvailableVehicle("Ocean freight", "International", R.drawable.ship),
    AvailableVehicle("Cargo freight", "Reliable", R.drawable.trailer),
    AvailableVehicle("Air freight", "International", R.drawable.ship),
    AvailableVehicle("Road freight", "Reliable", R.drawable.trailer)
)

@Composable
fun AvailableVehiclesList() {

    Column {
        Text(text = "Available vehicles")
        Spacer(modifier = Modifier.height(Dimens.SmallPadding1))
        LazyRow {
            items(availableVehicles.size) { i ->
                val vehicles = availableVehicles[i]
                AvailableVehiclesItem(vehicle = vehicles)
            }
        }
    }
}

@Composable
fun AvailableVehiclesItem(modifier: Modifier = Modifier, vehicle: AvailableVehicle) {
    val imagePainter: Painter = painterResource(id = vehicle.image)

    Card(
        modifier = Modifier
            .padding(end = Dimens.SmallPadding1)
            .height(150.dp)
        ,
        elevation = CardDefaults.cardElevation(Dimens.ExtraSmallPadding),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = modifier
        ) {
            Text(text = vehicle.name)
            Text(text = vehicle.mode)
        }
        Image(
            painter = imagePainter,
            contentDescription = "Mode",
            modifier = Modifier
                .size(Dimens.VehicleCardSize)
                .height(200.dp)
                .clip(MaterialTheme.shapes.medium),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AvailableVehiclesItemPreview() {
    AvailableVehiclesList()
}
