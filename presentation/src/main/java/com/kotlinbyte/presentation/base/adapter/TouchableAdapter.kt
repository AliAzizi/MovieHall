package com.kotlinbyte.presentation.base.adapter

import androidx.recyclerview.widget.RecyclerView
import com.kotlinbyte.domain.entity.base.Title

abstract class TouchableAdapter<VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {
    val onClickListener: (Title) -> Unit = { _ -> }
    val onLongClickListener: (Title) -> Unit = { _ -> }
}