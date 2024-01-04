package com.falcao.onepiecespringcrud.model

import org.springframework.data.annotation.Id

data class CrewMember(
    @Id val id: String?,
    var name: String,
    var age: Int
)
