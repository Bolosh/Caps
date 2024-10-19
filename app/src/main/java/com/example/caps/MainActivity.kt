package com.example.caps

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button
    private lateinit var b5: Button

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        b1 = findViewById(R.id.L1)
        b2 = findViewById(R.id.L2)
        b3 = findViewById(R.id.L3)
        b4 = findViewById(R.id.L4)
        b5 = findViewById(R.id.L5)

        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = FragmentAdapter(this)
        viewPager.currentItem = 2

        b1.setOnClickListener { viewPager.currentItem = 0 }
        b2.setOnClickListener { viewPager.currentItem = 1 }
        b3.setOnClickListener { viewPager.currentItem = 2 }
        b4.setOnClickListener { viewPager.currentItem = 3 }
        b5.setOnClickListener { viewPager.currentItem = 4 }

    }

}

class FragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val fragments = listOf(
        HelpFragment(),
        HomeFragment(),
        MainFragment(),
        UserFragment(),
        SettingsFragment()
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}
