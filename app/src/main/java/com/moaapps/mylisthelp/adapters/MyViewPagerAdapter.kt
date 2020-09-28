package com.moaapps.mylisthelp.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyViewPagerAdapter(val fragmentManager: FragmentManager) : FragmentPagerAdapter(
    fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    var fragments = ArrayList<Fragment>()

    override fun getCount(): Int {
        Log.d("TAG", "getCount: ${fragments.size}")
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
//        when(position){
//            0-> return MyWaitingFragment()
//            1-> return MyAcceptedFragment()
//            2-> return MyCancelledFragment()
//        }

        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "قيد الإنتظار"
            1 -> return "تم القبول"
            2 -> return "تم الإلغاء"
        }
        return ""
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    @JvmName("setFragments1")
    fun setFragments(list: ArrayList<Fragment>){

        fragments.clear()
        fragments.addAll(list)

        notifyDataSetChanged()
    }

    fun clear(){
        for (i in fragments.indices) {
            fragmentManager.beginTransaction().remove(fragments[i]).commit()
        }
        notifyDataSetChanged()
    }

}