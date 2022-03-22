package com.example.newsapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=84b641abb6404967bdedf44b8a71ecc6

//https://newsapi.org/v2/everything?q=tesla&from=2022-02-22&sortBy=publishedAt&apiKey=84b641abb6404967bdedf44b8a71ecc6

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "84b641abb6404967bdedf44b8a71ecc6"


interface NewsInterface {
    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country")country: String,@Query("page") page: Int) : Call<News>
}

object NewsService {
    val newsInterface: NewsInterface
    init {
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInterface = retrofit.create(NewsInterface::class.java)
    }
}