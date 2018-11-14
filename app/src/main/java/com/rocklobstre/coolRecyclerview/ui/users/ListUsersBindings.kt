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
    @BindingAdapter("load_users")
    fun loadUsers(recyclerView: RecyclerView, users: List<User>?) {
        recyclerView.adapter = if (users != null) ListUsersAdapter(users) else ListUsersAdapter(emptyList())
    }

    @JvmStatic
    @BindingAdapter("load_user_avatar")
    fun loadUserAvatar(simpleDraweeView: SimpleDraweeView, user: User?) {
        val roundingParams = RoundingParams.fromCornersRadius(5f)
        roundingParams.roundAsCircle = true

        simpleDraweeView.hierarchy.roundingParams = roundingParams
        simpleDraweeView.setImageURI(user?.avatar)
    }

    @JvmStatic
    @BindingAdapter("loadUrl")
    fun loadUrl(imageView: ImageView, url: String?) {
        url?.let {
            Glide.with(imageView.context)
                    .load(it)
                    .apply(RequestOptions.noTransformation())
                    .into(imageView)
        }
    }

}