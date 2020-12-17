package com.albuspicus.accbingo.delegates.bingo

import com.albuspicus.accbingo.databinding.DelegateBingoCardBinding
import com.albuspicus.accbingo.delegates.SmartDelegate
import com.albuspicus.accbingo.ui.main.BingoCard
import com.albuspicus.accbingo.ui.main.BingoOption

class BingoDelegate : SmartDelegate<BingoCard, DelegateBingoCardBinding>(bindingCreator = { inflater, parent ->
    DelegateBingoCardBinding.inflate(inflater, parent, false)
}) {

    override fun suitFor(data: BingoCard): Boolean = data.option != BingoOption.FREE_CELL

    override fun onBindViewHolder(holder: ViewHolder<DelegateBingoCardBinding>, data: BingoCard) {
        super.onBindViewHolder(holder, data)
        holder.binding.bingoText.setText(data.option.titleRes)
    }

}