package jp.edainc.connpasssearchapp.data.api

import jp.edainc.connpasssearchapp.data.api.res.GetEventResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ConnpassAPI {
    @GET("/api/v1/event/")
    suspend fun getEvents(
        @Query("keyword") keywordAnd: List<String>,
        @Query("keyword_or") keywordOr: List<String>
    ): GetEventResponse
}