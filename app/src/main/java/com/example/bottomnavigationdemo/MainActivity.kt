package com.example.bottomnavigationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView:BottomNavigationView=findViewById(R.id.bottomNavigationView)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
//        val navController:NavController=Navigation.findNavController(this ,R.id.fragmentContainerView)
        val navController= navHostFragment?.findNavController() as NavController
//法1        val configuration:AppBarConfiguration= AppBarConfiguration(navController.graph)
//法2        val configuration:AppBarConfiguration= AppBarConfiguration.Builder(R.id.firstFragment,R.id.secondFragment,R.id.thirdFragment).build()
        val configuration:AppBarConfiguration= AppBarConfiguration.Builder(bottomNavigationView.menu).build()

        NavigationUI.setupActionBarWithNavController(this,navController,configuration)
        NavigationUI.setupWithNavController(bottomNavigationView,navController)

    }
}