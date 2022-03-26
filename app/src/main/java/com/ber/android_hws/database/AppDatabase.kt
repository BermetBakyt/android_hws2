package com.ber.android_hws.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@TypeConverters(TypeConverter::class)
@Database(entities = [SeriesEntity::class], version = 2)
abstract class AppDatabase: RoomDatabase() {

     abstract fun characterDao(): SeriesDao
}