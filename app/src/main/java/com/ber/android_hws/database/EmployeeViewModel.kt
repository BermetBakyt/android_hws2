package com.ber.android_hws.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ber.android_hws.database.AppDatabase.Companion.getDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<Employee>>
    private val repository: EmployeeRepository

    init {
        val employeeDao = Employee.getDatabase(application).employeeDao()
        repository = EmployeeRepository(employeeDao)
        readAllData = repository.readAllData
    }
    fun addEmployee(employee: Employee) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addEmployee(employee)
        }
    }
}