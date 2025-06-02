package uabc.miclimafavorito.data.city

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "t_city",
    indices = [Index(value = ["nm_id"], unique = true)]
)
data class City(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_ciudad")
    val id: Long = 0,

    @ColumnInfo(name = "tx_ciudad")
    val name: String,

    @ColumnInfo(name = "nm_id")
    val idCiudad: Long
)
