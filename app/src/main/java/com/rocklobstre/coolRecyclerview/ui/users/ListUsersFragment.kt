package com.rocklobstre.coolRecyclerview.ui.users

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
import com.rocklobstre.coolRecyclerview.databinding.FragmentListUsersBinding
import com.rocklobstre.coolRecyclerview.domain.model.User
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * @author Matin Salehi on 31/12/2017.
 */
class ListUsersFragment : DaggerFragment(), ListUsersAdapter.Callbacks {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var navigator: Navigator

    private lateinit var viewModel: ListUsersViewModel

    private lateinit var binding: FragmentListUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListUsersViewModel::class.java)

        observeLoadingStatus()
        observeResponse()

        val params = kotlin.Pair(1, 10)
        viewModel.loadData(params)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_users, container, false)
        binding.callbacks = this
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.swipeContainer.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {
            override fun onRefresh() {
                viewModel.loadData();
            }
        })
        return binding.root
    }

    private fun observeResponse() {
        viewModel.loadingStatus.observe(
                this,
                Observer { isLoading -> binding.swipeContainer.isRefreshing = isLoading ?: false })
    }

    private fun observeLoadingStatus() {
        viewModel.response.observe(
                this,
                Observer { response ->
                    if(response != null && response.status == Status.SUCCESS) {
                        binding.users = response.data
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

    override fun onItemClick(view: View, item: User) {
        val cardView = view.findViewById<View>(R.id.cardview)
        val imageView = view.findViewById<View>(R.id.image_thumbnail)
        val nameView = view.findViewById<View>(R.id.text_name)
        val sharedViews = arrayOf(
                Pair(cardView, ViewCompat.getTransitionName(cardView)),
                Pair(imageView, ViewCompat.getTransitionName(imageView)),
                Pair(nameView, ViewCompat.getTransitionName(nameView)))
        activity?.let { navigator.navigateToDetail(it, item.id, sharedViews) }
    }

}