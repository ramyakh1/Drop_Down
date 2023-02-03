package com.example.myapplication

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dropdown()
        binding.btnSubmit.setOnClickListener { result() }
    }

    private fun result(){
        val address = binding.etAddress.text.toString()
        val country = binding.etCountry.text.toString()
        binding.tvResult.text= " $address , $country"
    }

    private fun dropdown(){
        binding.etCountry.setOnClickListener{
            closekeyBoard(binding.etCountry)
            val items= resources.getStringArray(R.array.country_list)
            val adapter= ArrayAdapter(this, R.layout.country_items,items)
            binding.etCountry.setAdapter(adapter)
        }

    }

    private fun closekeyBoard(view:View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)

    }
}