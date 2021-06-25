package com.example.cine.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.cine.R
import com.example.cine.adapter.TicketsAdapter
import com.example.cine.databinding.CarteleraFragmentBinding
import com.example.cine.databinding.TicketFragmentBinding

class Ticket : Fragment() {



    private  val viewModel: GlobalViewModel by activityViewModels()

    private var _binding: TicketFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TicketFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getcompras.observe(viewLifecycleOwner, Observer {
            binding.lvBoletosT.adapter = TicketsAdapter(view.context,R.layout.boleto,it)
        })

    }



}