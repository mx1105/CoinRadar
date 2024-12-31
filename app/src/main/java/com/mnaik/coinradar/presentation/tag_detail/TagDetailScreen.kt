package com.mnaik.coinradar.presentation.tag_detail

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mnaik.coinradar.common.Constants
import com.mnaik.coinradar.presentation.Screen
import com.mnaik.coinradar.presentation.component.CustomFlowRow
import com.mnaik.coinradar.presentation.component.Tag

/**
 * Created by Monil Naik on 31-12-2024.
 */

@Composable
fun TagDetailScreen(
    navController: NavController, viewModel: TagDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {

        state.tag?.let { tag ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = state.tag.name,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    )

                    Spacer(modifier = Modifier.height(15.dp))
                    if (!tag.description.isNullOrEmpty()) {
                        Text(
                            text = tag.description, style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                    }

                    if (tag.coins.isNotEmpty()) {
                        HorizontalDivider()
                        Spacer(modifier = Modifier.height(15.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .animateContentSize(animationSpec = tween(durationMillis = Constants.TAG_ITEM_ANIMATION))
                        ) {
                            Column {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Coins",
                                        style = MaterialTheme.typography.headlineSmall
                                    )
                                    Text(
                                        text = "${tag.coinCounter}",
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                }

                                Spacer(modifier = Modifier.height(15.dp))
                                CustomFlowRow(tag.coins, onItemClick = { value ->
                                    navController.navigate(Screen.CoinDetailScreen.route + "/${value}") {
                                        popUpTo(navController.graph.startDestinationId) { inclusive = false }
                                        launchSingleTop = true
                                    }
                                })

                                Spacer(modifier = Modifier.height(15.dp))
                            }
                        }
                    }

                    if(tag.icos.isNotEmpty()){
                        Spacer(modifier = Modifier.height(15.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .animateContentSize(animationSpec = tween(durationMillis = Constants.TAG_ITEM_ANIMATION))
                        ) {
                            Column {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Ico",
                                        style = MaterialTheme.typography.headlineSmall
                                    )
                                    Text(
                                        text = "${tag.icos.count()}",
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                }

                                Spacer(modifier = Modifier.height(15.dp))
                                CustomFlowRow(tag.icos, onItemClick = { value ->
                                    navController.navigate(Screen.CoinDetailScreen.route + "/${value}") {
                                        popUpTo(navController.graph.startDestinationId) { inclusive = false }
                                        launchSingleTop = true
                                    }
                                })

                                Spacer(modifier = Modifier.height(15.dp))
                            }
                        }
                    }
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
