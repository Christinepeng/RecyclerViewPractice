package com.example.recyclerviewpractice.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractice.R
import com.example.recyclerviewpractice.adapter.HeaderAdapter
import com.example.recyclerviewpractice.adapter.MyAdapter
import com.example.recyclerviewpractice.databinding.ActivityMainBinding
import com.example.recyclerviewpractice.viewmodel.SnoopyViewModel
import androidx.recyclerview.widget.ConcatAdapter
import com.example.recyclerviewpractice.data.Snoopy
import com.example.recyclerviewpractice.viewmodel.SnoopyViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModelFactory = SnoopyViewModelFactory(this)
    private val viewModel : SnoopyViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[SnoopyViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding


        val recyclerView = binding.recyclerview
        val headerAdapter = HeaderAdapter()
        val myAdapter = MyAdapter{ snoopy -> adapterOnClick(snoopy) }
        val concatAdapter = ConcatAdapter(headerAdapter, myAdapter)

        recyclerView.adapter = concatAdapter

        viewModel.SnoopysLiveData.observe(this, {
            it?.let {
                myAdapter.submitList(it as MutableList<Snoopy>)
                headerAdapter.updateSnoopyCount(it.size)
            }
        })


        binding.fab.setOnClickListener {
            Log.e("bear", "setOnClickListener")
            fabOnClick()
        }
    }
    private fun adapterOnClick(flower: Snoopy) {
//        val intent = Intent(this, FlowerDetailActivity()::class.java)
//        intent.putExtra(FLOWER_ID, flower.id)
//        startActivity(intent)
    }

    private fun fabOnClick() {
        Log.e("bear", "fabOnClick()")
        val intent = Intent(this, AddSnoopyActivity::class.java)
        startActivity(intent)
//        startActivityForResult(intent, 1)
    }
}