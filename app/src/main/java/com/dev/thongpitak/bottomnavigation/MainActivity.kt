package com.dev.thongpitak.bottomnavigation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.dev.thongpitak.bottomnavigation.fragment.oneFragment
import com.dev.thongpitak.bottomnavigation.fragment.threeFragment
import com.dev.thongpitak.bottomnavigation.fragment.twoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val one = oneFragment.newInstance()
                openFragment(one)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val two = twoFragment.neeInsatnce()
                openFragment(two)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                val three = threeFragment.newInstance()
                openFragment(three)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val one = oneFragment.newInstance()
        openFragment(one)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frag, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
