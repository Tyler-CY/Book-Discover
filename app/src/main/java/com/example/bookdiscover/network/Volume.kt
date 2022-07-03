package com.example.bookdiscover.network

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonClass
import com.squareup.moshi.JsonQualifier
import com.squareup.moshi.ToJson
import org.jetbrains.annotations.Nullable

@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class VolumeInfoTitle


@JsonClass(generateAdapter = true)
data class Volume (
    val id: String,
    val volumeInfo: Map<String, Any?>,
    @VolumeInfoTitle val title: String
)

// TODO: toJson not working: com.squareup.moshi.JsonDataException: Required value 'title' missing at $.items[1]
class VolumeInfoAdapter {
    @ToJson fun toJson(@VolumeInfoTitle title: String): String {
        return title
    }
    @FromJson @VolumeInfoTitle fun fromJson(volumeInfo: Map<String, Any?>): String {
        return volumeInfo.get("title").toString()
    }
}




