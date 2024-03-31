package com.example.recyclerviewpractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewpractice.R
import com.example.recyclerviewpractice.data.Snoopy

class SnoopyViewModel: ViewModel() {


    private val _snoopyList = MutableLiveData<List<Snoopy>>(listOf(
        Snoopy("Snoopy 1", R.drawable.snoopy1, 1),
        Snoopy("Woodstock", R.drawable.woodstock, 2),
        Snoopy("Charlie Brown", R.drawable.charlie_brown, 3),
        Snoopy("Snoopy 2", R.drawable.snoopy2, 4),
        Snoopy("Snoopy 3", R.drawable.snoopy3, 5),

        Snoopy("Snoopy 1", R.drawable.snoopy1, 6),
        Snoopy("Woodstock", R.drawable.woodstock, 7),
        Snoopy("Charlie Brown", R.drawable.charlie_brown, 8),
        Snoopy("Snoopy 2", R.drawable.snoopy2, 9),
        Snoopy("Snoopy 3", R.drawable.snoopy3, 10),

        Snoopy("Snoopy 1", R.drawable.snoopy1, 11),
        Snoopy("Woodstock", R.drawable.woodstock, 12),
        Snoopy("Charlie Brown", R.drawable.charlie_brown ,13),
        Snoopy("Snoopy 2", R.drawable.snoopy2, 14),
        Snoopy("Snoopy 3", R.drawable.snoopy3, 15)
    ))

    val snoopyList: LiveData<List<Snoopy>> = _snoopyList

}
