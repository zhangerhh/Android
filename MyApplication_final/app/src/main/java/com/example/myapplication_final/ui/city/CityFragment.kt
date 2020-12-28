package com.example.myapplication_final.ui.city

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication_final.R
import com.example.myapplication_final.ui.card.CardViewModel
import kotlinx.android.synthetic.main.city_fragment.*

class CityFragment : Fragment() {

    companion object {
        fun newInstance() = CityFragment()
    }

    private lateinit var viewModel: CityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.city_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CityViewModel::class.java)

        viewModel.cities.observe(viewLifecycleOwner, Observer {
            val cities = it
            val adapter = ArrayAdapter<City>(requireActivity(), android.R.layout.simple_list_item_1, cities)
            listView.adapter = adapter
            listView.setOnItemClickListener { _, _, position, _ ->
                val cityCode = cities[position].city_code
                val intent = Intent(requireActivity(), Main2Activity::class.java)
                intent.putExtra("city_code", cityCode)
                startActivity(intent)
            }
        })

    }

}