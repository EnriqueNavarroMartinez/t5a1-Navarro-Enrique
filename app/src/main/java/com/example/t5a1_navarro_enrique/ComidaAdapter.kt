package com.example.t5a1_navarro_enrique

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.t5a1_navarro_enrique.databinding.ItemComidaBinding


class ComidaAdapter (private val comidas : List<Comida>, private val listener: OnClickListener): RecyclerView.Adapter<ComidaAdapter.ViewHolder>() {

    private lateinit var context : Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_comida, parent, false)
        return ViewHolder(view)
    }



    override fun getItemCount(): Int = comidas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comida = comidas.get(position)
        with(holder){
            setListener(comida)
            binding.nombre.text = comida.nombre
            Glide.with(context).load(comida.url).diskCacheStrategy(DiskCacheStrategy.ALL).circleCrop().into(binding.imgFoto)
        }
    }

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val binding = ItemComidaBinding.bind(view) //Vinculamos la vista a nuestro adapter

        fun setListener(comida: Comida){
            binding.root.setOnClickListener{
                listener.onClick(comida)
            }
        }
    }

}