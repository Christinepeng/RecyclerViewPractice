package com.example.recyclerviewpractice.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractice.R
import com.example.recyclerviewpractice.adapter.HeaderAdapter
import com.example.recyclerviewpractice.adapter.MyAdapter
import com.example.recyclerviewpractice.databinding.ActivityMainBinding
import com.example.recyclerviewpractice.viewmodel.SnoopyViewModel
import androidx.recyclerview.widget.ConcatAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding

        val viewModel = SnoopyViewModel()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val headerAdapter = HeaderAdapter()
        val myAdapter = MyAdapter(viewModel.snoopyList.value!!)
        val concatAdapter = ConcatAdapter(headerAdapter, myAdapter)

        recyclerView.adapter = concatAdapter

//        viewModel.snoopyList.observe(this, {
//            it?.let {
//                myAdapter.submitList(it as MutableList<Snoopy>)
//                headerAdapter.updateFlowerCount(it.size)
//            }
//        })
//
//        val fab: View = findViewById(R.id.fab)
//        fab.setOnClickListener {
//            fabOnClick()
//        }

    }
}