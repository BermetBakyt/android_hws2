package com.ber.android_hws.database

import androidx.lifecycle.LiveData


class EmployeeRepository(private val employeeDao: EmployeeDao) {
    val readAllData: LiveData<List<Employee>> = employeeDao.readAllData()

    suspend fun addEmployee(employee: Employee){
        employeeDao.addUser(employee)
    }
}