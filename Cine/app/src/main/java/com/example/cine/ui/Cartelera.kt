package com.example.cine.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cine.R
import com.example.cine.adapter.CarteleraAdapter
import com.example.cine.databinding.CarteleraFragmentBinding
import com.example.cine.models.Exibicion
import com.example.cine.models.Movies
import java.util.ArrayList


class Cartelera : Fragment() {

    private  val viewModel: GlobalViewModel by activityViewModels()

    private var _binding: CarteleraFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CarteleraFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val exibicion = ArrayList<Exibicion>()
        exibicion.add(Exibicion("11:00","15 Feb 2021"))
        exibicion.add(Exibicion("11:30","15 Feb 2021"))
        exibicion.add(Exibicion("11:50","15 Feb 2021"))
        exibicion.add(Exibicion("12:10","15 Feb 2021"))


        val peliculas = ArrayList<Movies>()
        peliculas.add(Movies("Star Wars",R.drawable.star_wars_el_ascenso_de_skywalker,exibicion))
        peliculas.add(Movies("Toy Story 2",R.drawable.toy_story,exibicion))
        peliculas.add(Movies("Joker",R.drawable.joker,exibicion))

        binding.rvCartelera.adapter =
            object : CarteleraAdapter(view.context,peliculas,R.layout.movie_layout){
                override fun damePelicula(pelicula: Movies) {
                            viewModel.setSelecPeli(pelicula)
                            findNavController().navigate(R.id.action_nav_cartelera_MDB_to_horario)
                }

            }
        binding.rvCartelera.layoutManager = GridLayoutManager(view.context,3)

    }
}