package com.ber.android_hws.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ber.android_hws.database.AppDatabase
import com.ber.android_hws.repository.EmployeeRepository
import com.ber.android_hws.model.Employee
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Employee>>
    private val repository: EmployeeRepository

    init {
        val employeeDao = AppDatabase.getDatabase(application).employeeDao()
        repository = EmployeeRepository(employeeDao)
        readAllData = repository.readAlllData
    }

    fun addUser(employee: Employee) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addEmployee(employee)
        }
    }
}