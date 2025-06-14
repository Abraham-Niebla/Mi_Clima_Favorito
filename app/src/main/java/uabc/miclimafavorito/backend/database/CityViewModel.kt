package uabc.miclimafavorito.backend.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import uabc.miclimafavorito.data.city.City
import kotlinx.coroutines.Dispatchers

class CityViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CityRepository

    private val _selectedCity = MutableStateFlow<City?>(null)
    val selectedCity: StateFlow<City?> = _selectedCity.asStateFlow()

    private val _allCities = MutableStateFlow<List<City>>(emptyList())
    val allCities: StateFlow<List<City>> = _allCities.asStateFlow()

    init {
        val dao = AppDatabase.getInstance(application).cityDao()
        repository = CityRepository(dao)

        // Start collecting Flow of all cities
        viewModelScope.launch(Dispatchers.IO) {
            repository.allCities.collect {
                _allCities.value = it
            }
        }
    }

    fun insertCity(city: City) {
        viewModelScope.launch(Dispatchers.IO) {
            val existingCity = repository.getCityById(city.idCiudad)
            if (existingCity == null) {
                repository.insert(city)
            }
        }
    }

    fun deleteCity(city: City) {
        viewModelScope.launch(Dispatchers.IO) {
            val existingCity = repository.getCityById(city.idCiudad)
            if (existingCity != null) {
                repository.delete(existingCity)
            }
        }
    }

    fun getCityById(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _selectedCity.value = repository.getCityById(id)
        }
    }

    fun getAllCities() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCities()
        }
    }
}
