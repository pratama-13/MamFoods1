package com.example.mamfoods.ui.theme

import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val TitleText = TextStyle(
    color = RedPrimary,
    fontSize = 40.sp,
    fontFamily = YeonSung,
    fontWeight = FontWeight.Normal
)

val TitlePage = TextStyle(
    color = RedPrimary,
    fontSize = 24.sp,
    fontFamily = YeonSung,
    fontWeight = FontWeight.Normal
)

val BodyText = TextStyle(
    color = Color.Black,
    fontSize = 14.sp,
    fontFamily = YeonSung,
    fontWeight = FontWeight.Normal
)

val PriceText = TextStyle(
    color = RedPrimary,
    fontSize = 20.sp,
    fontFamily = Lato,
    fontWeight = FontWeight.Bold
)

val DetailText = TextStyle(
    color = RedPrimary,
    fontSize = 14.sp,
    fontFamily = Lato,
    fontWeight = FontWeight.Bold
)

val SubText = TextStyle(
    color = RedPrimary,
    fontFamily = Lato,
    fontWeight = FontWeight.Bold
)

val DefaultPadding = 16.dp
val ButtonHeight = 50.dp
val ButtonWidth = 150.dp

// Menambahkan style baru untuk status (Delivered/Not Delivered)
val StatusText = TextStyle(
    color = Color.White,
    fontSize = 12.sp,
    fontFamily = Lato,
    fontWeight = FontWeight.Bold
)

val H4Text = TextStyle(
    color = Color.Black, // Atur warna sesuai dengan kebutuhan Anda
    fontSize = 32.sp,     // Tentukan ukuran font yang diinginkan
    fontFamily = Lato,    // Tentukan font yang diinginkan
    fontWeight = FontWeight.Bold
)

val StatusBoxSize = 16.dp
