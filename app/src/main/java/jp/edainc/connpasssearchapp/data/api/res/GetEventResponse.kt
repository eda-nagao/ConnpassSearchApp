package jp.edainc.connpasssearchapp.data.api.res

data class GetEventResponse(
    val results_returned: Long?,
    val results_available: Long?,
    val results_start: Long?,
    val events: List<Event>?
) {
    data class Event(
        val event_id: Long?,
        val title: String?,
        val catch: String?,
        val description: String?,
        val event_url: String?,
        val hash_tag: String?,
        val started_at: String?,
        val ended_at: String?,
        val limit: Int?,
        val event_type: String?,
        val series: Series?,
        val address: String?,
        val place: String?,
        val lat: Double?,
        val lon: Double?,
        val owner_id: Long?,
        val owner_nickname: String?,
        val owner_display_name: String?,
        val accepted: Int?,
        val waiting: Int?,
        val updated_at: String?
    ) {
        data class Series(
            val id: Long?,
            val title: String?,
            val url: String?
        )
    }
}