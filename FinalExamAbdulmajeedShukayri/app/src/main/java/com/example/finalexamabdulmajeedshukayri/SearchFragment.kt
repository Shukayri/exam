package com.example.finalexamabdulmajeedshukayri

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalexamabdulmajeedshukayri.database.Uni_table
import kotlinx.coroutines.*
import org.json.JSONArray
import org.json.JSONException
import java.net.URL

class SearchFragment : Fragment() {

    private lateinit var rvMain: RecyclerView
    private lateinit var myAdapter: MyAdapter
    private val MyModel by lazy { ViewModelProvider(this).get( MyViewModel ::class.java) }
    private lateinit var searchET: EditText
    private lateinit var searchBtn: Button
    private lateinit var univs: ArrayList<UniversityData>


    var search=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view= inflater.inflate(R.layout.fragment_search_, container, false)

        univs = arrayListOf()
        rvMain =view.findViewById(R.id.rvMain)
        myAdapter = MyAdapter(this,univs)
        rvMain.adapter = myAdapter
        rvMain.layoutManager = LinearLayoutManager(requireContext())

        searchET =view.findViewById(R.id.UniversityNameET)
        searchBtn =view.findViewById(R.id.searchBtn)

        searchBtn.setOnClickListener {
            univs.clear()
            myAdapter.notifyDataSetChanged()
            search = searchET.text.toString()
            if(search.isNotEmpty()){
                requestAPI()
            }else{

                Toast.makeText(requireContext(), "Search field must not be empty", Toast.LENGTH_LONG).show()
            }

            searchET.text.clear()
            searchET.clearFocus()
        }

        return view
    }

    private fun requestAPI() {
        CoroutineScope(Dispatchers.IO).launch {
            val data = withContext(Dispatchers.Default) {
                    getUniversity()
                }
            if(data.isNotEmpty()){
                println(data)
                uniData(data)
            }
        }
    }

    private fun getUniversity(): String{
        var response = ""
        try{
            response = URL("http://universities.hipolabs.com/search?name=${search}")
                .readText(Charsets.UTF_8)
        }catch(e: Exception){
            println("ISSUE: $e")
        }
        return response
    }
    private suspend fun uniData(data: String){
        withContext(Dispatchers.Main) {
            Log.d("TAG","uniData: $data")
            try {


                val universities = JSONArray(data)
                for (i in 0 until universities.length()) {
                    val name = universities.getJSONObject(i).getString("name")
                    val country = universities.getJSONObject(i).getString("country")



                    univs.add(UniversityData(name, country))
                    myAdapter.notifyDataSetChanged()
                    //println("$name,$country")
                }
        }catch (e:Exception){
                Toast.makeText(requireContext(), "Not found", Toast.LENGTH_SHORT).show()

            }        }
    }



    fun saveToLocal(universityData: UniversityData) {
        val uni = Uni_table(0, universityData.name, universityData.country)
        MyModel.addUniversity(uni)
        Toast.makeText(requireContext(), "Data Saved ", Toast.LENGTH_SHORT).show()
    }

}