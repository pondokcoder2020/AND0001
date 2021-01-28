package app.pondokcoder.and0001.ui.room.keranjang

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Keranjang::class], version = 1, exportSchema = false)
abstract class PDCDatabase : RoomDatabase() {

    abstract fun keranjangDao(): KeranjangDao

    companion object {
        private const val DB_NAME = "db_pondokcoder_ecommerce"
        private var instance: PDCDatabase? = null

        fun getInstance(context: Context): PDCDatabase? {
            if (instance == null) {
                synchronized(PDCDatabase::class) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        PDCDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }
    }
}