package com.example.bookdiscover.network

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonClass
import com.squareup.moshi.JsonQualifier
import com.squareup.moshi.ToJson

@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
@Entity
annotation class VolumeInfoTitle

/**
 * data class for a volume (i.e. a book)
 */
@JsonClass(generateAdapter = true)
data class Volume(
    @PrimaryKey
    val id: String,
    // all Info Maps are optional
    @ColumnInfo(name = "volume_info")
    val volumeInfo: Map<String, Any?>? = null,

    @ColumnInfo(name = "user_info")
    val userInfo: Map<String, Any?>? = null,

    @ColumnInfo(name = "sale_info")
    val saleInfo: Map<String, Any?>? = null,

    @ColumnInfo(name = "access_info")
    val accessInfo: Map<String, Any?>? = null,

    @ColumnInfo(name = "search_info")
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




