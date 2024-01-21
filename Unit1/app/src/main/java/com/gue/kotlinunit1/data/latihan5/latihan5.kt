package com.gue.kotlinunit1.data.latihan5

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gue.kotlinunit1.R
import com.gue.kotlinunit1.ui.theme.GreenGelap

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        NamePart(
            fullName = "Shindu BR",
            title = "Ngoding..ngoding..ngoding",
            modifier = Modifier
                .weight(2f)
        )
        InfoPart(
            phone = "+62-777777777",
            social = "@GueShindu",
            email = "gue.shindu@gmail.com",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun NamePart(fullName: String, title: String,  modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =Arrangement.Bottom,
        modifier = modifier.padding(all = 16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo"
        )
        Text(
            text = fullName,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = GreenGelap
        )
    }
}

@Composable
fun InfoPart(phone: String, social: String, email: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement =Arrangement.Bottom,
        modifier = modifier.padding(all = 16.dp)
        ) {
        InfoPartLine(Icons.Rounded.Call, phone)
        InfoPartLine(Icons.Rounded.Share, social)
        InfoPartLine(Icons.Rounded.Email, email)
    }
}


@Composable
fun InfoPartLine(icon: ImageVector, lineText: String,  modifier: Modifier = Modifier) {
    Row (
        modifier = modifier.padding(all = 4.dp)
        ) {
        Icon(icon, contentDescription = "Icon", tint = GreenGelap)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = lineText
        )
    }
}