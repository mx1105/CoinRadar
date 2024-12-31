package com.mnaik.coinradar.presentation

/**
 * Created by Monil Naik on 28-12-2024.
 */
sealed class Screen(val route: String) {
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_detail_screen")
    object TagDetailScreen: Screen("tag_detail_screen")
}