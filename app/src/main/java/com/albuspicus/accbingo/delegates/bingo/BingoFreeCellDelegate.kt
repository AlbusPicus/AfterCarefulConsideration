package com.albuspicus.accbingo.delegates.bingo

import com.albuspicus.accbingo.databinding.DelegateBingoFreeCellBinding
import com.albuspicus.accbingo.delegates.SmartDelegate
import com.albuspicus.accbingo.ui.main.BingoCard
import com.albuspicus.accbingo.ui.main.BingoOption

class BingoFreeCellDelegate : SmartDelegate<BingoCard, DelegateBingoFreeCellBinding>(bindingCreator = { inflater, parent ->
    DelegateBingoFreeCellBinding.inflate(inflater, parent, false)
}) {

    override fun suitFor(data: BingoCard): Boolean = data.option == BingoOption.FREE_CELL

    override fun onBindViewHolder(holder: ViewHolder<DelegateBingoFreeCellBinding>, data: BingoCard) {
        super.onBindViewHolder(holder, data)
        holder.binding.bingoText.setText(data.option.titleRes)
    }

}