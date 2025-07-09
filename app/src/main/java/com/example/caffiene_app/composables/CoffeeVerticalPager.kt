package com.example.caffiene_app.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffiene_app.R
import com.example.caffiene_app.ui.theme.LightGrayBackground
import kotlin.math.abs

@Composable
fun CoffeeVerticalPager(
    items: List<Int>,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit = {},
) {
    val pagerState = rememberPagerState(
        pageCount = { items.size },
        initialPage = 1
    )

    VerticalPager(
        state = pagerState,
        pageSpacing = (6).dp,
        contentPadding = PaddingValues(vertical = 220.dp),
        modifier = modifier
            .fillMaxSize()
    ) { page ->
        val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction

        val scale = (1.7f - abs(pageOffset) * 0.5f).coerceAtLeast(1.7f)
        val horizontalOffset = (-80f * abs(pageOffset)).dp

        Box(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    translationX = horizontalOffset.toPx()
                }
                .padding(8.dp)
                .fillMaxWidth()
                .height(200.dp)
                .clickable { onClick(pagerState.currentPage) },
            contentAlignment = Alignment.Center
        ) {
            Box( modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp))
                .background(LightGrayBackground)
                .width(260.dp)
                .height(274.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = items[page]),
                    contentDescription = "",
                    modifier = Modifier
                        .width(144.dp)
                        .height(149.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview2() {
    val imageList = listOf(
        R.drawable.oreo,
        R.drawable.cookies,
        R.drawable.chocolate,
        R.drawable.croissant,
        R.drawable.lasagna,
        R.drawable.cupcake
    )
    CoffeeVerticalPager(imageList)
}
