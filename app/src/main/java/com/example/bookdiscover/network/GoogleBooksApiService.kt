package com.example.bookdiscover.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// Constant base url for Google APIs. We are only interested in the Books API.
private const val BASE_URL = "https://www.googleapis.com/books/"

/**
 * Build the Moshi object for Kotlin JSON adapter
 */
private val moshi = Moshi.Builder()
    .addLast(KotlinJsonAdapterFactory())
    .build()

/**
 * Retrofit with Moshi converter
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * Public interface for retrieving data from Google's Books API
 */
interface GoogleBooksApiService {

    @GET("v1/volumes")
    suspend fun search(@Query("q") queryString: String, @Query("maxResults") maxResults: String = "25"): VolumeQueryResult

    // Do NOT make this a suspend function. It does not work.
    @GET("v1/volumes/{Id}")
    fun searchById(@Path("Id") id: String): Call<ResponseBody>

}

/**
 * Public API object that exposes the lazy-initialized Retrofit service
 */
object GoogleBooksApi {
    val retrofitService: GoogleBooksApiService by lazy {
        retrofit.create(GoogleBooksApiService::class.java)
    }
}