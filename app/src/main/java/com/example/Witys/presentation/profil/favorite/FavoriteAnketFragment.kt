package com.example.Witys.presentation.profil.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.Witys.R
import com.squareup.picasso.Picasso
import java.security.AlgorithmConstraints

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteAnketFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoriteAnketFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var nameTxt: TextView
    lateinit var aboutMeTxt: TextView
    lateinit var aboutPersonTxt: TextView
    lateinit var hobbyTxt: TextView
    lateinit var photoImg: ImageView
    lateinit var smoke:TextView
    lateinit var alko:TextView
    lateinit var child:TextView
    lateinit var pet:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view  = inflater.inflate(R.layout.fragment_favorite_anket,
            container, false)
        smoke = view.findViewById(R.id.smoke_txt)
        alko = view.findViewById(R.id.alco_txt)
        child = view.findViewById(R.id.child_txt)
        pet = view.findViewById(R.id.pet_txt)

        nameTxt = view.findViewById(R.id.search_name_txt_anket)
        aboutMeTxt = view.findViewById(R.id.search_about_me_anket)
        aboutPersonTxt = view.findViewById(R.id.search_about_person_anket)
        photoImg = view.findViewById(R.id.search_photo_anket)
        hobbyTxt = view.findViewById(R.id.search_about_hobby_anket)
        var list_about_me = arrayOf("Учусь в вузе", "Работаю продавцом", "Люблю путешествия")
        var list_about_person = arrayOf("Ищу вторую половинку", "Ищу друзей", "Ищу компанию на лето")
        var list_about_nobby = arrayOf("Бег, Вязание ", "Языки, Психология","Чтение, Фильмы")
        var list_vlaues = requireArguments().getStringArray("FAVORITE")
        var num = list_vlaues?.get(2)!!.toInt()
        aboutMeTxt.setText(list_about_me[num])
        aboutPersonTxt.setText(list_about_person[num])
        hobbyTxt.setText(list_about_nobby[num])
        nameTxt.setText(list_vlaues?.get(0))
        if(num%3  == 0){
            smoke.setBackgroundResource(R.drawable.base_background_green)
        }
        if (num%2 == 0){
            alko.setBackgroundResource(R.drawable.base_background_green)
        }
        if(num%4 == 0){
            child.setBackgroundResource(R.drawable.base_background_green)
        }

            Picasso.get().load(list_vlaues[3]).into(photoImg)

      //  aboutMeTxt.setText(list_vlaues?.get(1))
      //  aboutPersonTxt.setText(list_vlaues?.get(2))
      //  hobbyTxt.setText(list_vlaues?.get(3))


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FavoriteAnketFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavoriteAnketFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}