package com.example.marvel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.smartlook.android.core.api.Smartlook


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)

//        val config = UXConfig.Builder("yourAppKey")
//            .enableAutomaticScreenNameTagging(true)
//            .enableImprovedScreenCapture(true)
//            .build()
//        UXCam.startWithConfiguration(config)
//        Log.d("teste", "uxcam $config")

        val smartlook = Smartlook.instance
        smartlook.preferences.projectKey = "${BuildConfig.SMART_SECRET}"
        smartlook.start()

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}