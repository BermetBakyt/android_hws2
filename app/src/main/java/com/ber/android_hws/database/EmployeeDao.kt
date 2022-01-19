package com.ber.android_hws.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEmployee(employee: Employee)

    @Query("SELECT * FROM employee_data ORDER BY  id ASC")
    fun readAllData(): LiveData<List<Employee>>

}
