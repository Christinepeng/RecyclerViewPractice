package com.example.recyclerviewpractice.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewpractice.data.DataSource
import com.example.recyclerviewpractice.data.Snoopy

class SnoopyDetailViewModel(private val datasource: DataSource) : ViewModel() {

    /* Queries datasource to returns a snoopy that corresponds to an id. */
    fun getSnoopyForId(id: Long) : Snoopy? {
        return datasource.getSnoopyForId(id)
    }

    /* Queries datasource to remove a snoopy. */
    fun removeSnoopy(snoopy: Snoopy) {
        datasource.removeSnoopy(snoopy)
    }
}

class SnoopyDetailViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SnoopyDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SnoopyDetailViewModel(
                datasource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}