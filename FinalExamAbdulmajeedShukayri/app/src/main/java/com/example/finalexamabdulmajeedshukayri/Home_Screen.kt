package com.example.finalexamabdulmajeedshukayri

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
class Home_Screen : Fragment() {
    private lateinit var btAPI: Button
    private lateinit var btDB: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home__screen, container, false)
        btAPI =view.findViewById(R.id.browseBtn)
        btDB =view.findViewById(R.id.localDbBtn)

        btAPI.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView,SearchFragment())?.commit()
        }

        btDB.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView,Database_Fragment())?.commit()

        }
        return view
    }

}