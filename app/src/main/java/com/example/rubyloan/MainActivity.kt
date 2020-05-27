package com.example.rubyloan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_providers.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        setUpViewPager()
    }

    private fun setUpViewPager() {
        val adapter = MyViewPageStateAdapter(supportFragmentManager)
        adapter.addFragment(ProvidersFragment(), "Providers")
        adapter.addFragment(HistoryFragment(), "History")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }


}

