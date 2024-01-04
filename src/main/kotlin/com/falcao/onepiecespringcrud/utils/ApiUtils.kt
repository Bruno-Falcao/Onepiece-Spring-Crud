package com.falcao.onepiecespringcrud.utils

import java.time.LocalDateTime

class ApiUtils {
    companion object {
        fun getLocalDateNow() = LocalDateTime.now().withSecond(0).withNano(0).toString()
    }
}