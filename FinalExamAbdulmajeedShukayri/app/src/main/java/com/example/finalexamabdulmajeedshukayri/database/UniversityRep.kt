package com.example.finalexamabdulmajeedshukayri.database

import androidx.lifecycle.LiveData

class UniversityRep (private val Uni_Dao: Uni_Dao) {

    val univs: LiveData<List<Uni_table>> = Uni_Dao.getUniversity()

    fun addUniversity(university: Uni_table){
        Uni_Dao.addUniversity(university)
    }

    fun updateUniversity(university: Uni_table){
        Uni_Dao.updateUniversity(university)
    }

    fun deleteUniversity(university: Uni_table){
        Uni_Dao.deleteUniversity(university)
    }
}