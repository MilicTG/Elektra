package com.delminiusdevs.elektra.presentation.composables.decoration

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.unit.dp
import com.delminiusdevs.elektra.presentation.ui.theme.SMALL_PADDING

@Composable
fun OutagesCardDateDecoration(
    modifier: Modifier = Modifier,
){
    val indicatorColor = MaterialTheme.colorScheme.primary

    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .padding(vertical = SMALL_PADDING)
                .height(1.dp)
                .width(30.dp)
        ) {
            drawRoundRect(
                color = indicatorColor,
                cornerRadius = CornerRadius(x = 10f, y = 10f)
            )
        }
    }
}