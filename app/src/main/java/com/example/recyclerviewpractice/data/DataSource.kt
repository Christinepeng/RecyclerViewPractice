package com.example.recyclerviewpractice.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataSource(resources: Resources) {
    private val initialSnoopyList = snoopyList(resources)
    private val SnoopysLiveData = MutableLiveData(initialSnoopyList)

    /* Adds Snoopy to liveData and posts value. */
    fun addSnoopy(Snoopy: Snoopy) {
        val currentList = SnoopysLiveData.value
        if (currentList == null) {
            SnoopysLiveData.postValue(listOf(Snoopy))
        } else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, Snoopy)
            SnoopysLiveData.postValue(updatedList)
        }
    }

    /* Removes Snoopy from liveData and posts value. */
    fun removeSnoopy(Snoopy: Snoopy) {
        val currentList = SnoopysLiveData.value
        if (currentList != null) {
            val updatedList = currentList.toMutableList()
            updatedList.remove(Snoopy)
            SnoopysLiveData.postValue(updatedList)
        }
    }

    /* Returns Snoopy given an ID. */
    fun getSnoopyForId(id: Long): Snoopy? {
        SnoopysLiveData.value?.let { Snoopys ->
            return Snoopys.firstOrNull{ it.id == id}
        }
        return null
    }

    fun getSnoopyList(): LiveData<List<Snoopy>> {
        return SnoopysLiveData
    }

    /* Returns a random Snoopy asset for Snoopys that are added. */
    fun getRandomSnoopyImageAsset(): Int? {
        val randomNumber = (initialSnoopyList.indices).random()
        return initialSnoopyList[randomNumber].image
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}