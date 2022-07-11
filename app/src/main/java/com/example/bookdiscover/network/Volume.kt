package com.example.bookdiscover.network

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonClass
import com.squareup.moshi.JsonQualifier
import com.squareup.moshi.ToJson

@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class VolumeInfoTitle

/**
 * data class for a volume (i.e. a book)
 */
@JsonClass(generateAdapter = true)
data class Volume(
    val id: String,
    // all Info Maps are optional
    val volumeInfo: Map<String, Any?>? = null,
    val userInfo: Map<String, Any?>? = null,
    val saleInfo: Map<String, Any?>? = null,
    val accessInfo: Map<String, Any?>? = null,
    val searchInfo: Map<String, Any?>? = null,
)


class VolumeInfoAdapter {
    @ToJson
    fun toJson(title: String): String {
        return title
    }

    @FromJson @VolumeInfoTitle
    fun fromJson(volumeInfo: Map<String, Any?>): String {
        return volumeInfo["title"].toString()
    }
}




