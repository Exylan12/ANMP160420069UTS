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

class DetailViewModel(application: Application): AndroidViewModel(application) {
    val libraryLD = MutableLiveData<Library>()

    val TAG = "volleyTagDetail"
    private var queue: RequestQueue? = null
    fun fetch(book_id:String) {
        queue = Volley.newRequestQueue(getApplication())
        if (book_id == "1"){
            val url = "https://gist.githubusercontent.com/Exylan12/16eadcf3f157bc7529505c2afeee1d9a/raw/3901520e4e937995ad44e0ed78ee8d90e01ab948/adv1"
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                {
//                val sType = object : TypeToken<Student>() { }.type
                    val result = Gson().fromJson<Library>(it,
                        Library::class.java)
                    libraryLD.value = result

                    Log.d("showvoley2", result.toString())
                },
                {
                    Log.d("showvoley2", it.toString())
                })

            stringRequest.tag = TAG
            queue?.add(stringRequest)
        }
        if (book_id == "2"){
            val url = "https://gist.githubusercontent.com/Exylan12/3f378dcebd737bef49ebbeefa2ca8050/raw/89f05734dc82888f2b5b416fad93f0804bacb1c6/adv2"
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                {
//                val sType = object : TypeToken<Student>() { }.type
                    val result = Gson().fromJson<Library>(it,
                        Library::class.java)
                    libraryLD.value = result

                    Log.d("showvoley2", result.toString())
                },
                {
                    Log.d("showvoley2", it.toString())
                })

            stringRequest.tag = TAG
            queue?.add(stringRequest)
        }
        if (book_id == "3"){
            val url = "https://gist.githubusercontent.com/Exylan12/262d9e32cefd3e563c001ac0ddf20642/raw/e8cd98744c4eb91bfd8495441ba37e37866b7994/adv3"
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                {
//                val sType = object : TypeToken<Student>() { }.type
                    val result = Gson().fromJson<Library>(it,
                        Library::class.java)
                    libraryLD.value = result

                    Log.d("showvoley2", result.toString())
                },
                {
                    Log.d("showvoley2", it.toString())
                })

            stringRequest.tag = TAG
            queue?.add(stringRequest)
        }
    }
//        val url = "http://adv.jitusolution.com/student.php?id="+book_id

//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            {
////                val sType = object : TypeToken<Student>() { }.type
//                val result = Gson().fromJson<Library>(it,
//                    Library::class.java)
//                libraryLD.value = result
//
//                Log.d("showvoley2", result.toString())
//            },
//            {
//                Log.d("showvoley2", it.toString())
//            })
//
//        stringRequest.tag = TAG
//        queue?.add(stringRequest)
//    }
//        val book1 =
//            Library("1","Programming Basics with C#","Book for learning basic C#",
//                "https://csharp-book.softuni.org/assets/CSharp-Programming-Basics-Book-Cover.png")
//        val book2 =
//            Library("2","Python Programming for Beginners","Book for learning basic Python",
//                "https://m.media-amazon.com/images/I/61gMsOrAOtL._AC_UF1000,1000_QL80_.jpg")
//        val book3 =
//            Library("3","Learn Java in one day and LEARN IT WELL","Book for learning basic Java",
//                "https://m.media-amazon.com/images/I/41Vt1zmwXjL.jpg")
//        libraryLD.value = book1
}