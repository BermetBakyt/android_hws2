package com.ber.android_hws.database

import androidx.room.*

interface SeriesDao {

    @Query("SELECT * FROM SeriesEntity")
    fun getAll(): List<SeriesDao>

    @Query("SELECT * FROM SeriesEntity WHERE id = :id")
    fun getById(id: Long?) : SeriesEntity

    @Insert
    fun insert(character: SeriesEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(characters: List<SeriesEntity>)

    @Update
    fun update(character: SeriesEntity)

    @Delete
    fun delete(character: SeriesEntity)
}