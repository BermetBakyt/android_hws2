package com.ber.android_hws.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.ber.android_hws.R
import com.ber.android_hws.database.Employee
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter (
    private val click: (id: Long) -> Unit) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    var employeeList = listOf<Employee>()

    fun setData(list: List<Employee>) {
        this.employeeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_row, parent, false)
        return ViewHolder(itemView, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employee = employeeList[position]
        holder.bind(employee)
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    class ViewHolder(
        itemView: View,
        private val click: (id: Long) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(employee: Employee) {
            val id = itemView.customRowLayout.findViewById<AppCompatTextView>(R.id.textID)
            val name = itemView.findViewById<AppCompatTextView>(R.id.textName)
            val company = itemView.findViewById<AppCompatTextView>(R.id.textCompany)
            val salary = itemView.findViewById<AppCompatTextView>(R.id.textSalary)

            id.text = employee.id.toString()
            name.text = employee.name
            company.text = employee.company
            salary.text = employee.salary.toString()

            itemView.setOnClickListener {
                click.invoke(employee.id!!)
            }
        }
    }
}