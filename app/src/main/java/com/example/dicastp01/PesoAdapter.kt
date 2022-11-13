package com.example.dicastp01

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dicastp01.data.RegistroPeso
import com.example.dicastp01.databinding.ListItemRegistroPesoBinding


class PesoAdapter(val items:List<RegistroPeso>) :RecyclerView.Adapter<PesoAdapter.PesoViewHolder>() {

     private lateinit var binding: ListItemRegistroPesoBinding
     inner class PesoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
     {
         fun bind(peso:RegistroPeso){
             binding.apply {
                 tvPeso.text = peso.peso.toString()
                 tvFaixaEtaria.text = peso.faixaEtaria
             }
         }
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PesoViewHolder {
        binding = ListItemRegistroPesoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PesoViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PesoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}