package com.atilsamancioglu.artbookhilttesting.util

import androidx.annotation.Nullable

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
class Event<T>(content: T?) {
    private val mContent: T
    private var hasBeenHandled = false

    @get:Nullable
    val contentIfNotHandled: T?
        get() = if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            mContent
        }

    fun hasBeenHandled(): Boolean {
        return hasBeenHandled
    }

    init {
        requireNotNull(content) { "null values in Event are not allowed." }
        mContent = content
    }
}