package com.example.navigationcomponentapplication.activity.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout.SimpleDrawerListener
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.navigationcomponentapplication.R
import com.example.navigationcomponentapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() /*NavigationView.OnNavigationItemSelectedListener*/ {

    private lateinit var binding: ActivityMainBinding

    private var navController: NavController? = null

    companion object {
        private const val END_SCALE = 0.9f

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mcvFragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        val bottomNavigationView = binding.bottomNavigation
        val navigationView = binding.navigationView

        NavigationUI.setupWithNavController(bottomNavigationView, navController)
        NavigationUI.setupWithNavController(navigationView, navController)

        animateNavigationDrawer()
       // navigationView.setNavigationItemSelectedListener(this);


    }

    private fun animateNavigationDrawer() {

        binding.drawerLayout.addDrawerListener(object : SimpleDrawerListener() {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                val diffScaledOffset: Float = slideOffset * (1 - END_SCALE)
                val offsetScale = 1 - diffScaledOffset
                binding.mainContainer.scaleX = offsetScale
                binding.mainContainer.scaleY = offsetScale
                val xOffset = drawerView.width * slideOffset
                val xOffsetDiff: Float = binding.mainContainer.width * diffScaledOffset / 2
                val xTranslation = xOffset - xOffsetDiff
                binding.mainContainer.translationX = xTranslation
            }
        })
    }



   /* override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mnBlurLinear -> {
                Toast.makeText(this@MainActivity, "BlurLinear", Toast.LENGTH_SHORT).show()
            }
            R.id.mnBlurOff -> Toast.makeText(this, "BlurOff", Toast.LENGTH_SHORT).show()
            R.id.mnBlurOn -> Toast.makeText(this, "BlurOn", Toast.LENGTH_SHORT).show()

            R.id.mnBookmark ->navController?.navigate(R.id.mnBookmark)
            R.id.mnBookmarkAdd -> Toast.makeText(this, "BookmarkAdd", Toast.LENGTH_SHORT).show()
            R.id.mnBookmarkBorder -> Toast.makeText(this, "BookmarkBorder", Toast.LENGTH_SHORT).show()

            R.id.mnBrightnessLow -> Toast.makeText(this, "BlurLinear", Toast.LENGTH_SHORT).show()
            R.id.mnBrightnessHigh -> Toast.makeText(this, "BrightnessHigh", Toast.LENGTH_SHORT).show()
            R.id.mnBrightnessMedium -> Toast.makeText(this, "BrightnessMedium", Toast.LENGTH_SHORT).show()


        }
        return true

    }*/



}