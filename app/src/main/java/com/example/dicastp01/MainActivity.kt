package com.example.dicastp01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.dicastp01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding    = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        congigurarListeners()
    }

    private fun congigurarListeners() {
        configurarFabListener()

    }

    private fun iniciarNovaActivity() {

        val intent = Intent(this,CadastroActivity::class.java).apply{

        }
        startActivity(intent)
    }

    private fun configurarFabListener(){
        binding.fabNovaActivity.setOnClickListener({
          iniciarNovaActivity()
        })
    }
    companion object {
        const val TAG = "PUC_EXEMPLO"
    }

}