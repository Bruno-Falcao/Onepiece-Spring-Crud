package com.falcao.onepiecespringcrud.service

import com.falcao.onepiecespringcrud.model.CrewMember
import com.falcao.onepiecespringcrud.model.dto.CrewMemberDto

interface CrewService {

    fun findAll(): MutableList<CrewMemberDto>
    fun saveCrewMember(crew: CrewMember): String
    fun deleteMember(memberId: String)
    fun updateMember(memberDto: CrewMemberDto) : Boolean
}