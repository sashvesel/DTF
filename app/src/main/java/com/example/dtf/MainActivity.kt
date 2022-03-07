package com.example.dtf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dtf.FaceController.MLActivity
import com.example.dtf.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
        R.layout.activity_main)

        val navController= this.findNavController(R.id.navHostFragment)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNavigationView.setupWithNavController(navController)
        binding.bottomNavView.background = null
        binding.bottomNavView.menu.getItem(1).isEnabled = false

        binding.fab.setOnClickListener { startDetect() }

    }

    private fun startDetect() {
        val i = Intent(this, MLActivity::class.java)
        startActivity(i)
    }


}