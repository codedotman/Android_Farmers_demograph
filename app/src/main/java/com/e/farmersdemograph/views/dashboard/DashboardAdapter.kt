package com.e.farmersdemograph.views.dashboard

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.farmersdata.data.models.FarmersData
import com.e.farmersdemograph.R
import kotlinx.android.synthetic.main.list_project.view.*

class DashboardAdapter(private val listItemClickListener: ItemClickListener): RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {
    private var resultList: List<FarmersData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.list_project,
            parent, false)
        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val result = resultList[position]

        holder.age.text = result.age
        holder.name.text = result.name
        holder.address.text = result.address
    }

    interface ItemClickListener {
        fun onListItemClick(farmersData: FarmersData)
    }


    inner class DashboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        init {
            itemView.setOnClickListener(this)
        }


        val name = itemView.name_header
        val address = itemView.address_sub_head
        val age = itemView.age_sub_head
        override fun onClick(v: View?) {
            val data = resultList!![adapterPosition]

            listItemClickListener.onListItemClick(data)
        }


    }

    fun setItems(farmersData: List<FarmersData>) {
        resultList = farmersData
        notifyDataSetChanged()

    }
}