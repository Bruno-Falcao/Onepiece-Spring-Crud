package com.falcao.onepiecespringcrud.service.impl

import com.falcao.onepiecespringcrud.model.CrewMember
import com.falcao.onepiecespringcrud.model.dto.CrewMemberDto
import com.falcao.onepiecespringcrud.repository.CrewRepository
import com.falcao.onepiecespringcrud.service.CrewService
import org.springframework.stereotype.Service

@Service
class CrewServiceImpl(
    private val crewRepository: CrewRepository
) : CrewService {

    override fun findAll() = crewRepository.findAll().map {
        CrewMemberDto(
            id = it.id,
            name = it.name,
            age = it.age
        )
    }.toMutableList()

    override fun saveCrewMember(crew: CrewMember): String {
        crewRepository.save(crew)
        return "Crew member saved"
    }

    override fun deleteMember(memberId: String) {
        crewRepository.deleteById(memberId)
    }

    override fun updateMember(memberDto: CrewMemberDto) : Boolean{
        val existingMember = memberDto.id?.let { crewRepository.findById(it).orElseThrow() }
        existingMember?.apply {
            name = memberDto.name
            age = memberDto.age
            crewRepository.save(existingMember)
            return true
        }
        return false
    }
}
