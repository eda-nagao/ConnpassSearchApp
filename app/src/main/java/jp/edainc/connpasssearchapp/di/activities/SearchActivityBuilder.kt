package jp.edainc.connpasssearchapp.di.activities

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.edainc.connpasssearchapp.presentation.search.SearchActivity

@Module
interface SearchActivityBuilder {
    @ContributesAndroidInjector(modules = [
        SearchActivityModule::class
    ])
    fun contributeSearchActivity(): SearchActivity
}