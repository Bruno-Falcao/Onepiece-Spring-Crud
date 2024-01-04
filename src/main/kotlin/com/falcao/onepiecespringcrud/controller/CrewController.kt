package com.falcao.onepiecespringcrud.controller

import com.falcao.onepiecespringcrud.model.CrewMember
import com.falcao.onepiecespringcrud.model.HttpResponse
import com.falcao.onepiecespringcrud.model.dto.CrewMemberDto
import com.falcao.onepiecespringcrud.service.impl.CrewServiceImpl
import com.falcao.onepiecespringcrud.utils.ApiUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
@RestController
@RequestMapping("crew")
class CrewController(
private val crewService : CrewServiceImpl
) {

    @GetMapping
    fun findAllMembers() : ResponseEntity<HttpResponse> {
        return try {
            val findAll = crewService.findAll()
            ResponseEntity.status(HttpStatus.OK).body(
                HttpResponse.builder(
                    timeStamp = ApiUtils.getLocalDateNow(),
                    statusCode = HttpStatus.OK.value(),
                    status = HttpStatus.OK,
                    message = "Members found: ${findAll.size}",
                    data = mapOf("Members" to findAll)
                )
            )

        } catch (ex: Exception) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                HttpResponse.builder(
                    timeStamp = ApiUtils.getLocalDateNow(),
                    statusCode = HttpStatus.BAD_REQUEST.value(),
                    status = HttpStatus.BAD_REQUEST,
                    message = "Error finding members",
                    data = null
                )
            )
        }
    }

    @PostMapping
    fun saveCrewMember(@RequestBody newMember: CrewMember) : ResponseEntity<HttpResponse> {
        return try {
            crewService.saveCrewMember(newMember)
            ResponseEntity.status(HttpStatus.CREATED).body(
                HttpResponse.builder(
                    timeStamp = ApiUtils.getLocalDateNow(),
                    statusCode = HttpStatus.CREATED.value(),
                    status = HttpStatus.CREATED,
                    message = "New member recruited",
                    data = null
                )
            )
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body(
                HttpResponse.builder(
                    timeStamp = ApiUtils.getLocalDateNow(),
                    statusCode = HttpStatus.BAD_REQUEST.value(),
                    status = HttpStatus.BAD_REQUEST,
                    message = "New member recruited",
                    data = null
                )
            )
        }
    }

    @DeleteMapping
    fun deleteMember(@RequestParam(name = "id") memberId: String) : ResponseEntity<HttpResponse>{
        return try {
            crewService.deleteMember(memberId)
            ResponseEntity.status(HttpStatus.OK).body(
                HttpResponse.builder(
                    timeStamp = ApiUtils.getLocalDateNow(),
                    statusCode = HttpStatus.OK.value(),
                    status = HttpStatus.OK,
                    message = "Member kicked out",
                    data = null
                )
            )
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body(
                HttpResponse.builder(
                    timeStamp = ApiUtils.getLocalDateNow(),
                    statusCode = HttpStatus.BAD_REQUEST.value(),
                    status = HttpStatus.BAD_REQUEST,
                    message = "Not able to kick the member",
                    data = null
                )
            )
        }
    }

    @PutMapping
    fun updateMemberInfo(@RequestBody crewMember: CrewMemberDto) : ResponseEntity<HttpResponse> {
        return try {
            crewService.updateMember(crewMember)
            ResponseEntity.status(HttpStatus.OK).body(
                HttpResponse.builder(
                    timeStamp = ApiUtils.getLocalDateNow(),
                    statusCode = HttpStatus.OK.value(),
                    status = HttpStatus.OK,
                    message = "Member info updated",
                    data = null
                )
            )
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body(
                HttpResponse.builder(
                    timeStamp = ApiUtils.getLocalDateNow(),
                    statusCode = HttpStatus.BAD_REQUEST.value(),
                    status = HttpStatus.BAD_REQUEST,
                    message = "Unable to update member info",
                    data = null
                )
            )
        }
    }
}

