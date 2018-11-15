package com.example.demo.data_class

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/*
* MongoDB stores data in collections. Spring Data MongoDB will map the class Person into a collection called Person.
* If you want to change the name of the collection, you can use Spring Data MongoDB’s @Document annotation on the class.
*/
@Document("person")
class Person {

    @Id
    private var id: String? = null

    var name: Name? = null
    var isEarning: Boolean = false
    var employmentDetails: EmploymentDetails? = null
    var maritalStatus: String? = null
    var spouseName: String? = null
    var nationality: String? = null
    var address: Address? = null
}