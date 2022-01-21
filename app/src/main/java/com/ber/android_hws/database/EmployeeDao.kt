package com.ber.android_hws.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM employee_data")
    fun getAll(): List<Employee>

    @Query("SELECT * FROM employee_data WHERE id = :id")
    fun getById(id: Long): Employee

    @Query("SELECT * FROM employee_data ORDER BY id DESC LIMIT 1 ")
    fun getLast(): Employee

    @Insert
    fun insert(employee: Employee)

    @Update
    fun update(employee: Employee)

    @Delete
    fun delete(employee: Employee)
}
