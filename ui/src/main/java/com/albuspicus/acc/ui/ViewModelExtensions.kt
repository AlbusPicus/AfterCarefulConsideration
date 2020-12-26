package com.albuspicus.acc.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Register ViewModel in the activity ViewModelStore
 * @return viewModel registered in the scope of provided activity
 */
inline fun <reified VM: ViewModel> FragmentActivity.obtainRegisteredViewModel(
    noinline modelProvider: () -> VM
) = ViewModelProvider(this, object : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelProvider.invoke() as T
    }
}).get(VM::class.java)

/**
 * Register ViewModel in the fragment's ViewModelStore
 * @return viewModel registered in the scope of provided fragment
 */
inline fun <reified VM: ViewModel> Fragment.obtainRegisteredViewModel(
    noinline modelProvider: () -> VM
) = ViewModelProvider(this, object : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelProvider() as T
    }
}).get(VM::class.java)