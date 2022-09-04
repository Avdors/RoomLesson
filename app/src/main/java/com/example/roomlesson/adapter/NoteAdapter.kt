package com.example.roomlesson.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomlesson.R
import com.example.roomlesson.databinding.ItemLayoutBinding
import com.example.roomlesson.model.NoteModel
import com.example.roomlesson.screens.start.StartFragment
import kotlinx.coroutines.MainScope

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    lateinit var binding: ItemLayoutBinding
    var listNote = emptyList<NoteModel>()

    class NoteViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
       return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        binding.itemTitle.text = listNote[position].title
    }

    override fun getItemCount(): Int {
     return listNote.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>){
        listNote = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            StartFragment.clickNote(listNote[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}