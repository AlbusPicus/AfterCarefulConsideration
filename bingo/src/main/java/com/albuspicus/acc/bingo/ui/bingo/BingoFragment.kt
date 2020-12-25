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

private const val BINGO_SPAN_COUNT = 5

class BingoFragment : Fragment() {

    private lateinit var viewModel: com.albuspicus.acc.bingo.ui.bingo.BingoViewModel

    private var _binding: FragmentBingoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBingoBinding.inflate(inflater, container, false)
        return binding.root
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
        viewModel = ViewModelProvider(this).get(BingoViewModel::class.java)
        viewModel.bingoCards.observe(viewLifecycleOwner) { cards ->
            (binding.bingoRecycler.adapter as? ListDelegatesAdapter<BingoCard>)?.updateItems(cards)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = BingoFragment()
    }

}
