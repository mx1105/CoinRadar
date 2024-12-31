package com.mnaik.coinradar.domain.model

import com.mnaik.coinradar.data.remote.dto.coin.Tag
import com.mnaik.coinradar.data.remote.dto.coin.TeamMember

/**
 * Created by Monil Naik on 27-12-2024.
 */
data class CoinDetail(
    val id: String,
    val name: String,
    val symbol: String,
    val team: List<TeamMember>,
    val rank: Int,
    val description: String,
    val isActive: Boolean,
    val tags: List<Tag>
)