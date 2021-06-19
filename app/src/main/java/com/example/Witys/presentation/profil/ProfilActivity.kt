package com.example.Witys.presentation.profil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.Witys.R
import com.example.Witys.presentation.profil.favorite.FavoriteFragment
import com.example.Witys.presentation.profil.message.MessageFragment

class ProfilActivity : AppCompatActivity() {
    lateinit var mPersonImgView:LinearLayout
    lateinit var mFavoriteImgView:LinearLayout
    lateinit var mMessageImgView:LinearLayout
    lateinit var mSearchImgView:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        replaceMyFragment(ProfilFragment())
        mPersonImgView = findViewById(R.id.person_img_toolbar_general)
        mFavoriteImgView = findViewById(R.id.favorite_img_toolbar_general)
        mMessageImgView = findViewById(R.id.message_img_toolbar_general)
        mSearchImgView = findViewById(R.id.search_img_toolbar_general)
        mPersonImgView.setBackgroundColor(resources.getColor(R.color.toolbar_selected_color))
        mFavoriteImgView.setBackgroundColor(resources.getColor(R.color.view_back_color))
        mMessageImgView.setBackgroundColor(resources.getColor(R.color.view_back_color))
        mSearchImgView.setBackgroundColor(resources.getColor(R.color.view_back_color))

        replaceMyFragment(ProfilFragment())

        mPersonImgView.setOnClickListener{
            mPersonImgView.setBackgroundColor(resources.getColor(R.color.toolbar_selected_color))
            mFavoriteImgView.setBackgroundColor(resources.getColor(R.color.view_back_color))
            mMessageImgView.setBackgroundColor(resources.getColor(R.color.view_back_color))
            mSearchImgView.setBackgroundColor(resources.getColor(R.color.view_back_color))
            replaceMyFragment(ProfilFragment())
        }
        mFavoriteImgView.setOnClickListener{
            mPersonImgView.setBackgroundColor(resources.getColor(R.color.view_back_color))
            mFavoriteImgView.setBackgroundColor(resources.getColor(R.color.toolbar_selected_color))
            mMessageImgView.setBackgroundColor(resources.getColor(R.color.view_back_color))
            mSearchImgView.setBackgroundColor(resources.getColor(R.color.view_back_color))
            replaceMyFragment(FavoriteFragment())
        }
        mMessageImgView.setOnClickListener{
            mPersonImgView.setBackgroundColor(resources.getColor(R.color.view_back_color))
            mFavoriteImgView.setBackgroundColor(resources.getColor(R.color.view_back_color))
            mMessageImgView.setBackgroundColor(resources.getColor(R.color.toolbar_selected_color))
            mSearchImgView.setBackgroundColor(resources.getColor(R.color.view_back_color))
            replaceMyFragment(MessageFragment())
        }
        mSearchImgView.setOnClickListener{
            mPersonImgView.setBackgroundColor(resources.getColor(R.color.view_back_color))
            mFavoriteImgView.setBackgroundColor(resources.getColor(R.color.view_back_color))
            mMessageImgView.setBackgroundColor(resources.getColor(R.color.view_back_color))
            mSearchImgView.setBackgroundColor(resources.getColor(R.color.toolbar_selected_color))
            replaceMyFragment(SearchFragment())

        }

    }
    fun replaceMyFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(
            R.id.profil_container_id,
            fragment, "regist").commit()

    }
}