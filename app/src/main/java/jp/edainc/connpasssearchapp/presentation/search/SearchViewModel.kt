package jp.edainc.connpasssearchapp.presentation.search

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jp.edainc.connpasssearchapp.data.repository.EventRepository
import jp.edainc.connpasssearchapp.model.EventEntity
import kotlinx.coroutines.*
import java.lang.Exception
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    context: Context,
    private val repository: EventRepository
) : ViewModel() {
    private val job = Job()
    private val apiScope = CoroutineScope(job + Dispatchers.IO)

    val events = MutableLiveData<List<EventEntity>>()

    fun doSearch(keywordAnd: List<String>, keywordOr: List<String>) {
        apiScope.launch {
            try {
                val eventList = repository.searchEvent(keywordAnd, keywordOr)
                events.postValue(eventList)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancelChildren()
    }
}
