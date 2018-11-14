package com.rocklobstre.coolRecyclerview.ui.users

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rocklobstre.coolRecyclerview.R
import com.rocklobstre.coolRecyclerview.databinding.ListUsersItemBinding
import com.rocklobstre.coolRecyclerview.domain.model.User
import com.rocklobstre.coolRecyclerview.ui.base.BaseAdapter

/**
 * @author Matin Salehi on 31/12/2017.
 */
class ListUsersAdapter(private val items: List<User>, private val callbacks: Callbacks? = null) :
        RecyclerView.Adapter<ListUsersAdapter.ViewHolder>() {

    interface Callbacks {
        fun onItemClick(view: View, item: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListUsersItemBinding = DataBindingUtil.inflate(inflater, R.layout.list_users_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.user = items[position]
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val binding: ListUsersItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener { callbacks?.onItemClick(it, items[adapterPosition]) }
        }
    }
}