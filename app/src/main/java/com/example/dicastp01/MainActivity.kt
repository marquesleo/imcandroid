package com.example.dicastp01

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.dicastp01.data.RegistroPeso

import com.example.dicastp01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val retornoActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult())
    { activityResult ->
        if (activityResult.resultCode == RESULT_OK) {
            activityResult.data?.let {
                if (it.hasExtra(TAG)) {
                    val retorno = if (Build.VERSION.SDK_INT >= 33) {
                        it.getParcelableExtra(TAG, RegistroPeso::class.java)
                    } else {
                        it.getParcelableExtra(TAG)
                    }
                }

            }

        }
    }




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