package com.project.service

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.project.service.model.Establishment
import com.project.service.model.Locations
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://hotmart-mobile-app.herokuapp.com"

object Api : DataSource {

    private val SERVICE : Service

    init {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request()
                chain.proceed(request)
            }
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .setPrettyPrinting()
            .create()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        SERVICE = retrofit.create(Service::class.java)
    }

    override fun locations() : Single<Locations> = SERVICE.locations()

    override fun establishment(id: String) : Single<Establishment> = SERVICE.establishment(id)
}