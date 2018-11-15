package com.example.demo.utils

class IdGeneration {

    companion object {
        fun generatePersonId(dbCount: Long?): String?{
            var id = dbCount
            id = id?.plus(1)
            return "person_$id"
        }
    }
}