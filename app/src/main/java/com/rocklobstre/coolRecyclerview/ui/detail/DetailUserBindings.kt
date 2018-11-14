package com.rocklobstre.coolRecyclerview.ui.users

import android.databinding.BindingAdapter
import android.support.design.widget.BaseTransientBottomBar
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rocklobstre.coolRecyclerview.domain.model.User
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.drawee.generic.RoundingParams
import com.rocklobstre.coolRecyclerview.ui.util.fade

/**
 * @author Matin Salehi on 31/12/2017.
 */
object DetailUserBindings {


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

    @JvmStatic
    @BindingAdapter("fadeView")
    fun fadeView(view: View, show: Boolean) {
        view.fade(show)
    }

    @JvmStatic
    @BindingAdapter("visible")
    fun setVisible(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }

    @JvmStatic
    @BindingAdapter("showLongMessage", "callback", requireAll = false)
    fun showLongMessage(view: View, text: String?, callback: BaseTransientBottomBar.BaseCallback<Snackbar>? = null) {
        text?.let {
            val snackbar = Snackbar.make(view, it, Snackbar.LENGTH_LONG)
            if (callback != null) snackbar.addCallback(callback)
            snackbar.show()
        }
    }
}