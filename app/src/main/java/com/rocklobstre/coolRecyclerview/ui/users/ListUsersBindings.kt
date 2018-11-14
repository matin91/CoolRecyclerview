package com.rocklobstre.coolRecyclerview.ui.users

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rocklobstre.coolRecyclerview.domain.model.User
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.drawee.generic.RoundingParams

/**
 * @author Matin Salehi on 31/12/2017.
 */
object ListUsersBindings {

    @JvmStatic
    @BindingAdapter("load_users", "callbacks", requireAll = false)
    fun loadUsers(recyclerView: RecyclerView, users: List<User>?, callbacks: ListUsersAdapter.Callbacks?) {
        recyclerView.adapter = if (users != null) ListUsersAdapter(users, callbacks) else ListUsersAdapter(emptyList(), callbacks)

    }

}