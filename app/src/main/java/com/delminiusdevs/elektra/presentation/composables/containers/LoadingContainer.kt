package com.delminiusdevs.elektra.presentation.composables.containers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.delminiusdevs.elektra.presentation.ui.theme.NORMAL_PADDING
import com.delminiusdevs.elektra.presentation.ui.theme.PROGRESS_CIRCLE_SIZE

@Composable
fun LoadingContainer(
    modifier: Modifier = Modifier,
    title: String
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CircularProgressIndicator(
                modifier = Modifier
                    .size(PROGRESS_CIRCLE_SIZE),
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(NORMAL_PADDING))

            Text(
                text = title, style = TextStyle(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
            )
        }
    }
}