package com.example.Witys.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Witys.R

class CommunicationAdapter(_list:ArrayList<String>):
    RecyclerView.Adapter<CommunicationAdapter.CommunicationHolder>() {
    var list = _list

    class CommunicationHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(msg:String){
            var msgTxt = itemView.findViewById<TextView>(R.id.message_item_id)
            msgTxt.text = msg

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunicationHolder {
        var view  = LayoutInflater.from(parent.context).inflate(R.layout.communication_item_view,
            parent, false)
        return CommunicationHolder(view)

    }

    override fun onBindViewHolder(holder: CommunicationHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }
}