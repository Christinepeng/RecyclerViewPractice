package com.example.recyclerviewpractice.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewpractice.R
import com.example.recyclerviewpractice.data.Snoopy

class SnoopyViewModel: ViewModel() {


    private val _snoopyList = MutableLiveData<List<Snoopy>>(listOf(
        Snoopy("Snoopy 1", R.drawable.snoopy1),
        Snoopy("Woodstock", R.drawable.woodstock),
        Snoopy("Charlie Brown", R.drawable.charlie_brown),
        Snoopy("Snoopy 2", R.drawable.snoopy2),
        Snoopy("Snoopy 3", R.drawable.snoopy3),

        Snoopy("Snoopy 1", R.drawable.snoopy1),
        Snoopy("Woodstock", R.drawable.woodstock),
        Snoopy("Charlie Brown", R.drawable.charlie_brown),
        Snoopy("Snoopy 2", R.drawable.snoopy2),
        Snoopy("Snoopy 3", R.drawable.snoopy3),

        Snoopy("Snoopy 1", R.drawable.snoopy1),
        Snoopy("Woodstock", R.drawable.woodstock),
        Snoopy("Charlie Brown", R.drawable.charlie_brown),
        Snoopy("Snoopy 2", R.drawable.snoopy2),
        Snoopy("Snoopy 3", R.drawable.snoopy3)
    ))

    val snoopyList: LiveData<List<Snoopy>> = _snoopyList

}
