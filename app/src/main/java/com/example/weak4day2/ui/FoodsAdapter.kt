package com.example.weak4day2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weak4day2.ui.settings.MySharedPref
import com.example.weak4day2.databinding.FoodsItemBinding



class FoodsAdapter(val setting: MySharedPref, val onItemClick:(item: Foods) -> Unit) : ListAdapter<Foods, RecyclerView.ViewHolder>(
    DIFF_CALLBACK
) {

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Foods>() {

            override fun areItemsTheSame(oldItem: Foods, newItem: Foods): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Foods, newItem: Foods): Boolean {
                return oldItem.name == newItem.name && oldItem.imageUrl == newItem.imageUrl
            }

        }
    }

    private lateinit var binding: FoodsItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        binding = FoodsItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)



    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item)
        }
    }

    inner class ViewHolder(private val itemBinding: FoodsItemBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Foods){
            itemBinding.tvName.text = item.name

            itemBinding.iv.setOnClickListener {
                onItemClick(item)
            }

            val pref = MySharedPref(itemBinding.tvName.context)
            binding.tvName.textSize = pref.getFont().toFloat()

//            itemBinding.tvName.setOnClickListener {
//                Toast.makeText(it.context,"name: ${item.name}", Toast.LENGTH_LONG).show()
//            }
            itemBinding.ivAvatar.setImageResource(item.imageUrl)
            }


        }
    }

