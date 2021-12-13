package com.kotlinbyte.presentation.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinbyte.domain.entity.base.Title
import com.kotlinbyte.domain_android_overlay.extension.setOnClickListener
import com.kotlinbyte.domain_android_overlay.extension.setOnLongClickListener
import java.lang.IllegalArgumentException
import kotlin.properties.Delegates

class TitleAdapter : RecyclerView.Adapter<TitleViewHolder>() {

    internal val collection: List<Title> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    val onClickListener: (Title) -> Unit = { _ -> }
    val onLongClickListener: (Title) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        Title.Type.Movie.ordinal -> TitleViewHolder.Movie.from(parent).also(::touchAble)
        Title.Type.TVSeries.ordinal -> TitleViewHolder.TvSeries.from(parent).also(::touchAble)
        else -> throw IllegalArgumentException()
    }


    private fun touchAble(holder: TitleViewHolder): TitleViewHolder {
        holder.setOnClickListener {
            onClickListener(collection[it])
        }
        holder.setOnLongClickListener {
            onLongClickListener(collection[it])
        }
        return holder
    }


    override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {
        holder.bind(collection[position])
    }

    override fun getItemViewType(position: Int): Int = when (collection[position].type) {
        Title.Type.Movie -> Title.Type.Movie.ordinal
        Title.Type.TVSeries -> Title.Type.TVSeries.ordinal
        else -> -1
    }

    override fun getItemCount(): Int = collection.size

}