package com.example.berita.beritaAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.berita.R
import kotlinx.android.synthetic.main.lay_berita.view.img_news
import kotlinx.android.synthetic.main.lay_berita.view.tvw_Desc
import kotlinx.android.synthetic.main.lay_berita.view.tvw_title
import org.intellij.lang.annotations.JdkConstants.TitledBorderTitlePosition

class NewsAdapter(val context: Context, val list: List<news>) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var currensNews: news? = null
        var currenPosition: Int = 0

        fun setData(currennews: news, position: Int){
            itemView.tvw_title.text = currennews!!.title
            itemView.tvw_Desc.text = currennews!!.desc
            itemView.img_news.setImageResource(currennews!!.photo)

            this.currensNews
            this.currenPosition
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.lay_berita, parent, false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
val dataNews = list[position]
        holder.setData(dataNews, position)

        holder.itemView.setOnClickListener(){ onItemClickCallBack.onItemClick(list[position])}

    }
    private lateinit var onItemClickCallBack : onItemClickCallback

    fun setOnClickCallback(onItemClickCallback: onItemClickCallback){
        this.onItemClickCallBack = onItemClickCallback
    }

    interface onItemClickCallback {
        fun onItemClick(data: news)
    }
    override fun getItemCount(): Int {
        return list.size
    }


}