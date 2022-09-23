package com.example.coderswagudemykotlin.Controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coderswagudemykotlin.Adapters.ProductsAdapter
import com.example.coderswagudemykotlin.R
import com.example.coderswagudemykotlin.Services.DataService
import com.example.coderswagudemykotlin.Utilities.EXTRA_CATEGORY
import com.example.coderswagudemykotlin.databinding.ActivityProductsBinding

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter
    lateinit var binding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        binding.productListView.layoutManager = layoutManager
        binding.productListView.adapter = adapter

    }
}