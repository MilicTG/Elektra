package com.delminiusdevs.elektra.presentation.composables.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.delminiusdevs.elektra.R
import com.delminiusdevs.elektra.domain.model.BranchOffice
import com.delminiusdevs.elektra.presentation.ui.theme.NORMAL_PADDING
import com.delminiusdevs.elektra.presentation.ui.theme.SMALL_PADDING
import com.delminiusdevs.elektra.presentation.ui.theme.TOP_APP_BAR_ICON_SIZE

@Composable
fun BranchCard(
    modifier: Modifier = Modifier,
    branchOffice: BranchOffice,
    onAddClicked: (BranchOffice) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = SMALL_PADDING),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        Text(
            modifier = Modifier
                .weight(1f),
            text = branchOffice.name,
            style = TextStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = FontWeight.SemiBold
            )
        )

        Spacer(modifier = Modifier.size(NORMAL_PADDING))

        IconButton(
            onClick = { onAddClicked(branchOffice) }
        ) {
            Icon(
                modifier = Modifier
                    .size(TOP_APP_BAR_ICON_SIZE),
                painter = painterResource(id = R.drawable.ic_plus),
                contentDescription = "dodaj",
                tint = MaterialTheme.colorScheme.primary
            )
        }

    }
}