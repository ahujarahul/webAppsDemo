package com.example.demo.controller

import com.example.demo.data_class.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

/*GreetingController serves requests of the form /greeting?name={value} and returns a JSON object representing
*an instance of Greeting
*/
@RestController
class GreetingController {
    //value that will be updated atomically
    private val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting?{
        return Greeting(counter.incrementAndGet(), "Hello, $name. How are you doing today?")
    }

    @GetMapping("/greet-me")
    fun greetMe(@RequestParam(value = "name", defaultValue = "World") name: String): String?{
        return Greeting(counter.incrementAndGet(), "Hello, $name. How are you doing today?").message
    }
}