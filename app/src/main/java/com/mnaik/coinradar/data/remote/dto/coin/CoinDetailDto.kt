package com.mnaik.coinradar.data.remote.dto.coin


import com.google.gson.annotations.SerializedName
import com.mnaik.coinradar.domain.model.CoinDetail

data class CoinDetailDto(
    val id: String,
    val name: String,
    val symbol: String,
    val parent: Parent,
    val rank: Int,
    @SerializedName("is_new") val isNew: Boolean,
    @SerializedName("is_active") val isActive: Boolean,
    val type: String,
    val logo: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val description: String,
    val message: String,
    @SerializedName("open_source") val openSource: Boolean,
    @SerializedName("hardware_wallet") val hardwareWallet: Boolean,
    @SerializedName("started_at") val startedAt: String,
    @SerializedName("development_status") val developmentStatus: String,
    @SerializedName("proof_type") val proofType: String,
    @SerializedName("org_structure") val orgStructure: String,
    @SerializedName("hash_algorithm") val hashAlgorithm: String,
    val contract: String,
    val platform: String,
    val contracts: List<Contract>,
    val links: Links,
    @SerializedName("links_extended") val linksExtended: List<LinksExtended>,
    val whitepaper: Whitepaper,
    @SerializedName("first_data_at") val firstDataAt: String,
    @SerializedName("last_data_at") val lastDataAt: String
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        id = id,
        name = name,
        symbol = symbol,
        team = team,
        rank = rank,
        description = description,
        isActive = isActive,
        tags = tags
    )
}