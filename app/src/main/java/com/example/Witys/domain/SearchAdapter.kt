package com.example.Witys.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Witys.R
import com.squareup.picasso.Picasso

class SearchAdapter: RecyclerView.Adapter<SearchAdapter.SearchHolder>() {
   companion object

    var my_position:Int? = 0

    class SearchHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var smoke:TextView
        lateinit var alko:TextView
        lateinit var child:TextView
        lateinit var pet:TextView
        fun bind(position: Int){
            var photo = itemView.findViewById<ImageView>(R.id.search_photo)
            var name = itemView.findViewById<TextView>(R.id.search_name_txt)
            var aboutMe = itemView.findViewById<TextView>(R.id.search_about_me)
            var aboutPerson = itemView.findViewById<TextView>(R.id.search_about_person)
            var aboutHobby = itemView.findViewById<TextView>(R.id.search_about_hobby)

            var list_me = arrayListOf<String>("Учусь в вузе", "Люблю путешествия", "Работаю менеджером")
            var list_person = arrayListOf<String>("Ищу с кем провести лето",
                "Буду рад найти друга или подругу", "Ищу компанию")
            var list_hobby = arrayListOf<String>("Рисование, Музыка", "Книги, Фильмы", "Бег, Прогулки")
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
            aboutMe.setText(list_me[position])
            aboutPerson.setText(list_person[position])
            aboutHobby.setText(list_hobby[position])
            smoke = itemView.findViewById(R.id.smoke_search)
            alko = itemView.findViewById(R.id.alco_search)
            child = itemView.findViewById(R.id.child_search)
            pet = itemView.findViewById(R.id.pet_search)
            if(position%3  == 0){
                smoke.setBackgroundResource(R.drawable.base_background_green)
            }
            if (position%2 == 0){
                alko.setBackgroundResource(R.drawable.base_background_green)
            }
            if(position%1 == 0){
                child.setBackgroundResource(R.drawable.base_background_green)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.search_item_layout,
            parent, false)
        return SearchHolder(view)

    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        setPosition(position)
        holder.bind(position)

    }

    override fun getItemCount(): Int {
     return 3
    }

    fun getPosition():Int{
        return my_position!!

    }
   fun setPosition(position: Int){
       my_position = position

    }

}