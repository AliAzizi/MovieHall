package com.kotlinbyte.domain_android_overlay.extension

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.ViewHolder.setOnClickListener(onClick: (index: Int) -> Unit) {
    itemView.setOnClickListener {
        if (adapterPosition != RecyclerView.NO_POSITION) {
            onClick(adapterPosition)
        }
    }
}

fun RecyclerView.ViewHolder.setOnClickListener(@IdRes resId: Int, onClick: (index: Int) -> Unit) {
    itemView.findViewById<View>(resId).setOnClickListener {
        if (adapterPosition != RecyclerView.NO_POSITION) {
            onClick(adapterPosition)
        }
    }
}


fun RecyclerView.ViewHolder.setOnLongClickListener(onLongClick: (index: Int) -> Unit) {
    itemView.setOnLongClickListener {
        if (adapterPosition != RecyclerView.NO_POSITION) {
            onLongClick(adapterPosition)
        }
        true
    }
}