package com.example.marvelapp.data.api

import com.example.marvelapp.util.Constant.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MarvelApi {

    private val builder = OkHttpClient.Builder().addInterceptor(Interceptor()).build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(builder)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val marvelService: MarvelService = retrofit.create(MarvelService::class.java)
}