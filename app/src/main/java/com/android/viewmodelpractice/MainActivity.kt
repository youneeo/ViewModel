package com.android.viewmodelpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.android.viewmodelpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivitiyViewModel

    // 더하기 결과를 받을 변수
    var total : Int = 0
    // total에 더할 숫자를 받을 변수
    var a : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // databinding 적용
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        // viewModel의 주최를 MainActivityViewModel로 설정
        viewModel = ViewModelProvider(this).get(MainActivitiyViewModel::class.java)
        // getTotal()를 호출해 현재 total(현재 값 : 0 ) 을 불러온다.
        binding.textSum.text = viewModel.getTotal().toString()

        binding.buttonCount.setOnClickListener {
            //setTotal()을 호출해 edittext의 값을 total에 더한다..
            viewModel.setTotal(binding.countEditText.text.toString().toInt())
            //현재 값을 불러온다.
            binding.textSum.text = viewModel.getTotal().toString()
        }
    }
}