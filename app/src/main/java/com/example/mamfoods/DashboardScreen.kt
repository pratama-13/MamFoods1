package com.example.mamfoods.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mamfoods.ui.theme.BodyText
import com.example.mamfoods.ui.theme.ButtonHeight
import com.example.mamfoods.ui.theme.ButtonWidth
import com.example.mamfoods.ui.theme.DefaultPadding
import com.example.mamfoods.ui.theme.LightGrayColor
import com.example.mamfoods.ui.theme.PriceText
import com.example.mamfoods.ui.theme.RedGradient1
import com.example.mamfoods.ui.theme.SubText
import com.example.mamfoods.ui.theme.TitleText

@Composable
fun DashboardScreen(
    onAddItemClick: () -> Unit,
    onViewAllItemsClick: () -> Unit,
    onDeliveryStatusClick: () -> Unit,
    onProfileClick: () -> Unit,
    onCreateUserClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGrayColor)
            .padding(DefaultPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Text(
            text = "Mam Foods",
            style = TitleText,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(DefaultPadding))

        // Info Cards
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            InfoCard("Pending Order", "30")
            InfoCard("Completed Order", "10")
            InfoCard("Whole Time Earning", "100k")
        }

        Spacer(modifier = Modifier.height(DefaultPadding))

        // Menu Buttons
        ButtonGrid(
            onAddItemClick = onAddItemClick,
            onViewAllItemsClick = onViewAllItemsClick,
            onDeliveryStatusClick = onDeliveryStatusClick,
            onProfileClick = onProfileClick,
            onCreateUserClick = onCreateUserClick
        )
    }
}

@Composable
fun InfoCard(title: String, value: String) {
    Column(
        modifier = Modifier
            .width(110.dp)
            .background(LightGrayColor, shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = BodyText,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            style = PriceText,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ButtonGrid(
    onAddItemClick: () -> Unit,
    onViewAllItemsClick: () -> Unit,
    onDeliveryStatusClick: () -> Unit,
    onProfileClick: () -> Unit,
    onCreateUserClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(DefaultPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MenuButton("Add Menu", onAddItemClick)
            MenuButton("All Item Menu", onViewAllItemsClick)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MenuButton("Out For Delivery", onDeliveryStatusClick)
            MenuButton("Profile", onProfileClick)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MenuButton("Create New User", onCreateUserClick)
        }
    }
}

@Composable
fun MenuButton(title: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(ButtonWidth)
            .height(ButtonHeight),
        colors = ButtonDefaults.buttonColors(
            containerColor = RedGradient1
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = title,
            style = SubText.copy(color = LightGrayColor),
            textAlign = TextAlign.Center
        )
    }
}
