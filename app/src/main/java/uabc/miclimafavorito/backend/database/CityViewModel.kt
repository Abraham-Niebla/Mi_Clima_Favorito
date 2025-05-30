package uabc.miclimafavorito.backend.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.*
import uabc.miclimafavorito.data.city.City

class CityViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CityRepository

    init {
        val dao = AppDatabase.getInstance(application).cityDao()
        repository = CityRepository(dao)
    }

    // Obtener todas las ciudades como Flow
    fun getAllCities(): List<City> = repository.getAllCities()

    // Obtener una ciudad por ID como Flow
    fun getCityById(id: Int): Flow<City?> = repository.getCityById(id)

    // Insertar ciudad (no retorna valor, es acción)
    suspend fun insertCity(city: City) {
        repository.insert(city)
    }

    // Eliminar ciudad
    suspend fun deleteCity(city: City) {
        repository.delete(city)
    }
}
