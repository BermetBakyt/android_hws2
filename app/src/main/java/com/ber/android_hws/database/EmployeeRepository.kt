package com.ber.android_hws.database

import androidx.lifecycle.LiveData

class EmployeeRepository(private val employeeDao: EmployeeDao) {
    val readAlllData: LiveData<List<Employee>> = employeeDao.readAllData()

    suspend fun addEmployee(employee: Employee){
        employeeDao.addEmployee(employee)
    }
}