package com.example.caffiene_app.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffiene_app.R
import kotlin.math.abs

@Composable
 fun CoffeeVerticalPager(
    items: List<Int>,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    val pagerState = rememberPagerState(
        pageCount = { items.size },
        initialPage = 1
    )

    VerticalPager(
        state = pagerState,
        pageSpacing = (16).dp,
        contentPadding = PaddingValues(vertical = 250.dp),
        modifier = modifier
            .fillMaxSize()
    ) { page ->
        val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction

        val scale = (1.7f - abs(pageOffset) * 0.5f).coerceAtLeast(2f)
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
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = items[page]),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
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
