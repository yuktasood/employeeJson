package com.example.jsondemo2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class EmpAdapter(val context: Context,val list:ArrayList<EmployeeModel>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View= LayoutInflater.from(context).inflate(R.layout.row,parent, false)
        val id= view.findViewById<TextView>(R.id.emp_id_tv)
        val name = view.findViewById<TextView>(R.id.emp_name_tv)
        val location= view.findViewById<TextView>(R.id.emp_location_tv)
        val profileImage = view.findViewById<TextView>(R.id.emp_profile_image_iv)
        name.text = list[position].emp_name.toString()
        id.text= list[position].emp_id.toString()
        location.text= list[position].emp_location.toString()
        profileImage.text= list[position].emp_profile_image.toString()
        return view
    }

    override fun getItem(position: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return position
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return position.toLong()
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return list.size
    }

}