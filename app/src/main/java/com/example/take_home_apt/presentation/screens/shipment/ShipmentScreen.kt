package com.example.take_home_apt.presentation.screens.shipment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.take_home_apt.R
import com.example.take_home_apt.data.models.ShipmentHistory
import com.example.take_home_apt.data.models.shipmentItems
import com.example.take_home_apt.presentation.components.ShipmentHistoryItem
import com.example.take_home_apt.presentation.components.ToolBarComponent
import com.example.take_home_apt.utils.Dimens.SmallPadding1

@Composable
fun ShipmentScreen(
    state: ShipmentState,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.purple_500))
    ) {
        ToolBarComponent(
            title = stringResource(R.string.shipment_history),
            onClick = {onClick?.invoke()}
        )
        TabScreen(shipmentHistory = state.shipmentHistory)
    }
}

@Composable
fun TabScreen(modifier: Modifier = Modifier, shipmentHistory: List<ShipmentHistory>) {
    var tabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf("All", "Completed", "In progress", "Pending", "loading")

    ScrollableTabRow(
        selectedTabIndex = tabIndex,
        edgePadding = SmallPadding1,
        modifier = modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.purple_500)),
        containerColor = colorResource(id = R.color.purple_500),
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                color = Color(0xFFFFA500),
                modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex])
            )
        }
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                text = {
                    Text(
                        text = title,
                        color = if (tabIndex == index) Color.White else Color.LightGray
                    )
                },
                selected = tabIndex == index,
                onClick = { tabIndex = index },
                modifier = modifier
                    .background(colorResource(id = R.color.purple_500))
            )
        }
    }
    shipmentItems.let { shipmentHistoryItems ->
        when (tabIndex) {
            0 -> GenericShipmentScreen(shipmentHistory = shipmentHistoryItems.shuffled())
            1 -> GenericShipmentScreen(shipmentHistory = shipmentHistoryItems.filter { it.status.contains("completed") })
            2 -> GenericShipmentScreen(shipmentHistory = shipmentHistoryItems.filter { it.status.contains("In progress") })
            3 -> GenericShipmentScreen(shipmentHistory = shipmentHistoryItems.filter { it.status.contains("pending") })
            4 -> GenericShipmentScreen(shipmentHistory = shipmentHistoryItems.filter { it.status.contains("loading") })
        }
    }
}


@Composable
fun GenericShipmentScreen(
    modifier: Modifier = Modifier,
    shipmentHistory: List<ShipmentHistory>
) {
    val items by remember { mutableStateOf(shipmentHistory) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        LazyColumn(
            modifier = modifier.padding(SmallPadding1)
        ) {
            itemsIndexed(items) { _, result ->
                ShipmentHistoryItem(shipmentHistory = result)
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewShipmentScreen() {
    ShipmentScreen()
}
