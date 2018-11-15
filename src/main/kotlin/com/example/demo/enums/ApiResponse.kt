package com.example.demo.enums

enum class ApiResponse(private val response: String) {

    SaveSuccess("Data saved successfully"),
    SaveError("Data could not be saved"),
    UpdateSuccess("Data updated successfully"),
    UpdateError("Data updated error"),
    Success("Success"),
    Error("Error");

    fun getValue():String{
        return response
    }
}