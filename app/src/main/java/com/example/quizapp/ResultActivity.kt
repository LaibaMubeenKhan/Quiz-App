package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityResultBinding



class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    var list = mutableListOf<ResultDataClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = intent.getParcelableArrayListExtra<ResultDataClass>("ResultList")
        val adapter= list?.let { RecylerView(it,this) }
        binding.recyclerView.adapter=adapter
        binding.button.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }
}