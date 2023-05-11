package com.example.a160420069utsproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160420069utsproject.model.Library
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListViewModel(application: Application):AndroidViewModel(application) {
    val librarysLD = MutableLiveData<ArrayList<Library>>()
    val libraryLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        loadingLD.value = true
        libraryLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://gist.githubusercontent.com/Exylan12/7ac8dbeb0e4331eaef4550d1a26bf4ad/raw/539612d52585c3c0cd5bf5bf73afd180376c21bb/library.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<Library>>() { }.type
                val result = Gson().fromJson<ArrayList<Library>>(it, sType)
                librarysLD.value = result
                loadingLD.value = false

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                libraryLoadErrorLD.value = false
                loadingLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)

//        val book1 =
//            Library("1","Programming Basics with C#","Book for learning basic C#",
//                "https://csharp-book.softuni.org/assets/CSharp-Programming-Basics-Book-Cover.png")
//
//        val book2 =
//            Library("2","Python Programming for Beginners","Book for learning basic Python",
//                "https://m.media-amazon.com/images/I/61gMsOrAOtL._AC_UF1000,1000_QL80_.jpg")
//
//        val book3 =
//            Library("3","Learn Java in one day and LEARN IT WELL","Book for learning basic Java",
//                "https://m.media-amazon.com/images/I/41Vt1zmwXjL.jpg")
//        val libraryList:ArrayList<Library> = arrayListOf<Library>(book1, book2, book3)
//        librarysLD.value = libraryList
//        libraryLoadErrorLD.value = false
//        loadingLD.value = false
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}

