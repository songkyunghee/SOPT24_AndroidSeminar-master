package org.sopt24.dshyun0226.androidseminar.network

import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.sopt24.dshyun0226.androidseminar.network.Post.*
import retrofit2.Call
import retrofit2.http.*

interface NetworkService { //모든 통신은 여기서 이루어짐

    @POST("/auth/signin") //HTTP Method(API URL)
    fun postLoginResponse(
        @Header("Content-Type")content_type:String, //HTTP Request Header
        @Body()body:JsonObject //post방식은 HTTP Request의 body에 Json 포맷으로 데이터를 담아서 전달
    ): Call<PostLoginResponse> //HTTP Response 포맷 (body)

    @POST("/auth/signup")
    fun postSignupResponse(
        @Header("Content-Type")content_type:String,
        @Body()body:JsonObject
    ): Call<PostSignupResponse>

    @GET("/soptoon/main/{flag}")
    fun getMainProductListResponse(
        @Header("Content-Type")content_type:String,
        @Path("flag")flag : Int
    ):Call<GetMainProductListResponse>

    @Multipart
    @POST("/api/webtoons/episodes/cmts")
    fun postCommentResponse(
        @Header("token")token: String,
        @Part("epidx")epidx: Int,
        @Part("content")content: RequestBody,
        @Part smtImg: MultipartBody.Part
    ): Call<PostCommentResponse>

    @GET("/soptoon/ep/{webtoonIdx}")
    fun getEpisodeListResponse(
        @Header("Content-Type")content_type:String,
        @Path("webtoonIdx")webtoonIdx: Int
    ):Call<GetEpisodeListResponse>

    @GET("/soptoon/ep/{webtoonIdx}/{epIdx}")
    fun getEpisodeResponse(
        @Header("Content-Type")content_type:String,
        @Path("webtoonIdx")webtoonIdx: Int,
        @Path("epIdx")epIdx: Int
    ): Call<GetEpisodeResponse>
}