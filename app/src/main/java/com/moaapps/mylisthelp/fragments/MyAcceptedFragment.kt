package com.moaapps.mylisthelp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.moaapps.mylisthelp.R
import com.moaapps.mylisthelp.adapters.IssuesAdapter
import com.moaapps.mylisthelp.pojo.Issue
import kotlinx.android.synthetic.main.fragment_my_accepted.*

class MyAcceptedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_accepted, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = ArrayList<Issue>()
        list.add(Issue("عنوان 1", R.drawable.type_car))
        list.add(Issue("عنوان 2", R.drawable.type_food))
        list.add(Issue("عنوان 3", R.drawable.type_car))
        list.add(Issue("عنوان 4", R.drawable.type_car))

        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = IssuesAdapter(list)
    }

}