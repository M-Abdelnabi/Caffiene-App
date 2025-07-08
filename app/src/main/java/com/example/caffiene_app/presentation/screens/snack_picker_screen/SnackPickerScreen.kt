package com.example.caffiene_app.presentation.screens.snack_picker_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffiene_app.R
import com.example.caffiene_app.composables.CoffeeVerticalPager
import com.example.caffiene_app.ui.theme.Charcoal
import com.example.caffiene_app.ui.theme.LightGrayBackground
import com.example.caffiene_app.ui.theme.UrbanistFont
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SnackPickerScreen(
    modifier: Modifier = Modifier,
    viewModel: SnackPickerViewModel = koinViewModel(),
) {
    val imageList = listOf(
        R.drawable.oreo,
        R.drawable.cookies,
        R.drawable.chocolate,
        R.drawable.croissant,
        R.drawable.lasagna,
        R.drawable.cupcake
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .size(48.dp)
                .clip(CircleShape)
                .background(LightGrayBackground)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_exit),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.Center)
                    .clickable { viewModel.onExitClick() }
            )
        }
        Text(
            text = stringResource(R.string.take_your_snack),
            textAlign = TextAlign.Center,
            fontFamily = UrbanistFont,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Charcoal.copy(alpha = 0.87f),
            modifier = Modifier.padding(top = 24.dp, start = 16.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {
            CoffeeVerticalPager(
                items = imageList,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .offset(x = (-70).dp),
                onClick = { viewModel.onItemClick() }
            )
        }
    }
}