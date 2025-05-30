package uabc.miclimafavorito.backend.apiService

import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import uabc.miclimafavorito.data.weather.WeatherResponse
import retrofit2.converter.gson.GsonConverterFactory
import uabc.miclimafavorito.data.weather.SearchResponse
import uabc.miclimafavorito.globals.BASE_API_URL


interface WeatherApiService {
    @GET("v1/current.json")
    suspend fun getCurrentWeather(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("lang") language: String
    ): WeatherResponse

    @GET("v1/search.json")
    suspend fun getSearchCities(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("lang") language: String
    ): List<SearchResponse>
}

object RetrofitInstance {
    private const val BASE_URL = BASE_API_URL

    val api: WeatherApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
    }
}
