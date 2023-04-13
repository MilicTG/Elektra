package com.delminiusdevs.elektra.presentation.composables.appbar

import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import com.delminiusdevs.elektra.presentation.ui.theme.TOP_APP_BAR_ICON_SIZE
import com.delminiusdevs.elektra.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutagesAppbar(
    title: String,
    scrollBehavior: TopAppBarScrollBehavior,
    onInfoClicked: () -> Unit,
    onRefreshClicked: () -> Unit,
    onSettingsClicked: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            scrolledContainerColor = MaterialTheme.colorScheme.surface
        ),
        scrollBehavior = scrollBehavior,
        actions = {
            IconButton(
                onClick = { onInfoClicked() }
            ) {
                Icon(
                    modifier = Modifier
                        .size(TOP_APP_BAR_ICON_SIZE),
                    painter = painterResource(id = R.drawable.ic_info),
                    contentDescription = "Info"
                )
            }

            IconButton(
                onClick = { onRefreshClicked() }
            ) {
                Icon(
                    modifier = Modifier
                        .size(TOP_APP_BAR_ICON_SIZE),
                    painter = painterResource(id = R.drawable.ic_refresh),
                    contentDescription = "Osvjezi"
                )
            }

            IconButton(
                onClick = { onSettingsClicked() }
            ) {
                Icon(
                    modifier = Modifier
                        .size(TOP_APP_BAR_ICON_SIZE),
                    painter = painterResource(id = R.drawable.ic_settings),
                    contentDescription = "Postavke"
                )
            }
        }
    )
}