package com.tyr.example.kotlinexample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentsAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle,fragments:List<BaseFragment>) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val baseFragments = fragments

    override fun getItemCount(): Int {
        return baseFragments?.size
    }

    override fun createFragment(position: Int): Fragment {
        return baseFragments?.get(position)
    }
}