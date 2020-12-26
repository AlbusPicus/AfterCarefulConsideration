package com.albuspicus.acc.bingo.ui.bingo.delegates

import com.albuspicus.acc.bingo.databinding.DelegateBingoFreeCellBinding
import com.albuspicus.acc.bingo.ui.bingo.BingoCard
import com.albuspicus.acc.bingo.ui.bingo.BingoOption
import com.albuspicus.acc.ui.recycler.SmartDelegate

class BingoFreeCellDelegate : SmartDelegate<BingoCard, DelegateBingoFreeCellBinding>(bindingCreator = { inflater, parent ->
    DelegateBingoFreeCellBinding.inflate(inflater, parent, false)
}) {

    override fun suitFor(data: BingoCard): Boolean = data.option == BingoOption.FREE_CELL

    override fun onBindViewHolder(holder: ViewHolder<DelegateBingoFreeCellBinding>, data: BingoCard) {
        super.onBindViewHolder(holder, data)
        holder.binding.bingoText.setText(data.option.titleRes)
    }

}