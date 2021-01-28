package app.pondokcoder.and0001.ui.room.keranjang

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface KeranjangDao {

    @Insert
    fun insert(note: Keranjang)

    @Delete
    fun remove(note: Keranjang)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(note: Keranjang): String

    @Query("SELECT * FROM notes_table ")
    fun getAllKeranjang(): LiveData<List<Keranjang>>

}