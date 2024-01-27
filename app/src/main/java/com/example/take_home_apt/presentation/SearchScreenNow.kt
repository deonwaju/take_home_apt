package com.example.take_home_apt.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.take_home_apt.R
import com.example.take_home_apt.presentation.models.ShippingItems
import com.example.take_home_apt.utils.Dimens
import com.example.take_home_apt.utils.Dimens.ExtraSmallPadding
import com.example.take_home_apt.utils.Dimens.SmallPadding1


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreenNow(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {

    var searchText by remember { mutableStateOf("") }
    var searchResults by remember { mutableStateOf(emptyList<ShippingItems>()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(ExtraSmallPadding)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                modifier = Modifier
                    .size(Dimens.IconSizeMedium)
                    .clip(MaterialTheme.shapes.medium)
                    .padding(end = Dimens.ExtraSmallPadding2)
            )

            TextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                    searchResults = getMatchingResults(it)
                },
                label = { Text("Search") },
                modifier = modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = MaterialTheme.shapes.extraLarge
                    ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                placeholder = {
                    Text(
                        text = "Search",
                        style = MaterialTheme.typography.bodySmall,
                        color = colorResource(id = R.color.placeholder)
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        modifier = Modifier.size(Dimens.IconSize),
                        tint = colorResource(id = R.color.body)
                    )
                },
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_scanner2), // Replace with your SVG resource ID
                        contentDescription = null,
                        modifier = Modifier
                            .size(Dimens.IconSizeMedium2)
                            .clip(CircleShape),
                    )
                },
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = colorResource(id = R.color.input_background),
                    focusedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    cursorColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                singleLine = true,
            )
        }

        Spacer(modifier = modifier.height(16.dp))

        if (searchText.isNotEmpty() && searchResults.isNotEmpty()) {
            Card(
                modifier = modifier
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(Dimens.ExtraSmallPadding),
                shape = MaterialTheme.shapes.small,
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                LazyColumn(
                    modifier = modifier.padding(SmallPadding1)
                ) {
                    items(searchResults) { result ->
                        SearchResultItems(shippingItems = result)
                    }
                }
            }
        }
    }
}

@Composable
fun SearchResultItems(modifier: Modifier = Modifier, shippingItems: ShippingItems) {

    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(shippingItems.icon),
            contentDescription = null,
            modifier = Modifier
                .size(Dimens.IconSizeMedium)
                .clip(MaterialTheme.shapes.medium)
                .padding(end = Dimens.ExtraSmallPadding2)
        )

        Column(
            modifier = modifier.weight(1f)
        ) {
            Text(
                text = shippingItems.name,
                fontFamily = FontFamily.SansSerif,
                style = MaterialTheme.typography.titleSmall,
            )
            Spacer(modifier = Modifier.height(Dimens.ExtraSmallPadding))
            DetailsWidget(
                code = "#NE43857340857904",
                cityFrom = "Paris",
                cityTo = "Morocco"
            )
        }
    }

    Divider(modifier = Modifier.padding(vertical = Dimens.ExtraSmallPadding2))
}

@Composable
fun DetailsWidget(
    modifier: Modifier = Modifier,
    code: String,
    cityFrom: String,
    cityTo: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = code,
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(8.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            cityFrom,
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(8.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            cityTo,
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Light
        )
    }
}

fun getMatchingResults(query: String): List<ShippingItems> {
    // Hardcoded data for demonstration
    val data = listOf(
        ShippingItems(
            name = "Macbook pro M2",
            code = "#NE43857340857904",
            cityFrom = "Paris",
            cityTo = "Morocco",
            icon = R.drawable.ic_box_2
        ),
        ShippingItems(
            "Summer linen jacket",
            "#NE20089934122231",
            "Barcelona",
            "Paris",
            R.drawable.ic_box_2
        ),
        ShippingItems(
            "Tapered fit jeans AW",
            "#NE438343340857904",
            "Colombia",
            "Paris",
            R.drawable.ic_box_2
        ),
        ShippingItems(
            "Slim fit jeans AW",
            "#NE848467357904",
            "Bogota",
            "Dhaka",
            R.drawable.ic_box_2
        ),
        ShippingItems(
            "Office setup desk",
            "#NEHJKD57340857904",
            "Dubai",
            "Dublin",
            R.drawable.ic_box_2
        ),
        ShippingItems(
            "Macbook air M2",
            "#NE4334GHJD40857904",
            "Lagos",
            "Accra",
            R.drawable.ic_box_2
        ),
        ShippingItems(
            "Dell Alien ware",
            "#NE43857340857904",
            "Bali",
            "Seychelles",
            R.drawable.ic_box_2
        ),
        ShippingItems(
            "Hp Elite book",
            "#NE43857340857904",
            "Paris",
            "Morocco",
            R.drawable.ic_box_2
        )
    )

    return data.map {
        it
    }.filter { it.name.contains(query, ignoreCase = true) }
}

fun Modifier.searchBar(): Modifier = composed {
    if (!isSystemInDarkTheme()) {
        border(
            width = 1.dp,
            color = Color.Black,
            shape = MaterialTheme.shapes.extraLarge
        )
    } else {
        this
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewSearchScreen() {
    SearchScreenNow()
}
