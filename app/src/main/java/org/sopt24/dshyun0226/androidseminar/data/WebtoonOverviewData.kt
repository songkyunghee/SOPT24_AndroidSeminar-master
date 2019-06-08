package org.sopt24.dshyun0226.androidseminar.data

data class WebtoonOverviewData (
    var webtoonInfo: List<webtoonInfo>,
    var list: ArrayList<list>
)

data class webtoonInfo(
    var title: String,
    var likes: Int
)

data class list(
    var idx: Int,
    var chaper: Int,
    var title: String,
    var thumnail: String,
    var hits: Int,
    var wtIdx: Int
)