package com.example.newsapplication


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter (val context: Context,val article:List<Article>):RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>(){

    class ArticleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var newsImage=itemView.findViewById<ImageView>(R.id.NewsImage)
        var newsTitle=itemView.findViewById<TextView>(R.id.NewsTitle)
        var newsDescription=itemView.findViewById<TextView>(R.id.newsDescription)
    }
    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ArticleViewHolder(view)
    }
    override fun getItemCount(): Int {
        return article.size
    }
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articles=article[position]
        holder.newsTitle.text=articles.title
        holder.newsDescription.text=articles.description
        Glide.with(context).load(articles.urlToImage).into(holder.newsImage)
    }
}