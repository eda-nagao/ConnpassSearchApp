package jp.edainc.connpasssearchapp.model

import java.util.*

data class EventEntity(
    val id: Long,
    val title: String,
    val catch: String,
    val description: String,
    val eventUrl: String
//    val hashTag: String,
//    val startedAt: Date,
//    val endedAt: Date,
//    val limit: Int,
//    val eventType: String,
//    val groupId: Long,
//    val groupTitle: String,
//    val groupUrl: String
//    val address: String,
//    val place: String,
//    val lat: Double,
//    val lon: Double,
//    val ownerId: Long,
//    val ownerNickname: String,
//    val ownerDisplayName: String,
//    val accepted: Int,
//    val waiting: Int,
//    val updatedAt: Date
)