package com.example.demo.repository

import com.example.demo.data_class.Name

interface PersonRepositoryCustom {

    fun updateEmploymentByName(name: Name?, designation: String?, salary: Long?): String?
}