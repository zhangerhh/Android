package com.example.myapplication_final.ui.hello

import android.app.Application
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication_final.R
import kotlinx.android.synthetic.main.hello_fragment.*
import kotlin.concurrent.thread

class HelloViewModel (application: Application): AndroidViewModel(application) {
    private var _clickeds: MutableLiveData<Int> = MutableLiveData()
    var clickeds: LiveData<Int> = _clickeds
    init {
        _clickeds.postValue(R.string.clicked)
    }


}