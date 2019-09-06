package jp.edainc.connpasssearchapp.data.repository

import jp.edainc.connpasssearchapp.data.api.ConnpassAPI
import jp.edainc.connpasssearchapp.model.EventEntity

class EventRepositoryImpl(
    private val api: ConnpassAPI
) : EventRepository {
    override suspend fun searchEvent(keywordAnd: List<String>, keywordOr: List<String>): List<EventEntity> {
        return api.getEvents(keywordAnd, keywordOr).events?.mapNotNull {
            if (it.event_id is Long) {
                EventEntity(
                    it.event_id,
                    it.title ?: "",
                    it.catch ?: "",
                    it.description ?: "",
                    it.event_url ?: ""
                )
            } else {
                null
            }
        } ?: emptyList()
    }
}