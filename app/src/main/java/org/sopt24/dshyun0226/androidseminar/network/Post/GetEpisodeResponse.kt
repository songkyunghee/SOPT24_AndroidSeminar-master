package org.sopt24.dshyun0226.androidseminar.network.Post

import org.sopt24.dshyun0226.androidseminar.data.EpisodeOverviewData

data class GetEpisodeResponse (
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: ArrayList<EpisodeOverviewData>?
)