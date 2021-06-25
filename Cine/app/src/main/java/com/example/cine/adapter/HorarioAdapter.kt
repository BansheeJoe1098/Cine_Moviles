package com.example.cine.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.cine.R
import com.example.cine.models.Exibicion
import com.example.cine.models.Movies

abstract class HorariosAdapter(val context: Context, val layout: Int, val lista: ArrayList<Exibicion>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Any {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return -1
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val miView = inflater.inflate(layout, null)

        val hora = miView.findViewById<TextView>(R.id.FechaExibicion)
        val fecha = miView.findViewById<TextView>(R.id.HoraExibicion)
        val item = miView.findViewById<CardView>(R.id.itemexibicion)

        hora.text = lista[position].hora
        fecha.text = lista[position].fecha

        item.setOnClickListener {
            val exibicion = Exibicion(lista[position].fecha, lista[position].hora)
            selechorario(exibicion)

        }

        return miView
    }
    abstract fun selechorario(exibicion: Exibicion)
}