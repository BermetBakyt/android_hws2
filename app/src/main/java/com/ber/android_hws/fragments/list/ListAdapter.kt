package com.ber.android_hws.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ber.android_hws.R
import com.ber.android_hws.model.Employee
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var employeeList = emptyList<Employee>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = employeeList[position]
        holder.itemView.textID.text = currentItem.id.toString()
        holder.itemView.textName.text = currentItem.name
        holder.itemView.textCompany.text = currentItem.company
        holder.itemView.textSalary.text = currentItem.salary.toString()
    }

    fun setData(employee: List<Employee>) {
        this.employeeList = employee
        notifyDataSetChanged()
    }
}