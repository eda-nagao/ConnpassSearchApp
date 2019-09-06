package jp.edainc.connpasssearchapp.di.activities

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import jp.edainc.connpasssearchapp.di.ViewModelKey
import jp.edainc.connpasssearchapp.presentation.search.SearchActivity
import jp.edainc.connpasssearchapp.presentation.search.SearchFragment
import jp.edainc.connpasssearchapp.presentation.search.SearchViewModel

@Module
interface SearchActivityModule {
    @Binds
    fun bindsAppCompatActivity(searchActivity: SearchActivity): AppCompatActivity

    @ContributesAndroidInjector
    fun contributeSearchFragment(): SearchFragment

    @Binds @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindSearchViewModel(
        searchViewModel: SearchViewModel
    ): ViewModel
}