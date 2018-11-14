package com.rocklobstre.coolRecyclerview.ui.detail

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import com.rocklobstre.coolRecyclerview.R
import com.rocklobstre.coolRecyclerview.databinding.ActivityDetailBinding
import dagger.android.support.DaggerAppCompatActivity

class DetailUserActivity  : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        setupToolbar()
        val fragment = DetailUserFragment()
        replaceFragment(fragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content_main, fragment)
        fragmentTransaction.commit()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.includeToolbar?.toolbar)
        supportActionBar?.title = getString(R.string.app_name)
    }

}