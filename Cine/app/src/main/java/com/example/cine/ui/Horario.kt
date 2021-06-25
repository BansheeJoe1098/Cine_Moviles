package com.example.cine.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.cine.R
import com.example.cine.adapter.HorariosAdapter
import com.example.cine.databinding.HorarioFragmentBinding
import com.example.cine.models.Boleto
import com.example.cine.models.Exibicion
import com.example.cine.ui.GlobalViewModel

class Horario : Fragment() {

    private  val viewModel: GlobalViewModel by activityViewModels()

    private var _binding: HorarioFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HorarioFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var numBoletos = 0
        viewModel.getSelcPeli.observe(viewLifecycleOwner, Observer {

            binding.imghorario.setImageResource(it.img)

            binding.nompelicula.setText(it.nombre)

            binding.lwhorario.adapter =  object :
                HorariosAdapter(view.context,R.layout.card_horario,it.exibicion){
                override fun selechorario(exibicion: Exibicion) {
                    val compra = Boleto(it,exibicion,numBoletos)
                    viewModel.setcompra(compra)
                    findNavController().navigate(R.id.action_horario_to_nav_ticket_MDB)
                }

            }
        })

        binding.ABoleto.setOnClickListener {
            numBoletos++

            val precio = numBoletos * 72
            binding.lvBoletos.text = numBoletos.toString()
            binding.lvPrecio.text = "$ $precio"
        }
    }



}