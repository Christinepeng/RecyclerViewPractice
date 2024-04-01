package com.example.recyclerviewpractice.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewpractice.R
import com.example.recyclerviewpractice.data.DataSource
import com.example.recyclerviewpractice.data.Snoopy
import kotlin.random.Random

class SnoopyViewModel(val dataSource: DataSource) : ViewModel() {


    val SnoopysLiveData = dataSource.getSnoopyList()

    /* If the name and description are present, create new Snoopy and add it to the datasource */
    fun insertSnoopy(snoopyName: String?, snoopyDescription: String?) {
        if (snoopyName == null || snoopyDescription == null) {
            return
        }

        val image = dataSource.getRandomSnoopyImageAsset()
        val newSnoopy = Snoopy(
            Random.nextLong(),
            snoopyName,
            image,
            snoopyDescription
        )

        dataSource.addSnoopy(newSnoopy)
    }

}
class SnoopyViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SnoopyViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SnoopyViewModel(
                dataSource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}