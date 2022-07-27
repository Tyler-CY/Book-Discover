package com.example.bookdiscover.library

import androidx.lifecycle.ViewModel
import com.example.bookdiscover.database.Bookmarks
import com.example.bookdiscover.database.LibraryDao
import kotlinx.coroutines.flow.Flow

/**
 * The ViewModel shared by the classes in the library package
 */
class LibraryViewModel(private val libraryDao: LibraryDao) : ViewModel() {


    /**
     * Returns a List of Bookmarks in a Flow object from the DAO.
     * Flow object allows the RecyclerView to get update instantly whenever the database entries change.
     *
     * Flow is used instead of MutableLiveData and LiveData.
     *
     * Currently, to extract the JsonBody of each Bookmark, the responsibility is delegated to the LibraryAdapter.
     */
    fun bookmarks(): Flow<List<Bookmarks>> = libraryDao.getAll()


}