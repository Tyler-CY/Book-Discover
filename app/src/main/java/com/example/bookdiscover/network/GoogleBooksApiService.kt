package com.example.bookdiscover.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.addAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// Constant base url for Google APIs. We are only interested in the Books API.
private const val BASE_URL = "https://www.googleapis.com/books/"

/**
 * Build the Moshi object for Kotlin JSON adapter
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .add(VolumeInfoAdapter())
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
    /**
     * Returns a list of books (TODO)
     */
    @GET("books/v1/volumes")
    suspend fun getBooks(): VolumeQueryResult

    /**
     * Test link with some results
     */
    @GET("v1/volumes?q=How%20to%20build%20a%20car&maxResults=2")
    suspend fun testLink(): VolumeQueryResult
}

/**
 * Public API object that exposes the lazy-initialized Retrofit service
 */
object GoogleBooksApi {
    val retrofitService: GoogleBooksApiService by lazy {
        retrofit.create(GoogleBooksApiService::class.java)
    }
}