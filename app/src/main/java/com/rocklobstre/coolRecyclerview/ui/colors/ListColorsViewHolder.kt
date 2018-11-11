package com.rocklobstre.coolRecyclerview.ui.colors

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import com.rocklobstre.coolRecyclerview.databinding.ListColorsItemBinding

/**
 * @author Matin Salehi on 31/12/2017.
 */
class ListColorsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding: ListColorsItemBinding? = DataBindingUtil.bind(view)

}