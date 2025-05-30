package uabc.miclimafavorito.backend.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import uabc.miclimafavorito.data.city.City

class CityViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CityRepository

    private val _selectedCity = MutableStateFlow<City?>(null)
    val selectedCity: StateFlow<City?> = _selectedCity.asStateFlow()

    val allCities: StateFlow<List<City>> = MutableStateFlow(emptyList())

    init {
        val dao = AppDatabase.getInstance(application).cityDao()
        repository = CityRepository(dao)

        // Start collecting Flow of all cities
        viewModelScope.launch(Dispatchers.IO) {
            repository.allCities.collect {
                (allCities as MutableStateFlow).value = it
            }
        }
    }

    fun insertCity(city: City) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(city)
        }
    }

    fun deleteCity(city: City) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(city)
        }
    }

    fun getCityById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _selectedCity.value = repository.getCityById(id)
        }
    }
}
