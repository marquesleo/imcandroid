package com.example.dicastp01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.dicastp01.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        binding = ActivityCadastroBinding.inflate(layoutInflater)

        inicializarDados()



    }

    private fun configurarButtonListener(){
        binding.btnEnviar.setOnClickListener({

        })
    }



    private fun configurarRG(){

        binding.rgClassificacaoIdade.setOnCheckedChangeListener{_ , checkedId ->
            when(checkedId){
                R.id.rbAdulto -> {
                    Toast.makeText(this,"Adulto", Toast.LENGTH_LONG).show()
                    Log.d("PUCMINAS", "Adulto")
                }
                R.id.rbIdoso -> {
                    Toast.makeText(this,"Idoso", Toast.LENGTH_LONG).show()
                    Log.d("PUCMINAS", "Idoso")
                }
                else -> {
                    Toast.makeText(this,"Nenhum elemento selecionado", Toast.LENGTH_LONG).show()
                    Log.d("PUCMINAS", "Nenhum Elemento Selecionado")
                }
            }
        }

    }



    private fun inicializarDados() {
        val resultado = intent.getStringExtra(MainActivity.TAG)
        binding.tvResultado.text = resultado
    }
}