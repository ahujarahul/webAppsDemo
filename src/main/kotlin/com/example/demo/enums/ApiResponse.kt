package com.example.demo.enums

enum class ApiResponse(private val response: String) {

    SaveSuccess("Data saved successfully"),
    SaveError("Data could not be saved"),
    Success("Success"),
    Error("Error");

    fun getValue():String{
        return response
    }
}