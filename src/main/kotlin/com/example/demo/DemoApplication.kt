package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

    /*
    * As Spring Boot looks for a public static main method, we need to define this in Kotlin. It could be done with the
    * @JvmStatic annotation and a companion object but here we prefer using a top-level function defined outside Application
    * class since it leads to more concise and clean code.
    * */

    fun main(args: Array<String>) {
        /*
        * use of runApplication top level function. runApplication<DemoApplication>(*args) is Kotlin idiomatic
        * alternative to SpringApplication.run(DemoApplication::class.java, *args)
        */
        runApplication<DemoApplication>(*args)
    }

