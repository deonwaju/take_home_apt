package com.example.take_home_apt.presentation.screens.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.take_home_apt.R
import com.example.take_home_apt.data.models.ShippingItems
import com.example.take_home_apt.utils.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    searchState: SearchState,
    event: (SearchEvent) -> Unit,
) {
    var searchText by remember { mutableStateOf("") }
    var searchResults by remember { mutableStateOf(searchState.searchItems) }

    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isClicked = interactionSource.collectIsPressedAsState().value
    LaunchedEffect(key1 = isClicked) {
        if (isClicked) {
            onClick?.invoke()
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(id = R.color.purple_500)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                modifier = Modifier
                    .size(Dimens.IconSizeMedium2)
                    .clip(MaterialTheme.shapes.medium)
                    .clickable {
                        onClick?.invoke()
                    },
                tint = Color.White
            )
            TextField(
                value = searchState.searchQuery,
                onValueChange = {
                   event(SearchEvent.UpdateSearchQuery(it))
                },
                modifier = modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.Transparent,
                        shape = MaterialTheme.shapes.extraLarge,
                    )
                    .padding(Dimens.SmallPadding1)
                    .background(color = colorResource(id = R.color.purple_500)),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        event(SearchEvent.SearchShipmentData)
                    }
                ),
                placeholder = {
                    Text(
                        text = stringResource(R.string.search),
                        style = MaterialTheme.typography.bodySmall,
                        color = colorResource(id = R.color.placeholder)
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.size(Dimens.IconSizeMedium),
                        tint = colorResource(id = R.color.purple_500)
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
                shape = MaterialTheme.shapes.extraLarge,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = colorResource(id = R.color.input_background),
                    focusedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    cursorColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = colorResource(id = R.color.purple_500),
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                singleLine = true,
            )
        }

        Spacer(modifier = modifier.height(16.dp))

        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(Dimens.SmallPadding1),
            elevation = CardDefaults.cardElevation(Dimens.ExtraSmallPadding),
            shape = MaterialTheme.shapes.small,
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            LazyColumn(
                modifier = modifier.padding(Dimens.SmallPadding1)
            ) {
                itemsIndexed(searchState.searchItems) { index, result ->

                    SearchResultItems(shippingItems = result)
                    if (index < searchState.searchItems.size - 1) {
                        Divider(modifier = Modifier.padding(vertical = Dimens.SmallPadding))
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
        Image(
            painter = painterResource(shippingItems.icon),
            contentDescription = null,
            modifier = Modifier
                .size(Dimens.IconSizeMedium2)
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
                code = shippingItems.code,
                cityFrom = shippingItems.cityFrom,
                cityTo = shippingItems.cityTo,
            )
        }
    }
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

        Spacer(modifier = Modifier.width(Dimens.ExtraSmallPadding2))

        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(Dimens.ExtraSmallPadding2)
        )

        Spacer(modifier = Modifier.width(Dimens.ExtraSmallPadding2))

        Text(
            cityFrom,
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.width(Dimens.ExtraSmallPadding2))

        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(Dimens.ExtraSmallPadding2)
        )

        Spacer(modifier = Modifier.width(Dimens.ExtraSmallPadding2))

        Text(
            cityTo,
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Light
        )
    }
}
