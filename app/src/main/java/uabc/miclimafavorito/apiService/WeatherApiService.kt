package uabc.miclimafavorito.apiService

import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import uabc.miclimafavorito.data.WeatherResponse
import retrofit2.converter.gson.GsonConverterFactory
import uabc.miclimafavorito.data.SearchResponse


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
    private const val BASE_URL = "https://api.weatherapi.com/"

    val api: WeatherApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
    }
}
