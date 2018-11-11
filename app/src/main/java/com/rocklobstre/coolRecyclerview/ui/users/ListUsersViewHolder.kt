package com.rocklobstre.coolRecyclerview.ui.users

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import com.rocklobstre.coolRecyclerview.databinding.ListUsersItemBinding

/**
 * @author Matin Salehi on 31/12/2017.
 */
class ListUsersViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding: ListUsersItemBinding? = DataBindingUtil.bind(view)

}