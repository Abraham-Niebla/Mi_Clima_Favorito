package uabc.miclimafavorito.backend.database

import kotlinx.coroutines.flow.Flow
import uabc.miclimafavorito.data.city.City
import uabc.miclimafavorito.interfaces.city.CityDao

class CityRepository(private val cityDao: CityDao) {

    var allCities: Flow<List<City>> = cityDao.getAllCities()

    suspend fun insert(city: City) {
        cityDao.insertCity(city)
    }

    suspend fun delete(city: City) {
        cityDao.deleteCity(city)
    }

    suspend fun getCityById(id: Long): City? {
        return cityDao.getCityById(id)
    }

    fun getCities() {
        this.allCities = cityDao.getAllCities()
    }
}
