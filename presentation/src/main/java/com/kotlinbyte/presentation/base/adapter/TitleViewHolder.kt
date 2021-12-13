package com.kotlinbyte.presentation.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinbyte.domain.entity.base.Title
import com.kotlinbyte.presentation.databinding.MoviePosterBinding
import com.kotlinbyte.presentation.databinding.TvSeriesPosterBinding

abstract class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(title: Title)

    class Movie(itemView: View) : TitleViewHolder(itemView) {
        override fun bind(title: Title) {
            TODO("Not yet implemented")
        }

        companion object {
            fun from(parent: ViewGroup): Movie {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MoviePosterBinding.inflate(layoutInflater, parent, false)
                return Movie(binding.root)
            }
        }
    }

    class TvSeries(itemView: View) : TitleViewHolder(itemView) {
        override fun bind(title: Title) {
            TODO("Not yet implemented")
        }

        companion object {
            fun from(parent: ViewGroup): TvSeries {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TvSeriesPosterBinding.inflate(layoutInflater, parent, false)
                return TvSeries(binding.root)
            }
        }
    }
}


class DataBinder<T : TitleViewHolder> {

}