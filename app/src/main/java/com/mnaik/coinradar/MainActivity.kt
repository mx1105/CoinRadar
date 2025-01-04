package com.mnaik.coinradar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mnaik.coinradar.common.Constants
import com.mnaik.coinradar.presentation.Screen
import com.mnaik.coinradar.presentation.coin_detail.CoinDetailScreen
import com.mnaik.coinradar.presentation.coin_list.CoinListScreen
import com.mnaik.coinradar.presentation.tag_detail.TagDetailScreen
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
                        composable(route = Screen.CoinDetailScreen.route + "/{${Constants.PARAM_COIN_ID}}") {
                            CoinDetailScreen(navController)
                        }
                        composable(route = Screen.TagDetailScreen.route + "/{${Constants.PARAM_TAG_ID}}") {
                            TagDetailScreen(navController)
                        }
                    }
                }
            }
        }
    }
}