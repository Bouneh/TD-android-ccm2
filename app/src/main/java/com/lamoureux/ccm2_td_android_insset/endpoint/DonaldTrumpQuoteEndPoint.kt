package com.lamoureux.ccm2_td_android_insset.endpoint

import com.lamoureux.ccm2_td_android_insset.model.DonaldTrump
import retrofit2.http.GET

interface DonaldTrumpQuoteEndPoint {
    @GET("random")
    suspend fun getRandomQuote(): DonaldTrump
}