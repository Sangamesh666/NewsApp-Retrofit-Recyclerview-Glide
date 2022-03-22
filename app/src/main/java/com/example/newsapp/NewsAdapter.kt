package com.example.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(val context:Context, val articles: List<Articles>) :

    RecyclerView.Adapter<NewsAdapter.ArticlesViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ArticlesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val articles = articles[position]
        holder.newsTitle.text = articles.title
        holder.newsDescription.text = articles.description
        Glide.with(context).load(articles.urlToImage).into(holder.newsImage)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
        var newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
        var newsDescription = itemView.findViewById<TextView>(R.id.newsDescription)


    }

}