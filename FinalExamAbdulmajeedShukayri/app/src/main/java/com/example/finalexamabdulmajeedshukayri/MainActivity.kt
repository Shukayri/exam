package com.example.finalexamabdulmajeedshukayri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home -> {
                supportFragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView,Home_Screen())
                    .commit()
                return true
            }
            R.id.Universities -> {
                supportFragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView,SearchFragment())
                    .commit()
                return true
            }
            R.id.LocalDB -> {
                supportFragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView,Database_Fragment())
                    .commit()
                return true
            }
    }
        return super.onOptionsItemSelected(item)
    }
}