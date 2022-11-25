package com.messieyawo.ispaceroomcoroutineflowproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Artists
import com.messieyawo.ispaceroomcoroutineflowproject.databinding.ArtistItemBinding

class ArtistAdapter (
    val context: Context,
    val artists: Artists
) : RecyclerView.Adapter<ArtistAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: ArtistItemBinding = ArtistItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artist = artists.artists[position]
        holder.name.text = artist?.name

        Glide.with(context)
            .load(artist?.pictureMedium)
            .into(holder.picture)
    }

    override fun getItemCount() = artists.artists.size

    class ViewHolder(view: ArtistItemBinding): RecyclerView.ViewHolder(view.root) {
        val name = view.nameTV
        val picture = view.pictureIV
    }
}