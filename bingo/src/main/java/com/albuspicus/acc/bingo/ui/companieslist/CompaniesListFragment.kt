package com.albuspicus.acc.bingo.ui.companieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.observe
import com.albuspicus.acc.bingo.databinding.FragmentCompaniesListBinding
import com.albuspicus.acc.ui.BindingFragment
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.subDI
import org.kodein.di.instance

class CompaniesListFragment : BindingFragment<FragmentCompaniesListBinding>(), DIAware {

    override val di: DI = subDI({ (activity as DIAware).di }) {
        import(module())
    }

    private val viewModel: CompaniesListViewModel by di.instance()

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentCompaniesListBinding {
        return FragmentCompaniesListBinding.inflate(inflater, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.companiesList.observe(viewLifecycleOwner) { companies ->
            if (companies.size >= 6) {
                binding.company1.text = companies[0].name
                binding.company2.text = companies[1].name
                binding.company3.text = companies[2].name
                binding.company4.text = companies[3].name
                binding.company5.text = companies[4].name
                binding.company6.text = companies[5].name
                binding.root.transitionToEnd()
            }
        }
    }

    companion object {
        fun newInstance() = CompaniesListFragment()
    }

}