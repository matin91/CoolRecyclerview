package com.rocklobstre.coolRecyclerview.ui.detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.util.Pair
import android.support.v4.view.ViewCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andremion.theatre.navigation.Navigator
import com.rocklobstre.coolRecyclerview.BuildConfig
import com.rocklobstre.coolRecyclerview.R
import com.rocklobstre.coolRecyclerview.data.remote.response.Status
import com.rocklobstre.coolRecyclerview.databinding.FragmentDetailUserBinding
import com.rocklobstre.coolRecyclerview.domain.model.User
import com.rocklobstre.coolRecyclerview.ui.users.DetailUserViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * @author Matin Salehi on 31/12/2017.
 */
class DetailUserFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var navigator: Navigator

    private lateinit var viewModel: DetailUserViewModel

    private lateinit var binding: FragmentDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailUserViewModel::class.java)

        observeLoadingStatus()
        observeResponse()

        val userId = navigator.getUser(this.requireActivity())
        viewModel.loadData(userId)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_user, container, false)
        return binding.root
    }

    private fun observeResponse() {
//        viewModel.loadingStatus.observe(
//                this,
//                Observer { isLoading -> binding.swipeContainer.isRefreshing = isLoading ?: false })
    }

    private fun observeLoadingStatus() {
        viewModel.response.observe(
                this,
                Observer { response ->
                    if(response != null && response.status == Status.SUCCESS) {
                        binding.user = response.data
                        binding.executePendingBindings()
                    } else {
                        if ((response != null && response.status == Status.ERROR) && BuildConfig.DEBUG) {
                            Log.e("get users error", response.error.toString())
                        }
                        Snackbar.make(binding.root, R.string.load_data_error, Snackbar.LENGTH_LONG).show()
                    }
                }
        )
    }

}