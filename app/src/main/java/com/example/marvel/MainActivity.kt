package com.example.marvel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.marvel.ui.MarvelDetailFragment
import com.smartlook.android.core.api.Smartlook
import com.smartlook.android.core.video.annotation.RenderingMode


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
        //Smartlook.instance.preferences.renderingMode = RenderingMode.WIREFRAME
        Smartlook.instance.state.status.isRecording

        smartlook.start()
        Log.d("smartlook start", "${smartlook.start().toString()}")
        Log.d("smartlook log", "${smartlook.log.toString()}")
        Log.d("smartlook recordingMask", "${smartlook.recordingMask}")
        Log.d("smartlook sensitivity", "${smartlook.sensitivity}")
        Log.d("smartlook user", "${smartlook.user}")
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}