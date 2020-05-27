package com.example.rubyloan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProvidersAdaptor(private val listOfProviders: List<Providers>) : RecyclerView.Adapter<ProvidersRecyclerViewItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvidersRecyclerViewItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.providers_view,parent,false)
        return ProvidersRecyclerViewItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listOfProviders.size
    }

    override fun onBindViewHolder(holder: ProvidersRecyclerViewItemViewHolder, position: Int) {
        val items = listOfProviders[position]
        holder.image.setImageResource(items.image)
        holder.name.text = items.name
    }

}

class ProvidersRecyclerViewItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  val image = itemView.findViewById<ImageView>(R.id.ivProviders)
    val name = itemView.findViewById<TextView>(R.id.tvProviders)
}
