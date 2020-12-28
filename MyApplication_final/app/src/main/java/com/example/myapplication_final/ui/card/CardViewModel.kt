package com.example.myapplication_final.ui.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication4.model.CardMatchingGame
import kotlin.concurrent.thread

class CardViewModel : ViewModel() {
    private val _game : MutableLiveData<CardMatchingGame> = MutableLiveData()
    val game: LiveData<CardMatchingGame> = _game

    init {
        _game.value = CardMatchingGame(24)
    }
}