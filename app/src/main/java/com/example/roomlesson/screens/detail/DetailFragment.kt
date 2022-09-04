package com.example.roomlesson.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.roomlesson.APP
import com.example.roomlesson.R
import com.example.roomlesson.databinding.FragmentDetailBinding
import com.example.roomlesson.model.NoteModel


class DetailFragment : Fragment() {
lateinit var binding: FragmentDetailBinding
lateinit var curentNote: NoteModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        curentNote =  arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.tvTitleDetail.text = curentNote.title
        binding.tvDescDetail.text = curentNote.description

        binding.btnDelete.setOnClickListener{
            viewModel.delete(curentNote){}
                APP.navController.navigate(R.id.action_detailFragment_to_startFragment)

        }

        binding.btnBack.setOnClickListener{
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)}

    }

}