package jp.edainc.connpasssearchapp.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import jp.edainc.connpasssearchapp.data.api.ConnpassAPI
import jp.edainc.connpasssearchapp.data.repository.EventRepository
import jp.edainc.connpasssearchapp.data.repository.EventRepositoryImpl
import javax.inject.Singleton

@Module
object AppModule {
    @Singleton @Provides @JvmStatic
    fun provideContext(application: Application): Context = application

    @Singleton @Provides @JvmStatic
    fun provideEventRepository(
        api: ConnpassAPI
    ): EventRepository {
        return EventRepositoryImpl(api)
    }

    @Provides @ApiUrl @JvmStatic
    fun apiUrl(): String = "https://connpass.com"
}