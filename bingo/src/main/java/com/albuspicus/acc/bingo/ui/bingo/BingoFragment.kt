package com.albuspicus.acc.bingo.ui.bingo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.albuspicus.acc.bingo.databinding.FragmentBingoBinding
import com.albuspicus.acc.bingo.ui.bingo.delegates.BingoDelegate
import com.albuspicus.acc.bingo.ui.bingo.delegates.BingoFreeCellDelegate
import com.albuspicus.recycler_delegates.DefaultDelegatesManager
import com.albuspicus.recycler_delegates.ListDelegatesAdapter
import com.albuspicus.ui.BindingFragment
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.subDI
import org.kodein.di.instance

private const val BINGO_SPAN_COUNT = 5

class BingoFragment : BindingFragment<FragmentBingoBinding>(), DIAware {

    override val di: DI = subDI({ (activity as DIAware).di }) {
        import(module())
    }

    private val viewModel: BingoViewModel by di.instance()

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentBingoBinding {
        return FragmentBingoBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bingoRecycler.layoutManager = GridLayoutManager(requireContext(),
            BINGO_SPAN_COUNT
        )
        binding.bingoRecycler.adapter = ListDelegatesAdapter<BingoCard>(
            DefaultDelegatesManager().apply {
                addDelegate(BingoDelegate())
                addDelegate(BingoFreeCellDelegate())
            }
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.bingoCards.observe(viewLifecycleOwner) { cards ->
            (binding.bingoRecycler.adapter as? ListDelegatesAdapter<BingoCard>)?.updateItems(cards)
        }
    }

    companion object {
        fun newInstance() = BingoFragment()
    }

}
