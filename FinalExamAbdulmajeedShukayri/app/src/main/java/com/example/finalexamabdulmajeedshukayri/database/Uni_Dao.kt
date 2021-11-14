package com.example.finalexamabdulmajeedshukayri.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface Uni_Dao {
    @Query("Select * from universitytable order by id")
    fun getUniversity() : LiveData<List<Uni_table>>

    @Insert
    fun addUniversity(tvShow:Uni_table)

    @Update
    fun updateUniversity(tvShow: Uni_table)

    @Delete
    fun deleteUniversity(tvShow:Uni_table)
}