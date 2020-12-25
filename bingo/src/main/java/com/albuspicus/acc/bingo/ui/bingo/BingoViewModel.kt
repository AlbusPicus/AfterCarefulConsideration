package com.albuspicus.acc.bingo.ui.bingo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BingoViewModel : ViewModel() {

    private val _bingoCards = MutableLiveData<List<BingoCard>>()
    val bingoCards: LiveData<List<BingoCard>> = _bingoCards

    init {
        _bingoCards.value = BingoOption.values().map { BingoCard(it) }
    }

}