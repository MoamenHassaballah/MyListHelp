package com.moaapps.mylisthelp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moaapps.mylisthelp.R
import com.moaapps.mylisthelp.pojo.Issue

class IssuesAdapter(private val issues:ArrayList<Issue>, val isCancelled:Boolean=false):RecyclerView.Adapter<IssuesAdapter.Holder>() {



    class Holder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val image:ImageView = itemView.findViewById(R.id.img)
        val title:TextView = itemView.findViewById(R.id.title)
        val cancel:Button = itemView.findViewById(R.id.cancel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_issue, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val issue = issues[position]

        holder.title.text = issue.title
        holder.image.setImageResource(issue.image)
        if (isCancelled){
            holder.cancel.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return issues.size
    }
}