package app.pondokcoder.and0001.ui.room.keranjang

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import dagger.Module

@Module
open class NoteRepository(context: Context) {

    private lateinit var noteDao: KeranjangDao
    private lateinit var allNotes: LiveData<List<Keranjang>>

    init {
        PDCDatabase.getInstance(context)?.let {
            noteDao = it.keranjangDao()
            allNotes = noteDao.getAllKeranjang()
        }
    }

    fun insert(note: Keranjang) {
        DoInBackgroundAsync<Keranjang> {
            noteDao.insert(note)
        }.execute()
    }

    fun getAllNotes(): LiveData<List<Keranjang>> {
        return allNotes
    }

    fun updateNote(note: Keranjang) {
        DoInBackgroundAsync<Keranjang> {
            noteDao.update(note)
        }.execute()
    }

    fun removeNote(note: Keranjang) {
        DoInBackgroundAsync<Keranjang> {
            noteDao.remove(note)
        }.execute()
    }


    private class DoInBackgroundAsync<T : Any>(
        private val backgroundTask: () -> Unit
    ) : AsyncTask<T, Unit, Unit>() {
        override fun doInBackground(vararg params: T) {
            backgroundTask.invoke()
        }
    }
}