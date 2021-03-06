package com.example.demo.controller

import com.example.demo.data_class.Address
import com.example.demo.data_class.EmploymentDetails
import com.example.demo.data_class.Name
import com.example.demo.data_class.Person
import com.example.demo.enums.ApiResponse
import com.example.demo.repository.PersonRepository
import com.example.demo.repository.repository_impl.PersonRepositoryCustomImpl
import com.example.demo.utils.IdGeneration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class PersonController {

    //autowire an instance of PersonRepository below. Spring Data MongoDB dynamically creates a proxy and injects it here
    @Autowired
    lateinit var personRepository: PersonRepository

    //@Inject -- same as @Autowired
    @Autowired
    lateinit var personRepositoryCustomImpl: PersonRepositoryCustomImpl

    @PostMapping("/save-person")
    fun savePerson(person: Person?): String{

//        var name = Name()
//        name.firstName = "Sagar"
//        name.lastName = "Gangs"
//        person?.name = name
//
//        person?.isEarning = true
//
//        var employmentDetails = EmploymentDetails()
//        employmentDetails.companyName = "PTC"
//        employmentDetails.designation = "tester"
//        employmentDetails.employmentType = "salaried"
//        employmentDetails.income = 50000
//        employmentDetails.totalYearsOfExperience = 4
//        employmentDetails.yearsOfExperienceInThisCompany = 2
//        person?.employmentDetails = employmentDetails
//
//        person?.maritalStatus = "Single"
//        person?.nationality = "Indian"
//
//        var address = Address()
//        address.addressLine1 = "address line 1..."
//        address.addressLine2 = "address line 2..."
//        address.buildingName = "building name..."
//        address.city = "Pune"
//        address.state = "MH"
//        address.pincode = 411040
//        person?.address = address

        person?.id = IdGeneration.generatePersonId(personRepository.count())

        person?.let {
            var dbSuccess = personRepository.save(person)

            if (dbSuccess.name?.firstName.equals(person.name?.firstName, true)){
                return ApiResponse.SaveSuccess.getValue()
            }
        }

        return ApiResponse.SaveError.getValue()
    }

    @PostMapping("/search-person-by-first-name")
    fun searchPersonByFirstName(@RequestBody name: Name?): List<Person>{
        return personRepository.findByFirstName(name?.firstName)
    }

    @PostMapping("/search-by-name")
    fun searchPersonByName(@RequestBody name: Name?): List<Person>{
        return personRepository.findByName(name)
    }

    @PostMapping("/get-person-marital-status")
    fun getPersonMaritalStatus(@RequestBody name: Name?): String? {
        return personRepository.findFirstByName(name)?.maritalStatus
    }

    @PostMapping("/update-person-employment")
    fun updatePersonEmployment(@RequestBody name: Name?): String? {
        return personRepositoryCustomImpl.updateEmploymentByName(name, "Senior Lead", 170000)
    }

    @GetMapping("/fetch-all-person")
    fun fetchAllPerson(): List<Person>{
        return personRepository.findAll()
    }
}