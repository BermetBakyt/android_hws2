package com.ber.android_hws.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.ber.android_hws.R
import com.ber.android_hws.database.Employee
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private val click: (pos: Int) -> Unit) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private var list = listOf<String>()
    private var employeeList = emptyList<Employee>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_row, parent, false)
        return RecyclerView.ViewHolder(itemView, click)
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = employeeList[position]
        holder.itemView.textID.text = currentItem.id.toString()
        holder.itemView.textName.text = currentItem.name
        holder.itemView.textCompany.text = currentItem.company
        holder.itemView.textSalary.text = currentItem.salary.toString()
        holder.itemView.customRowLayout.setOnClickListener{
        }
    }

    class ViewHolder(
        itemView: View,
        private val click: (pos: Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: String) {
            val txt = itemView.findViewById<AppCompatTextView>(R.id.te)
            txt.text = item
            itemView.setOnClickListener {
                click.invoke(adapterPosition)
            }
        }
    )

    fun setData(employee: List<Employee>) {
        this.employeeList = employee
        notifyDataSetChanged()
    }
}