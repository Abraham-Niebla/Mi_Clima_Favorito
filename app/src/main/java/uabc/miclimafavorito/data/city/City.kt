package uabc.miclimafavorito.data.city
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "t_city")
data class City(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_ciudad")
    val id: Int = 0,

    @ColumnInfo(name = "tx_ciudad")
    val name: String,

    @ColumnInfo(name = "dc_lat")
    val lat: Float,

    @ColumnInfo(name = "dc_lon")
    val lon: Float,

    @ColumnInfo(name = "tx_url")
    val url: String
)
