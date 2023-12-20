package com.example.berita

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.berita.beritaAdapter.NewsAdapter
import com.example.berita.beritaAdapter.news
import kotlinx.android.synthetic.main.activity_main.cdv_newsheadline
import kotlinx.android.synthetic.main.activity_main.img_news0
import kotlinx.android.synthetic.main.activity_main.rcv_daftarberita
import kotlinx.android.synthetic.main.activity_main.tvw_DescHeadline
import kotlinx.android.synthetic.main.activity_main.tvw_TitleHeadLine

class MainActivity : AppCompatActivity() {

    lateinit var newsAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var headline : news?
        if(news.BeritaModel.newslist.size > 0){

            headline = news.BeritaModel.newslist[news.BeritaModel.newslist.size -1]
            tvw_TitleHeadLine.setText(headline.title)
            tvw_DescHeadline.setText(headline.desc)
            img_news0.setImageResource(headline.photo)

            cdv_newsheadline.setOnClickListener{
                val detail_intent = Intent(this, DetailActivity::class.java)
                    .apply {
                        putExtra(DetailActivity.cont_TitleNews, headline.title)
                        putExtra(DetailActivity.cont_KontenNews, headline.desc)
                        putExtra(DetailActivity.cont_PhotoNews, headline.photo.toString())
                }
                startActivity(detail_intent)
                finish()
            }
        }
        var recyclerView = LinearLayoutManager(this)
        recyclerView.orientation = LinearLayoutManager.VERTICAL
        rcv_daftarberita.layoutManager = recyclerView

        newsAdapter = NewsAdapter(this, news.BeritaModel.newslist)
        rcv_daftarberita.adapter = newsAdapter


        newsAdapter.setOnClickCallback(object :NewsAdapter.onItemClickCallback{
            override fun onItemClick(data : news){
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                    .apply {
                        putExtra(DetailActivity.cont_TitleNews,data.title.toString())
                        putExtra(DetailActivity.cont_KontenNews,data.desc.toString())
                        putExtra(DetailActivity.cont_PhotoNews, data.photo.toString())
                    }
                startActivity(intent)
                finish()
            }
        })
    }
}