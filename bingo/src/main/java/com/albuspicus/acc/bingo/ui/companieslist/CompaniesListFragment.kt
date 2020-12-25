package com.albuspicus.acc.bingo.ui.companieslist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.albuspicus.acc.bingo.R

class CompaniesListFragment : Fragment() {

    private lateinit var viewModel: CompaniesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_companies_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CompaniesListViewModel::class.java)
        // TODO: Use the ViewModel
    }

    companion object {
        fun newInstance() = CompaniesListFragment()
    }

}