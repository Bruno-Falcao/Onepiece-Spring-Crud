package com.falcao.onepiecespringcrud.repository

import com.falcao.onepiecespringcrud.model.CrewMember
import org.springframework.data.mongodb.repository.MongoRepository

interface CrewRepository : MongoRepository<CrewMember, String> {
}
