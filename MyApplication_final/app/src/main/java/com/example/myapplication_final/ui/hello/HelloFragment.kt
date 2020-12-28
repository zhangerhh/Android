package com.example.myapplication_final.ui.hello

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.myapplication_final.R
import com.example.myapplication_final.ui.city.CityViewModel
import kotlinx.android.synthetic.main.hello_fragment.*

class HelloFragment : Fragment() {

    companion object {
        fun newInstance() = HelloFragment()
    }

    private lateinit var viewModel: HelloViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.hello_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProviders.of(this).get(HelloViewModel::class.java)
        viewModel = ViewModelProviders.of(this).get(HelloViewModel::class.java)
        viewModel.clickeds.observe(viewLifecycleOwner, Observer {
            button.setOnClickListener {
                textView.text=resources.getString(R.string.clicked)
            }
        })

    }

}