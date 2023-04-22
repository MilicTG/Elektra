package com.delminiusdevs.elektra.presentation.composables.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.delminiusdevs.elektra.domain.model.Outages
import com.delminiusdevs.elektra.presentation.composables.decoration.OutagesCardDateDecoration
import com.delminiusdevs.elektra.presentation.ui.theme.LARGE_PADDING
import com.delminiusdevs.elektra.presentation.ui.theme.NORMAL_PADDING
import com.delminiusdevs.elektra.presentation.ui.theme.SMALL_PADDING

@Composable
fun OutagesCard(
    modifier: Modifier = Modifier,
    outages: Outages,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = SMALL_PADDING),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Column(
            modifier = Modifier
                .padding(end = NORMAL_PADDING),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = outages.dayOfOutage.toString().uppercase(),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.labelSmall.fontSize,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                )
            )

            OutagesCardDateDecoration()

            Text(
                text = outages.dateOfOutage.toString(),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                )
            )

        }

        Card(
            modifier = modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.extraLarge),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {

            Text(
                modifier = Modifier
                    .padding(
                        vertical = NORMAL_PADDING,
                        horizontal = LARGE_PADDING
                    ),
                text = outages.branchOfficeName.uppercase(),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Start,
                )
            )

            Text(
                modifier = Modifier
                    .padding(
                        vertical = SMALL_PADDING,
                        horizontal = LARGE_PADDING
                    ),
                text = outages.location,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Start,
                )
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = LARGE_PADDING,
                        end = LARGE_PADDING,
                        bottom = SMALL_PADDING
                    )
                    .height(0.5.dp)
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.7f))
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = LARGE_PADDING,
                        end = LARGE_PADDING,
                        bottom = NORMAL_PADDING
                    )
            ) {

                Text(
                    text = "Najavljeni nestanak od: ${outages.timeFrom} do ${outages.timeTo}",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Start,
                    )
                )
            }
        }
    }
}