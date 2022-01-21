package com.ber.android_hws.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "employee_data")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val company: String,
    val salary: Int
)