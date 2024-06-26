package com.alekseichisitiakov.autolapkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.commit
import com.alekseichisitiakov.autolapkeeper.car.CarRacingFragment
import com.alekseichisitiakov.autolapkeeper.databinding.ActivityMainBinding
import com.alekseichisitiakov.autolapkeeper.kart.KartingFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.reset_car_racing -> {
                true
            }
            R.id.reset_kart_racing -> {
                true
            }
            R.id.reset_all -> {
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun onKartingClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, KartingFragment())
        }
        return true
    }

    private fun onCarRacingClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, CarRacingFragment())
        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.nav_car_racing -> onCarRacingClicked()
        R.id.nav_karting -> onKartingClicked()
        else -> false
    }
}