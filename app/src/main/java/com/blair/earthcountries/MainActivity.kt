package com.blair.earthcountries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.blair.earthcountries.databinding.ActivityMainBinding
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var countriesAdapter : CountriesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup the recyclerView
        setupRecyclerView()

        lifecycleScope.launchWhenCreated {
            binding.progressBar.visibility = View.VISIBLE

            val response = try {
                RetrofitInstance.api.getCountries()
            } catch (ex : IOException) {
                Log.i("There was a problem", "You might not have internet")
                binding.progressBar.visibility = View.GONE
                return@launchWhenCreated
            } catch (ex : HttpException) {
                Log.i("There was a problem", "Http exception, unexpected response")
                binding.progressBar.visibility = View.GONE
                return@launchWhenCreated
            }

            if(response.isSuccessful && response.body() != null) {
                countriesAdapter.countries = response.body()!!
            } else {
                Log.e("There was a problem", "Response not successful")
            }
            binding.progressBar.visibility = View.GONE

        }

    }

    private fun setupRecyclerView() = binding.rvCountries.apply {
        countriesAdapter = CountriesAdapter()
        adapter = countriesAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }
}