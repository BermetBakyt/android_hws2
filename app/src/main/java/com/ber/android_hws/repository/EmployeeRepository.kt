package com.ber.android_hws.repository

import androidx.lifecycle.LiveData
import com.ber.android_hws.database.EmployeeDao
import com.ber.android_hws.model.Employee

class EmployeeRepository(private val employeeDao: EmployeeDao) {
    val readAlllData: LiveData<List<Employee>> = employeeDao.readAllData()

    suspend fun addEmployee(employee: Employee){
        employeeDao.addEmployee(employee)
    }
}