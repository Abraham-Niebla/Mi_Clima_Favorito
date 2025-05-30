package uabc.miclimafavorito.backend.database

import kotlinx.coroutines.flow.Flow
import uabc.miclimafavorito.data.city.City
import uabc.miclimafavorito.interfaces.city.CityDao

class CityRepository(private val cityDao: CityDao) {

    fun getAllCities(): List<City> = cityDao.getAllCities()

    fun getCityById(id: Int): Flow<City?> = cityDao.getCityByIdFlow(id)

    suspend fun insert(city: City) = cityDao.insertCity(city)

    suspend fun delete(city: City) = cityDao.deleteCity(city)
}

