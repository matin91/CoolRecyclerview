package com.rocklobstre.coolRecyclerview.ui.colors

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.rocklobstre.coolRecyclerview.domain.model.Color

/**
 * @author  Matin Salehi on 31/12/2017.
 */
object ListColorsBindings {

    @JvmStatic
    @BindingAdapter("load_colors")
    fun loadColors(recyclerView: RecyclerView, colors: List<Color>?) {
        recyclerView.adapter = if (colors != null) ListColorsAdapter(colors) else ListColorsAdapter(emptyList())
    }

    @JvmStatic
    @BindingAdapter("load_color_value")
    fun loadColorValue(imageView: ImageView, color: Color?) {
        imageView.setBackgroundColor(android.graphics.Color.parseColor(color?.color))
    }

}