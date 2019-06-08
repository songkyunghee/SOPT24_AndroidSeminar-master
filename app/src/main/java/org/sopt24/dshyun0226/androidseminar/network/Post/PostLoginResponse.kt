package org.sopt24.dshyun0226.androidseminar.network.Post

data class PostLoginResponse (
    val status: Int,
    val success: Boolean,
    val message: String
   // val data: String? 사용자 인증 정보를 저장할 토큰값
    //null 값이 있을 수 있기 때문
)