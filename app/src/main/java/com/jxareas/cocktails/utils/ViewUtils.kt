package com.jxareas.cocktails.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

internal inline fun <reified T : ImageView> T.setImage(url: String) =
    Unit.also {
        Glide.with(context)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this)
    }


internal inline infix fun <reified VB : ViewBinding> ViewGroup.bind(
    crossinline bindingInflater: LayoutInflater.(parent: ViewGroup, attachToParent: Boolean) -> VB
): VB = LayoutInflater.from(context).let { layoutInflater ->
    bindingInflater.invoke(layoutInflater, this, false)
}
