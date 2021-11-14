package com.example.finalexamabdulmajeedshukayri.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Uni_table::class], version = 2, exportSchema = false)
abstract class UniversityDB: RoomDatabase() {

    companion object {
        var instance: UniversityDB? = null;
        fun getInstance(ctx: Context): UniversityDB {
            if (instance != null) {
                return instance as UniversityDB;
            }
            instance = Room.databaseBuilder(ctx, UniversityDB::class.java, "University")
                .run { allowMainThreadQueries() }.build();
            return instance as UniversityDB;
        }
    }

    abstract fun Uni_Dao(): Uni_Dao;
}