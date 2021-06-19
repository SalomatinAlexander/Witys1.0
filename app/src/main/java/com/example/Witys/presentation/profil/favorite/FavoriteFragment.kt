package com.example.Witys.presentation.profil.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Witys.R
import com.example.Witys.domain.FavoriteAdapter
import com.example.Witys.domain.FavoriteAdapterSecond

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FavoriteFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mRecyclerView: RecyclerView
    lateinit var mYouLikeBtn:TextView
    lateinit var mYoursLikeBtn:TextView

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
       var view = inflater.inflate(R.layout.fragment_favorite, container, false)
        mYouLikeBtn = view.findViewById(R.id.your_like_btn)
        mYoursLikeBtn = view.findViewById(R.id.yours_like_btn)
        mRecyclerView = view.findViewById(R.id.favorite_recycler)
        mYouLikeBtn.setBackgroundResource(R.drawable.base_background_green)
        mRecyclerView.adapter = context?.let { it1 -> FavoriteAdapter(it1) }
        mRecyclerView.layoutManager = GridLayoutManager(view.context,
            2, GridLayoutManager.VERTICAL, false)
        mYouLikeBtn.setOnClickListener{
            mYouLikeBtn.setBackgroundResource(R.drawable.base_background_green)
            mYoursLikeBtn.setBackgroundResource(R.drawable.base_background)
            mRecyclerView.adapter = context?.let { it1 -> FavoriteAdapter(it1) }

        }
        mYoursLikeBtn.setOnClickListener{
            mYoursLikeBtn.setBackgroundResource(R.drawable.base_background_green)
            mYouLikeBtn.setBackgroundResource(R.drawable.base_background)
            mRecyclerView.adapter = context?.let { it1 -> FavoriteAdapterSecond(it1) }

        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FavoriteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavoriteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}