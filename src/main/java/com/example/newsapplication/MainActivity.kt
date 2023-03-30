package com.example.newsapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter:NewsAdapter
    lateinit var recycler:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
        recycler = findViewById(R.id.newsList)
    }
    private fun getNews() {
        val news=NewsService.newsInstance.getHeadlines("in",1)
        news.enqueue(object :Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("HARSH", "Erroin fetching news",)
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news=response.body()
                if (news != null) {
                    Log.d("HARSH", news.toString())
                    adapter = NewsAdapter(this@MainActivity, news.articles)
                    recycler.adapter=adapter
                    recycler.layoutManager=LinearLayoutManager(this@MainActivity)
                }
            }
        })
    }
}