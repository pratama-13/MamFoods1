package com.example.mamfoods.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mamfoods.ui.theme.*

@Composable
fun OutForDeliveryScreen(onBackClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(DefaultPadding),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Out for Delivery", style = TitlePage)

        val deliveries = listOf(
            "Customer 1" to true,
            "Customer 2" to false
        )

        deliveries.forEach { (customer, status) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(customer, style = BodyText)

                // Status Text
                Text(
                    text = if (status) "Delivered" else "Not Delivered",
                    style = if (status) {
                        StatusText.copy(color = Color.Green)
                    } else {
                        StatusText.copy(color = Color.Red)
                    }
                )

                // Status Indicator (Box)
                Box(
                    modifier = Modifier
                        .size(StatusBoxSize)
                        .background(if (status) Color.Green else Color.Red)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Back Button
        Button(
            onClick = onBackClick,
            modifier = Modifier
                .height(ButtonHeight)
                .width(ButtonWidth)
        ) {
            Text("Back")
        }
    }
}
