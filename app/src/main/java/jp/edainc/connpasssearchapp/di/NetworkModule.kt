package jp.edainc.connpasssearchapp.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import jp.edainc.connpasssearchapp.BuildConfig
import jp.edainc.connpasssearchapp.data.api.ConnpassAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkModule {
    @Singleton @Provides @JvmStatic
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().also {
                    it.level = HttpLoggingInterceptor.Level.BODY
                })
            } }
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .build()
    }

    @Singleton @Provides @JvmStatic
    fun provideRetrofit(okHttpClient: OkHttpClient, @ApiUrl url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .build()
    }

    @Singleton @Provides @JvmStatic
    fun provideConnpassAPI(retrofit: Retrofit): ConnpassAPI {
        return retrofit.create(ConnpassAPI::class.java)
    }

}