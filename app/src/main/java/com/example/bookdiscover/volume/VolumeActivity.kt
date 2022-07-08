package com.example.bookdiscover.volume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.bookdiscover.R
import com.example.bookdiscover.network.Volume
import com.example.bookdiscover.result.ResultViewModel

class VolumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)

        // Navigation Controllers
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.volume_fragment_container) as androidx.navigation.fragment.NavHostFragment
        val navController = navHostFragment.navController
        // Show a title in the app bar based off of the destination's label, and display the Up button whenever you're not on a top-level destination.
        setupActionBarWithNavController(navController)

//        val resultViewModel: ResultViewModel by viewModels()
        val volumeViewModel: VolumeViewModel by viewModels()
        val selectedVolume = VolumeHolder.getVolume()


//        val volumeInfo = LinkedHashMap<String, String>()
//        volumeInfo["author"] = "me"
//        volumeInfo["title"] = "my title"
//        val saleInfo = LinkedHashMap<String, String>()
//        saleInfo["profit"] = "5000"
//        val sampleVolume = Volume("fake_id", volumeInfo, null, saleInfo)
        volumeViewModel.initialize(selectedVolume)



    }
}