package com.example.finalexamabdulmajeedshukayri

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.finalexamabdulmajeedshukayri.database.Uni_Dao
import com.example.finalexamabdulmajeedshukayri.database.Uni_table
import com.example.finalexamabdulmajeedshukayri.database.UniversityDB
import com.example.finalexamabdulmajeedshukayri.database.UniversityRep
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: UniversityRep
    private val Drac : LiveData<List<Uni_table>>

    init {
        val uniRepo = UniversityDB.getInstance(application).Uni_Dao()
        repo = UniversityRep(uniRepo)
        Drac = repo.univs
    }

    fun getUniversity() :LiveData<List<Uni_table>>{
        return Drac
    }

    fun addUniversity(university: Uni_table){
        CoroutineScope(Dispatchers.IO).launch {
            repo.addUniversity(university)
        }
    }

    fun deleteShow(university: Uni_table){
        CoroutineScope(Dispatchers.IO).launch {
            repo.deleteUniversity(university)
        }


    }
    //fun updateNote(note: Note) {
      //  db.collection("Notes")
            //.orderBy("timestamp")
            //.get()
            //.addOnSuccessListener {
                //for (document in it)
                //        db.collection("Notes").document(document.id)
              //              .update("noteText", note.noteText)
            //}
            //.addOnFailureListener {
              //  Log.d(TAG, "updateNote: Failed To Update")
            //}
    }



