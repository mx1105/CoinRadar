package com.mnaik.coinradar.presentation.coin_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mnaik.coinradar.presentation.Screen
import com.mnaik.coinradar.presentation.coin_detail.component.TeamListItem
import com.mnaik.coinradar.presentation.component.CustomFlowRow

/**
 * Created by Monil Naik on 28-12-2024.
 */

@Composable
fun CoinDetailScreen(
    navController: NavController, viewModel: CoinViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.coin?.let { coin ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.weight(8f),
                        )
                        Text(
                            text = if (coin.isActive) "Active" else "Inactive",
                            color = if (coin.isActive) Color.Green else Color.Red,
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.End,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .align(CenterVertically)
                                .weight(2f)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    if (!coin.description.isNullOrEmpty()) {
                        Text(
                            text = coin.description, style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }

                    if (coin.tags.isNotEmpty()) {
                        Text(
                            text = "Tag", style = MaterialTheme.typography.headlineSmall
                        )
                        Spacer(modifier = Modifier.height(15.dp))

                        CustomFlowRow(coin.tags, onItemClick = { value ->
                            navController.navigate(Screen.TagDetailScreen.route + "/${value.id}")
                        })
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                    if (coin.team.isNotEmpty()) {
                        Text(
                            text = "Team Member", style = MaterialTheme.typography.headlineSmall
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
                if (coin.team.isNotEmpty()) items(coin.team) { teamMember ->
                    TeamListItem(
                        teamMember = teamMember, modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                    HorizontalDivider()
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}