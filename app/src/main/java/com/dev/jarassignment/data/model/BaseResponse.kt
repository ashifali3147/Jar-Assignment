package com.dev.jarassignment.data.model

class BaseResponse<T> {
    val success: Boolean = false
    val data: T? = null
}