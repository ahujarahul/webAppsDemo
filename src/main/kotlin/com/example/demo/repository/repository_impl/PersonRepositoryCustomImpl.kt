package com.example.demo.repository.repository_impl

import com.example.demo.data_class.Name
import com.example.demo.enums.ApiResponse
import com.example.demo.repository.PersonRepository
import com.example.demo.repository.PersonRepositoryCustom
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

//@Service -- same as @Component
@Component
class PersonRepositoryCustomImpl: PersonRepositoryCustom {

    @Autowired
    lateinit var personRepository: PersonRepository


    override fun updateEmploymentByName(name: Name?, designation: String?, salary: Long?): String? {
        var personToUpdate = personRepository.findFirstByName(name)

        personToUpdate?.let {
            personToUpdate.employmentDetails?.designation = designation
            personToUpdate.employmentDetails?.income = salary
            personRepository.save(personToUpdate)

            return ApiResponse.UpdateSuccess.getValue()
        }

        return ApiResponse.UpdateError.getValue()
    }
}