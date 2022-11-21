package com.messieyawo.ispaceroomcoroutineflowproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.messieyawo.ispaceroomcoroutineflowproject.data.repository.musicRepository
import com.messieyawo.ispaceroomcoroutineflowproject.databinding.ActivityMainBinding
import com.messieyawo.ispaceroomcoroutineflowproject.viewmodel.HomeFragmentViewModel
import com.messieyawo.ispaceroomcoroutineflowproject.viewmodel.HomeFragmentViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var navHostFragment :NavHostFragment
    private lateinit var binding:ActivityMainBinding

    lateinit var homeFragmentViewModel: HomeFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val musicRepository = musicRepository()
        val homeFragmentViewModelProvider = HomeFragmentViewModelProvider(application,musicRepository)
       homeFragmentViewModel = ViewModelProvider(this,homeFragmentViewModelProvider)[HomeFragmentViewModel::class.java]


        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.searchFragment,
                R.id.favoriteFragment
            )
        )

        binding.bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}