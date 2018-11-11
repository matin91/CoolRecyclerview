package com.rocklobstre.coolRecyclerview.ui.users

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.rocklobstre.coolRecyclerview.R
import com.rocklobstre.coolRecyclerview.domain.model.User
import com.rocklobstre.coolRecyclerview.ui.base.BaseAdapter

/**
 * @author Matin Salehi on 31/12/2017.
 */
class ListUsersAdapter constructor(list: List<User>) : BaseAdapter<User>(list) {

    override fun onCreateViewHolderBase(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return ListUsersViewHolder(LayoutInflater
                .from(parent?.context)
                .inflate(R.layout.list_users_item, parent, false))
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder?, position: Int) {
        val binding = (holder as ListUsersViewHolder).binding
        val user = list[position]
        binding?.user = user
    }

}