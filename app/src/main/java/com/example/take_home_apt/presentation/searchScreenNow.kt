package com.example.take_home_apt.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.take_home_apt.presentation.models.ShippingItems

@Composable
fun SearchScreenNow() {
    var searchText by remember { mutableStateOf("") }
    var searchResults by remember { mutableStateOf(emptyList<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
                searchResults = getMatchingResults(it)
            },
            label = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(searchResults) { result ->
                Text(result, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun SearchResultItems(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .padding(end = 16.dp)
        )

        Column {
            Text(text = text1, style = MaterialTheme.typography.titleMedium)
            Text(text = text2, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

fun getMatchingResults(query: String): List<String> {
    // Hardcoded data for demonstration
    val data = listOf(
        ShippingItems("Macbook pro M2", "#NE43857340857904 • Paris → Morocco", "Cherry"),
        ShippingItems("Summer linen jacket", "#NE43857340857904 • Paris → Morocco", "Cherry"),
        ShippingItems("Tapered fit jeans AW", "#NE43857340857904 • Paris → Morocco", "Cherry"),
        ShippingItems("Slim fit jeans AW", "#NE43857340857904 • Paris → Morocco", "Cherry"),
        ShippingItems("Office setup desk", "#NE43857340857904 • Paris → Morocco", "Cherry"),
        ShippingItems("Macbook air M2", "#NE43857340857904 • Paris → Morocco", "Cherry"),
        ShippingItems("Dell Alien ware", "#NE43857340857904 • Paris → Morocco", "Cherry"),
        ShippingItems("Hp", "#NE43857340857904 • Paris → Morocco", "Cherry"),
    )

    return data.filter { it.contains(query, ignoreCase = true) }
}

@Composable
@Preview(showBackground = true)
fun PreviewSearchScreen() {
    SearchScreenNow()
}
