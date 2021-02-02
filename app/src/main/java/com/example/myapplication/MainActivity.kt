package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        var currentFragment = 0

        binding.addBtn.setOnClickListener {
            val sum = sumInput(binding.firstNumEditText.text, binding.secondNumEditText.text)
            binding.resultTextView.text = sum.toString()
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment)
            commit()
            currentFragment = 1
            binding.currentFragmentTextView.text = "1"
        }

        binding.btnFragment1.setOnClickListener {
            if(currentFragment != 1) {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flFragment, firstFragment)
                    addToBackStack(null)
                    commit()
                    currentFragment = 1
                    binding.currentFragmentTextView.text = "1"
                }
            }
        }

        binding.btnFragment2.setOnClickListener {
            if(currentFragment != 2) {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flFragment, secondFragment)
                    addToBackStack(null)
                    commit()
                    currentFragment = 2
                    binding.currentFragmentTextView.text = "2"
                }
            }
        }
    }

    private fun sumInput(inputOne: Editable, inputTwo: Editable): Int {
        val numOne = Integer.parseInt(inputOne.toString())
        val numTwo = Integer.parseInt(inputTwo.toString())
        return numOne + numTwo
    }
}