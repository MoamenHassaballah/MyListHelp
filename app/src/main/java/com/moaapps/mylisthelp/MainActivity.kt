package com.moaapps.mylisthelp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.moaapps.mylisthelp.adapters.MyViewPagerAdapter
import com.moaapps.mylisthelp.fragments.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        setContentView(R.layout.activity_main)

        val fragmentsList = ArrayList<Fragment>()
        fragmentsList.add(MyWaitingFragment())
        fragmentsList.add(MyAcceptedFragment())
        fragmentsList.add(MyCancelledFragment())

        val othersFragmentsList = ArrayList<Fragment>()
        othersFragmentsList.add(OthersWaitingFragment())
        othersFragmentsList.add(OthersAcceptedFragment())
        othersFragmentsList.add(OthersCancelledFragment())

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        val adapter2 = MyViewPagerAdapter(supportFragmentManager)

        my_issues.setOnClickListener {
            updateButton(my_issues, other_issues)
            adapter.setFragments(fragmentsList)
            view_pager.visibility = View.VISIBLE
            other_view_pager.visibility = View.GONE
            tabLayout.setupWithViewPager(view_pager)
        }

        other_issues.setOnClickListener {
            updateButton(other_issues, my_issues)
            view_pager.visibility = View.GONE
            other_view_pager.visibility = View.VISIBLE
            tabLayout.setupWithViewPager(other_view_pager)
        }


        tabLayout.setupWithViewPager(view_pager)
        view_pager.adapter = adapter
        other_view_pager.adapter = adapter2
        adapter.setFragments(fragmentsList)
        adapter2.setFragments(othersFragmentsList)


    }



    private fun updateButton(pressed: Button, released: Button){
        pressed.background = ContextCompat.getDrawable(this, R.drawable.nav_tab_btn)
        pressed.setTextColor(Color.BLACK)
        released.background = ContextCompat.getDrawable(this, android.R.color.transparent)
        released.setTextColor(Color.GRAY)
    }
}