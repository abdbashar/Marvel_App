package com.example.marvelapp.data.api

import com.example.marvelapp.util.Constant
import com.example.marvelapp.util.extension.md5
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class Interceptor : Interceptor {

    private val timeStamp =
        (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()

    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("ts", timeStamp)
            .addQueryParameter("apikey", Constant.API_KEY)
            .addQueryParameter("hash", "$timeStamp${Constant.PRIVATE_KEY}${Constant.API_KEY}".md5())
            .build()

        return chain.proceed(chain.request().newBuilder().url(url).build())
    }
}