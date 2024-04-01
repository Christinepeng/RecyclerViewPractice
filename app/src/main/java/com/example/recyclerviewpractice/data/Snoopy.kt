package com.example.recyclerviewpractice.data

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recyclerviewpractice.R

data class Snoopy(
    val id: Long,
    val name: String,
    @DrawableRes
    val image: Int?,
    val description: String
)

//class SnoopyData {
//    private val _snoopyList = MutableLiveData<List<Snoopy>>(listOf(
//        Snoopy(1, "Snoopy 1", R.drawable.snoopy1, "1"),
//        Snoopy(2, "Woodstock", R.drawable.woodstock, "2"),
//        Snoopy(3, "Charlie Brown", R.drawable.charlie_brown, "3"),
//        Snoopy(4, "Snoopy 2", R.drawable.snoopy2, "4"),
//        Snoopy(5, "Snoopy 3", R.drawable.snoopy3, "5"),
//
//        Snoopy(6, "Snoopy 1", R.drawable.snoopy1, "6"),
//        Snoopy(7, "Woodstock", R.drawable.woodstock, "7"),
//        Snoopy(8, "Charlie Brown", R.drawable.charlie_brown, "8"),
//        Snoopy(9, "Snoopy 2", R.drawable.snoopy2, "9"),
//        Snoopy(10, "Snoopy 3", R.drawable.snoopy3, "10"),
//
//        Snoopy(11, "Snoopy 1", R.drawable.snoopy1, "11"),
//        Snoopy(12, "Woodstock", R.drawable.woodstock, "12"),
//        Snoopy(13, "Charlie Brown", R.drawable.charlie_brown ,"13"),
//        Snoopy(14, "Snoopy 2", R.drawable.snoopy2, "14"),
//        Snoopy(15, "Snoopy 3", R.drawable.snoopy3, "15")
//    ))
//
//    val snoopyList: LiveData<List<Snoopy>> = _snoopyList
//}