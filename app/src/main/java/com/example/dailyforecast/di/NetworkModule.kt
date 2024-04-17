package com.example.dailyforecast.di

import com.example.dailyforecast.data.source.remote.network.DailyForecastService
import com.example.dailyforecast.data.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Aziza Helmy on 4/15/2024.
 */


val networkModule = module {

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return logging
    }

    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(logging).build()
    }

    fun DailyForecastService(retrofit: Retrofit): DailyForecastService = retrofit.create(DailyForecastService::class.java)

    factory { provideOkHttpClient(get()) }
    factory { DailyForecastService(get()) }
    factory { provideHttpLoggingInterceptor() }
    single { provideRetrofit(get()) }

}
