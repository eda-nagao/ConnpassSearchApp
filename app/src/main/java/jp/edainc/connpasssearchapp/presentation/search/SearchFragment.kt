package jp.edainc.connpasssearchapp.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import jp.edainc.connpasssearchapp.R
import jp.edainc.connpasssearchapp.databinding.FragmentSearchBinding
import jp.edainc.connpasssearchapp.di.ViewModelFactory
import jp.edainc.connpasssearchapp.presentation.common.fragment.BaseFragment
import javax.inject.Inject

class SearchFragment : BaseFragment() {
    @Inject lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: SearchViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel::class.java)
    }

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.submitButton.setOnClickListener { onSubmit() }
    }

    fun onSubmit() {
        val keyword = binding.keyword.text
        viewModel.doSearch(keyword.split(" "), emptyList())
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}
