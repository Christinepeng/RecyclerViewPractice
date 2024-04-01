package com.example.recyclerviewpractice.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewpractice.R
import com.example.recyclerviewpractice.adapter.HeaderAdapter
import com.example.recyclerviewpractice.adapter.MyAdapter
import com.example.recyclerviewpractice.databinding.ActivityMainBinding
import com.example.recyclerviewpractice.viewmodel.SnoopyViewModel
import androidx.recyclerview.widget.ConcatAdapter
import com.example.recyclerviewpractice.data.Snoopy
import com.example.recyclerviewpractice.viewmodel.SnoopyViewModelFactory

const val SNOOPY_ID = "snoopy id"
class MainActivity : AppCompatActivity() {
    private val newSnoopyActivityRequestCode = 1
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
            fabOnClick()
        }
    }
    private fun adapterOnClick(snoopy: Snoopy) {
        val intent = Intent(this, SnoopyDetailActivity()::class.java)
        intent.putExtra(SNOOPY_ID, snoopy.id)
        startActivity(intent)
    }

    private fun fabOnClick() {
        val intent = Intent(this, AddSnoopyActivity::class.java)
        startActivityForResult(intent, 1)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        /* Inserts flower into viewModel. */
        if (requestCode == newSnoopyActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val snoopyName = data.getStringExtra(SNOOPY_NAME)
                val snoopyDescription = data.getStringExtra(SNOOPY_DESCRIPTION)

                viewModel.insertSnoopy(snoopyName, snoopyDescription)
            }
        }
    }
}