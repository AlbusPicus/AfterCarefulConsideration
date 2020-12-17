package com.albuspicus.accbingo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.albuspicus.accbingo.databinding.MainFragmentBinding
import com.albuspicus.accbingo.delegates.DefaultDelegatesManager
import com.albuspicus.accbingo.delegates.ListDelegatesAdapter
import com.albuspicus.accbingo.delegates.bingo.BingoDelegate
import com.albuspicus.accbingo.delegates.bingo.BingoFreeCellDelegate

private const val BINGO_SPAN_COUNT = 5

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bingoRecycler.layoutManager = GridLayoutManager(requireContext(), BINGO_SPAN_COUNT)
        binding.bingoRecycler.adapter = ListDelegatesAdapter<BingoCard>(
            DefaultDelegatesManager().apply {
                addDelegate(BingoDelegate())
                addDelegate(BingoFreeCellDelegate())
            }
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.bingoCards.observe(viewLifecycleOwner) { cards ->
            (binding.bingoRecycler.adapter as? ListDelegatesAdapter<BingoCard>)?.updateItems(cards)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}
