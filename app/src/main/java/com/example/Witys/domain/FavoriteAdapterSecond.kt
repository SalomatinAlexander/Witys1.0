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

class FavoriteAdapterSecond(_context:Context):
    RecyclerView.Adapter<FavoriteAdapterSecond.FavoriteHolderSecond>() {
    var context = _context
    class FavoriteHolderSecond(itemView: View, _context: Context)
        : RecyclerView.ViewHolder(itemView){
        var context = _context
        fun bind(position: Int){
            var photo = itemView.findViewById<ImageView>(R.id.favorites_item_photo)
            var name = itemView.findViewById<TextView>(R.id.favorite_name)
            var list_name = arrayListOf<String>("Анжелика", "Илья ",
                "Ангелина", "Георгий",
                "Екатерина", "Артем",
                "Даша", "Даниил")
            name.setText(list_name[position])
            var links = arrayListOf<String>("https://vetradenis.ru/uploads/all/6a/5e/e6/6a5ee6c4efd5054796b4e4abff78016f.jpg"
                , "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTV7XXRpexnJt0HvmMOh8WIx3zWdu8XluBqNQ&usqp=CAU"
                , "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQf96fmCwPWgOhOuCdCFpyQQaIAVSgyJ9rlww&usqp=CAU",
                "https://www.e-xecutive.ru/uploads/article/image/1987899/thumb_maxim_denisov.jpg"
                ,"https://ta-aspect.by/wp-content/uploads/2019/12/pogodina.jpeg")
            Picasso.get().load(links[position]).into(photo)
            itemView.setOnClickListener{
                var fragment = FavoriteAnketFragment()
                var bundle = Bundle()

                bundle.putStringArray("FAVORITE", arrayOf(list_name[position], "${position%2}", "$position", links[position]))
                fragment.arguments = bundle

                val manager: FragmentManager = (context as AppCompatActivity).supportFragmentManager
                manager.beginTransaction()
                    .replace(R.id.profil_container_id, fragment)
                    .addToBackStack("communicated").commit()
            }
        }


}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteHolderSecond {
        var view = LayoutInflater.from(parent.context).inflate(
            R.layout.favorite_item_layout,
            parent, false)
        return  FavoriteHolderSecond(view, context)
    }

    override fun onBindViewHolder(holder: FavoriteHolderSecond, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return 2
    }
}