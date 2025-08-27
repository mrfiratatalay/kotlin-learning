package com.firatatalay.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firatatalay.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFD2E8D4) // Açık yeşil arka plan
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D4))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Üst kısım - Logo ve profil bilgileri
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            ContactHeader(
                headerFullName = stringResource(R.string.header_full_name),
                headerTitle = stringResource(R.string.header_title)
            )
        }

        // Alt kısım - İletişim bilgileri
        Column(
            modifier = Modifier.padding(bottom = 80.dp)
        ) {
            ContactRow(
                icon = Icons.Filled.Phone,
                info = "+00 (00) 000 000",
            )
            Spacer(modifier = Modifier.height(16.dp))
            ContactRow(
                icon = Icons.Filled.Share,
                info = "@FiratAndroidDev"
            )
            Spacer(modifier = Modifier.height(16.dp))
            ContactRow(
                icon = Icons.Filled.Email,
                info = "firatatalay@gmail.com"
            )
        }
    }
}

@Composable
private fun ContactHeader(headerFullName: String, headerTitle: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        // Android logo için koyu yeşil kare arka plan
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    Color(0xFF073042), // Koyu yeşil-mavi
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = headerFullName,
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF2D5016) // Koyu yeşil
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = headerTitle,
            fontSize = 16.sp,
            color = Color(0xFF0F7B0F), // Orta tonda yeşil
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun ContactRow(icon: ImageVector, info: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF0F7B0F), // Yeşil renk
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = info,
            fontSize = 16.sp,
            color = Color(0xFF2D5016), // Koyu yeşil
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}