package com.jxareas.cocktails.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.jxareas.cocktails.ui.adapters.HomePageAdapter
import com.jxareas.cocktails.databinding.FragmentHomeViewPagerBinding

class HomeViewPagerFragment : Fragment() {
    private var _binding: FragmentHomeViewPagerBinding? = null
    private val binding: FragmentHomeViewPagerBinding
        get() = _binding!!

    private lateinit var homeAdapter: HomePageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPagerWithTabLayout()
    }

    private fun setupViewPagerWithTabLayout() = binding.run {
        homeAdapter = HomePageAdapter(childFragmentManager, lifecycle)
        viewPager.adapter = homeAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, index ->
            tab.text = getString(homeAdapter.titles.elementAt(index))
            tab.setIcon(homeAdapter.icons.elementAt(index))
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
