package com.example.Witys.domain

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Witys.R
import com.example.Witys.presentation.profil.favorite.FavoriteAnketFragment
import com.squareup.picasso.Picasso

class FavoriteAdapter(_context:Context): RecyclerView.Adapter<FavoriteAdapter.FavoriteHolder>() {
    var context = _context
    class FavoriteHolder(itemView: View, _context: Context) : RecyclerView.ViewHolder(itemView){
        var context = _context
        fun bind(position: Int) {
            var photo = itemView.findViewById<ImageView>(R.id.favorites_item_photo)
            var name = itemView.findViewById<TextView>(R.id.favorite_name)
            var links = arrayListOf<String>("https://vetradenis.ru/uploads/all/6a/5e/e6/6a5ee6c4efd5054796b4e4abff78016f.jpg"
            , "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTV7XXRpexnJt0HvmMOh8WIx3zWdu8XluBqNQ&usqp=CAU"
            , "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQf96fmCwPWgOhOuCdCFpyQQaIAVSgyJ9rlww&usqp=CAU",
                "https://www.e-xecutive.ru/uploads/article/image/1987899/thumb_maxim_denisov.jpg")
            var list_name = arrayListOf<String>("Анжелика", "Илья ",
                "Ангелина", "Георгий",
                "Екатерина", "Артем",
                "Даша", "Даниил")
            name.setText(list_name[position])
            if (position%2 == 0){ photo.setImageResource(R.drawable.avatar_3)}
            Picasso.get()
                .load(links[position])
                .into(photo)
            itemView.setOnClickListener{
                var fragment = FavoriteAnketFragment()
                var bundle = Bundle()
                bundle.putStringArray("FAVORITE", arrayOf(list_name[position], "${position%2}", "$position", links[position], ))
                fragment.arguments = bundle
                val manager: FragmentManager = (context as AppCompatActivity).supportFragmentManager
                manager.beginTransaction()
                    .replace(R.id.profil_container_id, fragment)
                    .addToBackStack("communicated").commit()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteHolder {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.favorite_item_layout,
           parent, false)
        return  FavoriteHolder(view, context)
    }

    override fun onBindViewHolder(holder: FavoriteHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return 3
    }
}