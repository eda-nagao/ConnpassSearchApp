package jp.edainc.connpasssearchapp.presentation

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import jp.edainc.connpasssearchapp.di.DaggerAppComponent
import jp.edainc.connpasssearchapp.di.NetworkModule

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .networkModule(NetworkModule)
            .build()
    }
}