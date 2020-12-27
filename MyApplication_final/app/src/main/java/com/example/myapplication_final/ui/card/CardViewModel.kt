package com.example.myapplication_final.ui.card

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication4.model.CardMatchingGame

class CardViewModel : ViewModel() {
    private var _game : MutableLiveData<CardMatchingGame> = MutableLiveData()
    val game: MutableLiveData<CardMatchingGame> = _game

    init {
        _game.value = CardMatchingGame(24)
    }
}