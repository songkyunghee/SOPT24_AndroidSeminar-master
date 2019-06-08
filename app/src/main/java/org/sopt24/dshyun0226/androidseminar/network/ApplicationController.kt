package org.sopt24.dshyun0226.androidseminar.network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApplicationController : Application() {//앱이 실행될 떄 가장 먼저 실행


    private val baseURL="http://13.209.172.103:3000/"
    lateinit var networkService: NetworkService

    companion object {
        lateinit var instance:ApplicationController
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
        buildNetwork()
    }

    fun buildNetwork() {
        val retrofit: Retrofit=Retrofit.Builder() //retrofit 객체 생성
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        networkService=retrofit.create(NetworkService::class.java) //retrofit 객체 활성화
    }

}