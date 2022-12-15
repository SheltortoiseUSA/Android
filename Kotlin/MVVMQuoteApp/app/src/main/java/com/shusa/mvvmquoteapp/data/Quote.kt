package com.shusa.mvvmquoteapp.data

// Explicit Data Constructor
/** DEFINITION:
 * 1) Data classes are basically objects that primarily focus on storing and accessing data.
 * 2) They come with extra data access functions built into Kotlin that enhance their usability.
 * **/
data class Quote(val quoteText: String, val author: String) {
    override fun toString(): String {
        return "$quoteText - $author"
    }
}