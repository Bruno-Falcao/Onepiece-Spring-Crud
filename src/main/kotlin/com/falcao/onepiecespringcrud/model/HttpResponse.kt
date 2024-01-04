package com.falcao.onepiecespringcrud.model

import org.springframework.http.HttpStatus

data class HttpResponse(
    val timeStamp: String?,
    val statusCode: Int?,
    val status: HttpStatus?,
    val message: String?,
    val data: Map<Any, Any>?
) {

    companion object {
        fun builder(
            timeStamp: String?,
            statusCode: Int?,
            status: HttpStatus?,
            message: String?,
            data: Map<Any, Any>?
        ): HttpResponse {
            return HttpResponse(
                timeStamp = timeStamp,
                statusCode = statusCode,
                status = status,
                message = message,
                data = data
            )
        }
    }
}