package com.android.wifiscanner.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.wifiscanner.databinding.RowItemBinding

import com.android.wifiscanner.model.database.ListData

class WifiListAdapter : ListAdapter<ListData, WifiListAdapter.MyViewHolder>(WifiscanCallbacks()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class MyViewHolder private constructor(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ListData) {
            binding.recylerListdata = item
            binding.executePendingBindings()
        }


        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowItemBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }


    class WifiscanCallbacks : DiffUtil.ItemCallback<ListData>() {
        override fun areItemsTheSame(oldItem: ListData, newItem: ListData): Boolean {
            return oldItem.wifiname == newItem.wifiname
        }

        override fun areContentsTheSame(oldItem: ListData, newItem: ListData): Boolean {
            return oldItem.wifiStrength == newItem.wifiStrength
        }

    }
}