package com.example.caffiene_app.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.example.caffiene_app.R
import com.example.caffiene_app.ui.theme.Charcoal
import com.example.caffiene_app.ui.theme.UrbanistFont
import kotlin.math.absoluteValue as absoluteValue1

@Composable
fun CoffeeHorizontalPager(
    items: List<Pair<Int, String>>,
    onItemSelected: (Int) -> Unit ={}
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { items.size })

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 98.dp),
        pageSpacing = 16.dp,
        modifier = Modifier.fillMaxWidth()
    ) { page ->
        val pageOffset =
            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue1
        val scale = lerp(0.80f, 1f, 1f - pageOffset.coerceIn(0f, 1f))
        val offsetY = lerp(30.dp, 0.dp, 1f - pageOffset.coerceIn(0f, 1f))
        onItemSelected(pagerState.currentPage)

        Column(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
                .offset(y = offsetY)
                .fillMaxWidth()
                .height(300.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = items[page].first),
                contentDescription = "",
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .width(244.dp)
                    .height(200.dp)
            )
            Text(
                text = items[page].second,
                fontFamily = UrbanistFont,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Charcoal
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScalableHorizontalPagerPreview() {
    val coffeeItems = listOf(
        R.drawable.espresso to "Espresso",
        R.drawable.latte to "Latte",
        R.drawable.macchiato to "Cappuccino",
        R.drawable.black_coffee to "Black"
    )

    CoffeeHorizontalPager(items = coffeeItems)
}
