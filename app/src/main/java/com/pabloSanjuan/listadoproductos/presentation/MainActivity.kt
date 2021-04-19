package com.pabloSanjuan.listadoproductos.presentation

import android.os.Bundle
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import com.pabloSanjuan.listadoproductos.R
import com.pabloSanjuan.listadoproductos.databinding.ActivityMainBinding
import com.pabloSanjuan.listadoproductos.presentation.base.BaseActivity
import com.pabloSanjuan.listadoproductos.utils.ktx.setupWithNavController

class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>(),
    NavController.OnDestinationChangedListener {

    private var currentNavController: NavController? = null
    private lateinit var navGraphIds: List<Int>

    companion object {
        var currentMenuId: Int =  R.id.search_navigation
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigationBar()

        if (savedInstanceState != null) {
            binding.bottomNavigationMain.selectedItemId = currentMenuId
        }
    }

    private fun setupBottomNavigationBar() {
        navGraphIds = listOf(
            R.navigation.search_navigation,
            R.navigation.config_navigation
        )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = binding.bottomNavigationMain.setupWithNavController(
            navGraphIds,
            supportFragmentManager,
            R.id.fragment_main_host
        )

        // Whenever the selected controller changes, setup the action bar.
        controller.observe(
            this
        ) { navController ->
            // setupActionBarWithNavController(navController)
            currentNavController?.removeOnDestinationChangedListener(this)
            currentNavController = navController
            currentNavController?.addOnDestinationChangedListener(this)
            currentMenuId = navController.graph.id
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.navigateUp() ?: false
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        //hacer
    }
}