package com.lamoureux.ccm2_td_android_insset.architecture

import com.google.gson.GsonBuilder

import com.lamoureux.ccm2_td_android_insset.endpoint.DonaldTrumpQuoteEndPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.tronalddump.io/random/quote/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
            .build()


    fun getDonaldTrump(): DonaldTrumpQuoteEndPoint = retrofit.create(DonaldTrumpQuoteEndPoint::class.java)
}
