package com.example.a160420069utsproject.view

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420069utsproject.R
import com.example.a160420069utsproject.model.Library

class LibraryListAdapter(val libraryList:ArrayList<Library>): RecyclerView.Adapter<LibraryListAdapter.LibraryViewHolder>()
{
    class LibraryViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.library_list_item, parent, false)
        return LibraryViewHolder(view)
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        val txtID = holder.view.findViewById<TextView>(R.id.txtId)
        txtID.text = libraryList[position].id

        val txtTitle = holder.view.findViewById<TextView>(R.id.txtTitle)
        txtTitle.text = libraryList[position].title

        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
        btnDetail.setOnClickListener {
            val action = LibraryListFragmentDirections.actionLibraryDetail()
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return libraryList.size
    }

    fun updateStudentList(newLibraryList: ArrayList<Library>) {
        libraryList.clear()
        libraryList.addAll(newLibraryList)
        notifyDataSetChanged()
    }
}