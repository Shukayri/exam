package com.example.finalexamabdulmajeedshukayri

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalexamabdulmajeedshukayri.database.Uni_table

class Database_Fragment : Fragment() {
    private val myModel by lazy { ViewModelProvider(this).get( MyViewModel ::class.java) }
    private lateinit var rvMain: RecyclerView
    private lateinit var mydbAdapter: MydbAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_database_, container, false)

        myModel.getUniversity().observe(viewLifecycleOwner,{
                Shows -> mydbAdapter.setUniversity(Shows)
        })

        rvMain = view.findViewById(R.id.rvDB)
        mydbAdapter = MydbAdapter(this)
        rvMain.adapter = mydbAdapter
        rvMain.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    fun delete(univs: Uni_table){
        myModel.deleteShow(univs)
        Toast.makeText(requireContext(), "University Deleted ", Toast.LENGTH_SHORT).show()
    }

    //fun updateNote(note: Note) {
      //  myModel.updateNote(note)
    //}

}