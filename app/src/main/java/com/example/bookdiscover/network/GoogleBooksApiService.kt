package com.example.bookdiscover.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// Constant base url for Google APIs. We are only interested in the Books API.
private const val BASE_URL = "https://www.googleapis.com/books/"

/**
 * Build the Moshi object for Kotlin JSON adapter
 */
private val moshi = Moshi.Builder()
    .add(VolumeInfoAdapter())
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
    suspend fun searchByName(@Query("q") bookName: String, @Query("maxResults") maxResults: String): VolumeQueryResult
}

/**
 * Public API object that exposes the lazy-initialized Retrofit service
 */
object GoogleBooksApi {
    val retrofitService: GoogleBooksApiService by lazy {
        retrofit.create(GoogleBooksApiService::class.java)
    }
}