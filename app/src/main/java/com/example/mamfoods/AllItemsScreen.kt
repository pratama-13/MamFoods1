package com.example.mamfoods.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.mamfoods.ui.theme.TitleText

// Mendefinisikan warna background untuk tombol
val RedGradient3 = Color(0xFFE85353)

// Ekstensi properti untuk ikon pengurangan custom
val Icons.Filled.CustomRemove: ImageVector
    get() = Icons.Filled.Delete // Ganti dengan ikon kustom yang diinginkan, jika diperlukan

@Composable
fun AllItemsScreen(onBackClick: () -> Unit) {
    // List gambar dan judul item
    val items = listOf(
        Pair("Love and Coffee", "https://assets-a1.kompasiana.com/statics/crawl/555d4de00423bde5188b4567.jpeg"),
        Pair("Tunderloin Steak", "https://asset.kompas.com/crops/rPrzci9RRSeRCRNXG8yFyaEcNN8=/100x77:900x610/1200x800/data/photo/2022/05/21/62887abe8f50f.jpg"),
        Pair("Mociii", "https://cdn.rri.co.id/berita/Palangkaraya/o/1720844152016-FB_IMG_1720843523754/vrobe818xjgq2op.jpeg")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Judul All Items
        Text(
            "All Items",
            style = TitleText,
            textAlign = TextAlign.Center // Menambahkan textAlign untuk center alignment
        )

        // Menampilkan daftar item
        items.forEach { item ->
            ItemRow(item) // Panggil composable untuk menampilkan satu baris item
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tombol Back
        Button(
            onClick = onBackClick,
            colors = ButtonDefaults.buttonColors(containerColor = RedGradient3),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(8.dp)
        ) {
            Text("Back", color = Color.White)
        }
    }
}

@Composable
fun ItemRow(item: Pair<String, String>) {
    var quantity by remember { mutableStateOf(1) } // State untuk mengatur jumlah item

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(IntrinsicSize.Min), // Pastikan row memiliki tinggi yang cukup untuk menampung semua komponen
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Gambar Item (menggunakan URL)
        val painter = rememberAsyncImagePainter(item.second)

        Image(
            painter = painter,
            contentDescription = item.first,
            modifier = Modifier
                .size(80.dp) // Ukuran gambar yang diinginkan
                .padding(end = 16.dp),
            contentScale = ContentScale.Crop // Gambar akan dipotong sesuai dengan ukuran
        )

        // Nama Item
        Column(
            modifier = Modifier
                .weight(1f) // Memastikan nama item mengambil sisa ruang
        ) {
            Text(item.first) // Judul Item
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Kontrol untuk mengubah kuantitas
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f) // Menambahkan weight untuk memastikan tombol berada di tengah
        ) {
            // Tombol untuk mengurangi kuantitas (ikon minus)
            IconButton(
                onClick = {
                    if (quantity > 1) quantity -= 1 // Mengurangi kuantitas jika lebih dari 1
                },
                modifier = Modifier
                    .size(36.dp)
                    .background(RedGradient3, shape = CircleShape) // Memberikan background pada tombol
            ) {
                Icon(
                    imageVector = Icons.Filled.Remove, // Ikon minus untuk pengurangan
                    contentDescription = "Decrease Quantity",
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Menampilkan jumlah item
            Text(
                text = "$quantity",
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Tombol untuk menambah kuantitas (ikon plus)
            IconButton(
                onClick = {
                    quantity += 1 // Menambah kuantitas
                },
                modifier = Modifier
                    .size(36.dp)
                    .background(RedGradient3, shape = CircleShape) // Memberikan background pada tombol
            ) {
                Icon(
                    imageVector = Icons.Filled.Add, // Ikon plus untuk penambahan
                    contentDescription = "Increase Quantity",
                    tint = Color.White
                )
            }
        }

        // Tombol untuk menghapus item (keranjang sampah) - Diletakkan di kanan
        IconButton(
            onClick = { /* Logic untuk menghapus item */ },
            modifier = Modifier
                .height(24.dp) // Ukuran tombol delete lebih kecil
                .padding(start = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Delete, // Tombol untuk menghapus item
                contentDescription = "Delete Item",
                tint = Color.White
            )
        }
    }
}
