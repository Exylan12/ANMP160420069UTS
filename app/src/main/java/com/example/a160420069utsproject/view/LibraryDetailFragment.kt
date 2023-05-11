package com.example.a160420069utsproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160420069utsproject.R
import com.example.a160420069utsproject.viewmodel.DetailViewModel


class LibraryDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()
        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.libraryLD.observe(viewLifecycleOwner, Observer {
            val txtID = view?.findViewById<TextView>(R.id.txtId)
            val txtName = view?.findViewById<TextView>(R.id.textTitle)
            val txtDesc = view?.findViewById<TextView>(R.id.textDescription)

            txtID?.text = viewModel.libraryLD.value?.id
            txtName?.text = viewModel.libraryLD.value?.title
            txtDesc?.text = viewModel.libraryLD.value?.desc
        })
    }
}