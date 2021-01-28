package app.pondokcoder.and0001.ui.room.keranjang

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Keranjang(
    var uid: String,
    var qty: Double,
    var price: Double,
    var total: Double,
    var description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}