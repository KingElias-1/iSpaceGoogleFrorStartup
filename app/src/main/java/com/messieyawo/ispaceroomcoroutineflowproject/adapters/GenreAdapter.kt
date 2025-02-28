package com.messieyawo.ispaceroomcoroutineflowproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Genres
import com.messieyawo.ispaceroomcoroutineflowproject.databinding.GenreItemBinding
import com.messieyawo.ispaceroomcoroutineflowproject.fragments.HomeFragment

class GenreAdapter (
    private val fragment: Fragment,
    private val context: Context,
    private val genres:Genres
) : RecyclerView.Adapter<GenreAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: GenreItemBinding = GenreItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val genre = genres.genres[position]
        holder.title.text = genre?.name

        Glide.with(context)
            .load(genre?.picture_medium)
            .into(holder.image)

        holder.itemView.setOnClickListener{
            if (fragment is HomeFragment){
                if (genre != null) {
                    Toast.makeText(fragment.requireActivity(), "${genre.name}", Toast.LENGTH_LONG).show()
                    fragment.goToArtists(genre)
                }
            }
        }
    }

    override fun getItemCount() = genres.genres.size

    class ViewHolder(view: GenreItemBinding):RecyclerView.ViewHolder(view.root) {
        val title = view.titleTV
        val image = view.imageIV
    }
}