package com.example.cine.adapter

import android.content.Context
import android.text.BoringLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.cine.R
import com.example.cine.models.Boleto

class TicketsAdapter(val context: Context,val layout: Int,val lista : ArrayList<Boleto>):
    BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val miView = inflater.inflate(layout,null)

        val img = miView.findViewById<ImageView>(R.id.imgpelit)
        val nombre = miView.findViewById<TextView>(R.id.tNPelicula)
        val exibicion = miView.findViewById<TextView>(R.id.thorario)
        val nAsientos = miView.findViewById<TextView>(R.id.tasient)

        img.setImageResource(lista[position].pelicula.img)
        nombre.text = lista[position].pelicula.nombre
        exibicion.text = "${lista[position].exibicion.fecha} - ${lista[position].exibicion.hora}"
        nAsientos.text = "${lista[position].numAsientos} x $ ${lista[position].numAsientos * 45}"

        return miView


    }

    override fun getItem(position: Int): Any {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return -1
    }

    override fun getCount(): Int {
        return lista.size
    }
}