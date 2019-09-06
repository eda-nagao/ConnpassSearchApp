package jp.edainc.connpasssearchapp.presentation.search

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import jp.edainc.connpasssearchapp.R
import jp.edainc.connpasssearchapp.databinding.ActivitySearchBinding
import jp.edainc.connpasssearchapp.presentation.common.activity.BaseActivity

class SearchActivity : BaseActivity() {
    private val binding: ActivitySearchBinding by lazy {
        DataBindingUtil.setContentView<ActivitySearchBinding>(this, R.layout.activity_search)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchFragment.newInstance())
                .commitNow()
        }
    }
}
