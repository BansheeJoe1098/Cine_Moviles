package com.example.cine.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cine.models.Boleto
import com.example.cine.models.Movies

class GlobalViewModel : ViewModel() {

    private val selecPeli = MutableLiveData<Movies>()

    val getSelcPeli : LiveData<Movies> get() = selecPeli

    fun setSelecPeli(pelicula: Movies){
        selecPeli.value = pelicula

    }
    private val compras = MutableLiveData<ArrayList<Boleto>>().apply { postValue(ArrayList()) }
    val getcompras : LiveData<ArrayList<Boleto>>get() = compras

    fun setcompra(boleto: Boleto){
        compras.value?.add(boleto)
    }



}