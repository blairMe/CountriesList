package com.blair.earthcountries.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.blair.earthcountries.model.entities.Countries
import com.blair.earthcountries.databinding.CountryItemBinding
import com.bumptech.glide.Glide

class CountriesAdapter(private val theContext : Context) : RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {
    inner class CountriesViewHolder(val binding: CountryItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<Countries>() {
        override fun areItemsTheSame(oldItem: Countries, newItem: Countries): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Countries, newItem: Countries): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)
    var countries : List<Countries>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder(CountryItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.binding.apply {
            val theCountries = countries[position]
            countryName.text = "${theCountries.name} ${theCountries.callingCodes.toString()}"
            //countryCode.text = theCountries.callingCodes.toString()
            countryCapital.text = theCountries.capital
            Glide.with(theContext)
                .load(theCountries.flags.png.toString())
                .centerCrop()
                .into(flagView)
        }
    }

    override fun getItemCount(): Int {
        return countries.size
    }
}