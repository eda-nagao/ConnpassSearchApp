package jp.edainc.connpasssearchapp.data.api

import jp.edainc.connpasssearchapp.di.NetworkModule
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class ConnpassAPITest {
    val api = NetworkModule.provideConnpassAPI(NetworkModule.provideRetrofit(NetworkModule.provideOkHttpClient(), "https://connpass.com"))

    @Test
    fun getEventTest() = runBlocking {
        val res = api.getEvents(listOf("python"), listOf())
        assert(res.results_available >= 0)
    }
}