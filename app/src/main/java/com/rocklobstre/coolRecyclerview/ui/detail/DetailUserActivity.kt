package com.rocklobstre.coolRecyclerview.ui.detail

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.rocklobstre.coolRecyclerview.R
import com.rocklobstre.coolRecyclerview.databinding.ActivityMainBinding
import com.rocklobstre.coolRecyclerview.ui.colors.ListColorsFragment
import com.rocklobstre.coolRecyclerview.ui.common.ViewPagerAdapter
import com.rocklobstre.coolRecyclerview.ui.users.DetailUserFragment
import dagger.android.support.DaggerAppCompatActivity

class DetailUserActivity  : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupToolbar()
        setupTabs()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.includeToolbar?.toolbar)
        supportActionBar?.title = getString(R.string.app_name)
    }

    private fun setupTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(DetailUserFragment(), getString(R.string.users))
        adapter.addFragment(ListColorsFragment(), getString(R.string.colors))

        binding.viewPager.adapter = adapter
        binding.includeToolbar?.tabs?.setupWithViewPager(binding.viewPager)
    }

}