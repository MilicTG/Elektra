package com.delminiusdevs.elektra.presentation.composables.containers

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.delminiusdevs.elektra.R
import com.delminiusdevs.elektra.presentation.ui.theme.EMPTY_CONTAINER_IMAGE_SIZE
import com.delminiusdevs.elektra.presentation.ui.theme.LARGE_PADDING
import com.delminiusdevs.elektra.presentation.ui.theme.NORMAL_PADDING
import com.delminiusdevs.elektra.presentation.ui.theme.SMALL_PADDING

@Composable
fun ErrorContainer(
    modifier: Modifier = Modifier,
    title: String,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier
                .size(EMPTY_CONTAINER_IMAGE_SIZE)
                .padding(all = SMALL_PADDING),
            painter = painterResource(id = R.drawable.svg_error),
            contentDescription = "greska"
        )

        Spacer(modifier = Modifier.size(NORMAL_PADDING))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = LARGE_PADDING),
            text = title,
            style = TextStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                textAlign = TextAlign.Center
            )
        )
    }
}