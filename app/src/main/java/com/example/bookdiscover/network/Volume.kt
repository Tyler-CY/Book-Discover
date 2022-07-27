package com.example.bookdiscover.network


/**
 * data class for a volume (i.e. a book)
 */


data class Volume(

    val id: String,

    val volumeInfo: Map<String, Any?>? = null,

//    val saleInfo: Map<String, Any?>? = null,
)





