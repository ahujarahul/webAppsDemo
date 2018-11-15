package com.example.demo.repository

import com.example.demo.data_class.Name
import com.example.demo.data_class.Person
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

/*MongoRepository interface comes with many operations, including standard CRUD operations
 *You can define other queries as needed by simply declaring their method signature.
 *No need implementation, just one interface, and you have CRUD, thanks Spring Data
 */
interface PersonRepository : MongoRepository<Person, String> {

    //Spring Data MongoDB uses the MongoTemplate to execute the queries behind your find* methods.

    /*?0 - tells 0th param of function is our value
     *name.firstName - is hierarchy to search in db
     * db query - db.person.find({"name.firstName" : "Rahul"}).pretty()
     */
    @Query("{'name.firstName' : ?0 }")
    fun findByFirstName(firstName: String?): List<Person>

    fun findByName(name: Name?): List<Person>

    fun findFirstByName(name: Name?): Person?
}