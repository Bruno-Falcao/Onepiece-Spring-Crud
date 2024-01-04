package com.falcao.onepiecespringcrud.model.dto

import org.springframework.data.annotation.Id

data class CrewMemberDto(
    @Id val id: String?,
    val name: String,
    val age: Int
)
