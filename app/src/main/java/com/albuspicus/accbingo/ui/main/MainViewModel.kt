package com.albuspicus.accbingo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _bingoCards = MutableLiveData<List<BingoCard>>()
    val bingoCards: LiveData<List<BingoCard>> = _bingoCards

    init {
        _bingoCards.value = BingoOption.values().map { BingoCard(it) }
    }

}