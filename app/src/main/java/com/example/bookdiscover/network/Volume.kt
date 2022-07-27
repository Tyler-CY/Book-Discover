package com.example.bookdiscover.network

import com.squareup.moshi.JsonClass


/**
 * data class for a volume (i.e. a book)
 */
@JsonClass(generateAdapter = true)
//@Entity
data class Volume(
//    @PrimaryKey
    val id: String,
    // all Info Maps are optional
//    @ColumnInfo(name = "volume_info")
    val volumeInfo: Map<String, Any?>? = null,

//    @ColumnInfo(name = "user_info")
    val userInfo: Map<String, Any?>? = null,

//    @ColumnInfo(name = "sale_info")
    val saleInfo: Map<String, Any?>? = null,

//    @ColumnInfo(name = "access_info")
    val accessInfo: Map<String, Any?>? = null,

//    @ColumnInfo(name = "search_info")
    val searchInfo: Map<String, Any?>? = null,

)





