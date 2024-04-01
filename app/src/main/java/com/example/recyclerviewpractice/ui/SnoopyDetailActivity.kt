package com.example.recyclerviewpractice.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewpractice.R
import com.example.recyclerviewpractice.databinding.ActivityMainBinding
import com.example.recyclerviewpractice.databinding.SnoopyDetailActivityBinding
import com.example.recyclerviewpractice.viewmodel.SnoopyDetailViewModel
import com.example.recyclerviewpractice.viewmodel.SnoopyDetailViewModelFactory
import com.example.recyclerviewpractice.viewmodel.SnoopyViewModel
import com.example.recyclerviewpractice.viewmodel.SnoopyViewModelFactory

class SnoopyDetailActivity : AppCompatActivity() {

    private lateinit var binding: SnoopyDetailActivityBinding
    private val viewModelFactory = SnoopyDetailViewModelFactory(this)
    private val snoopyDetailViewModel : SnoopyDetailViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[SnoopyDetailViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.snoopy_detail_activity) as SnoopyDetailActivityBinding
        var currentSnoopyId: Long? = null


        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            currentSnoopyId = bundle.getLong(SNOOPY_ID)
        }

        /* If currentSnoopyId is not null, get corresponding snoopy and set name, image and
        description */
        currentSnoopyId?.let {
            val currentSnoopy = snoopyDetailViewModel.getSnoopyForId(it)
            binding.snoopyDetailName.text = currentSnoopy?.name
            if (currentSnoopy?.image == null) {
                binding.snoopyDetailImage.setImageResource(R.drawable.snoopy3)
            } else {
                binding.snoopyDetailImage.setImageResource(currentSnoopy.image)
            }
            binding.snoopyDetailDescription.text = currentSnoopy?.description

            binding.removeButton.setOnClickListener {
                if (currentSnoopy != null) {
                    snoopyDetailViewModel.removeSnoopy(currentSnoopy)
                }
                finish()
            }
        }

    }
}