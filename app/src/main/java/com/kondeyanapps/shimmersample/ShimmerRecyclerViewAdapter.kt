package com.kondeyanapps.shimmersample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kondeyanapps.shimmersample.model.Accounts

class ShimmerRecyclerViewAdapter(var data: List<Accounts>) :
        RecyclerView.Adapter<ShimmerRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.account_cell, parent, false))

    }

    fun updateData(list: List<Accounts>){
        data = list
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.accountNameTextView.text = data[position].name
        holder.accountNumberTextView.text = data[position].accountNumber
        holder.totalBalanceTextView.text = data[position].totalBalance
        holder.availableBalanceTextView.text = data[position].availableBalance
    }

    override fun getItemCount() = data.size

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        val accountNameTextView = v.findViewById<TextView>(R.id.accountName)
        val accountNumberTextView = v.findViewById<TextView>(R.id.accountNumber)
        val totalBalanceTextView = v.findViewById<TextView>(R.id.totalBalance)
        val availableBalanceTextView = v.findViewById<TextView>(R.id.availableBalance)

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

    }

}
