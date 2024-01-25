package com.android.viewmodelpractice

import androidx.lifecycle.ViewModel

class MainActivitiyViewModel : ViewModel() {

    private var total = 0

    fun getTotal(): Int{
        return total
    }
    // 숫자를 더할 때 사용할 함수
    fun setTotal(input : Int){
        total += input
    }
}