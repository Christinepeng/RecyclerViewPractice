package com.example.recyclerviewpractice.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.recyclerviewpractice.R
import com.example.recyclerviewpractice.databinding.AddNewItemPageBinding
import com.google.android.material.textfield.TextInputEditText

const val SNOOPY_NAME = "name"
const val SNOOPY_DESCRIPTION = "description"
class AddSnoopyActivity : AppCompatActivity() {
    private lateinit var addSnoopyName: TextInputEditText
    private lateinit var addSnoopyDescription: TextInputEditText
    private lateinit var binding: AddNewItemPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.add_new_item_page) as AddNewItemPageBinding

        binding.doneButton.setOnClickListener {
            addSnoopy()
        }
        addSnoopyName = binding.addName
        addSnoopyDescription = binding.addDescription
    }


    private fun addSnoopy() {
        val resultIntent = Intent()

        if (addSnoopyName.text.isNullOrEmpty() || addSnoopyDescription.text.isNullOrEmpty()) {
            setResult(Activity.RESULT_CANCELED, resultIntent)
        } else {
            val name = addSnoopyName.text.toString()
            val description = addSnoopyDescription.text.toString()
            resultIntent.putExtra(SNOOPY_NAME, name)
            resultIntent.putExtra(SNOOPY_DESCRIPTION, description)
            setResult(Activity.RESULT_OK, resultIntent)
        }
        finish()
    }
}