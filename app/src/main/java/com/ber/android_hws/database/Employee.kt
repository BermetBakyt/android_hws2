package com.ber.android_hws.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee_data")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id: Long?= null,
    val name: String,
    val company: String,
    val salary: Int
)