package com.example.recyclerviewpractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
