package com.mnaik.coinradar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mnaik.coinradar.data.remote.dto.TeamMember
import com.mnaik.coinradar.presentation.Screen
import com.mnaik.coinradar.presentation.coin_detail.CoinDetailScreen
import com.mnaik.coinradar.presentation.coin_detail.component.TeamListItem
import com.mnaik.coinradar.presentation.coin_list.CoinListScreen
import com.mnaik.coinradar.presentation.theme.CoinRadarTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinRadarTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(route = Screen.CoinListScreen.route) {
                            CoinListScreen(navController)
                        }
                        composable(route = Screen.CoinDetailScreen.route + "/{coinId}") {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun preview(){
    Box(modifier = Modifier.fillMaxSize()) {
        TeamListItem(teamMember = TeamMember(id  = "1", name="TEst", position = "1"))
    }
}