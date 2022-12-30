package com.kerberos.eucossa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationBarView
import com.kerberos.eucossa.R

class MainFragment : Fragment() {

    private var selectedFragment : Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadFragment(HomeFragment())
        val bottomNavigationView: BottomNavigationView = view.findViewById(R.id.bottomNavigationView)
        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container_home,CommunitiesFragment())
                .commit()
            bottomNavigationView.selectedItemId = R.id.placeholder
        }

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.events -> {
                    loadFragment(EventsFragment())
                    true
                }
                R.id.groups -> {
                    loadFragment(GroupsFragment())
                    true
                }
                R.id.messages -> {
                    loadFragment(MessagesFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
    private fun loadFragment(fragment: Fragment){
        //new instances
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container_home,fragment)
            .commit()
    }
}