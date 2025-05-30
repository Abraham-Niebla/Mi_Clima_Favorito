package uabc.miclimafavorito.interfaces.city

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uabc.miclimafavorito.data.city.City

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(city: City): Long

    @Query("SELECT * FROM t_city WHERE id_ciudad = :id")
    fun getCityByIdFlow(id: Int): Flow<City?>

    @Query("SELECT * FROM t_city ORDER BY id_ciudad ASC")
    fun getAllCities(): List<City>

    @Delete
    suspend fun deleteCity(city: City)
}
