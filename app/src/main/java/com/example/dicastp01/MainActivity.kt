package com.example.dicastp01

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicastp01.data.MainViewModel
import com.example.dicastp01.data.RegistroPeso

import com.example.dicastp01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    private val retornoActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult())
    { activityResult ->
        if (activityResult.resultCode == RESULT_OK) {
            activityResult.data?.let {
                if (it.hasExtra(TAG)) {
                    val retorno = if (Build.VERSION.SDK_INT >= 33) {
                        it.getParcelableExtra<RegistroPeso>(TAG)
                    } else {
                        it.getParcelableExtra(TAG)
                    }

                    mainViewModel.salvarNovoRegistro(retorno)
                }
            }

        }
    }

    private fun configObservers() {
        configurarListaPesoObserver()
    }

    private fun configurarListaPesoObserver(){
        mainViewModel.listaPeso.observe(this) { listaPeso ->

            prepararRecyclerView(listaPeso)
        }
    }

    private fun prepararRecyclerView(listaPeso: List<RegistroPeso>?) {
        binding.rvItens.layoutManager = LinearLayoutManager(applicationContext)
        if (listaPeso.isNullOrEmpty()){
            binding.tvQtd.setText(R.string.nao_existem_itens)
        }else
        {
            binding.apply {
                rvItens.adapter = PesoAdapter(listaPeso)
                tvQtd.text = resources.getQuantityString(
                    R.plurals.quantidade_peso,
                    listaPeso.size,
                    listaPeso.size
                )
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding    = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        congigurarListeners()
        configObservers()
    }

    private fun congigurarListeners() {
        configurarFabListener()

    }

    private fun iniciarNovaActivity() {

       Intent(this, CadastroActivity::class.java).let{
           retornoActivity.launch(it)
       }
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