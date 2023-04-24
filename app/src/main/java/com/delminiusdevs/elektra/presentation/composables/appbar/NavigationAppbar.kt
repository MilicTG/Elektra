package com.delminiusdevs.elektra.presentation.composables.appbar

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import com.delminiusdevs.elektra.presentation.ui.theme.TOP_APP_BAR_ICON_SIZE
import com.delminiusdevs.elektra.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationAppbar(
    title: String,
    scrollBehavior: TopAppBarScrollBehavior,
    onBackTaped: () -> Unit,
){
    TopAppBar(
        title = {
            Text(
                text = title,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        },
        navigationIcon = {
            IconButton(
                onClick = { onBackTaped() }
            ) {
                Icon(
                    modifier = Modifier
                        .size(TOP_APP_BAR_ICON_SIZE),
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Natrag"
                )
            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            scrolledContainerColor = MaterialTheme.colorScheme.surface
        ),
        scrollBehavior = scrollBehavior,
    )
}