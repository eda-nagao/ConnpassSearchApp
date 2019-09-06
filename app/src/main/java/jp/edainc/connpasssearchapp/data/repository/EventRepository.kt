package jp.edainc.connpasssearchapp.data.repository

import jp.edainc.connpasssearchapp.model.EventEntity

interface EventRepository {
    suspend fun searchEvent(keywordAnd: List<String>, keywordOr: List<String>): List<EventEntity>
}