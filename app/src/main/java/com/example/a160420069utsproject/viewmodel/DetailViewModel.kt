package com.example.a160420069utsproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160420069utsproject.model.Library

class DetailViewModel:ViewModel() {
    val libraryLD = MutableLiveData<Library>()

    fun fetch() {
        val book1 =
            Library("16055","Programming Basics with C#","Book for learning basic C#",
                "https://csharp-book.softuni.org/assets/CSharp-Programming-Basics-Book-Cover.png")
        val book2 =
            Library("13312","Python Programming for Beginners","Book for learning basic Python",
                "https://m.media-amazon.com/images/I/61gMsOrAOtL._AC_UF1000,1000_QL80_.jpg")
        val book3 =
            Library("11204","Learn Java in one day and LEARN IT WELL","Book for learning basic Java",
                "https://m.media-amazon.com/images/I/41Vt1zmwXjL.jpg")
        libraryLD.value = book1
    }
}