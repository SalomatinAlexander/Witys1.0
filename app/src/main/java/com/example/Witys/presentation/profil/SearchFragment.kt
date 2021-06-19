package com.example.Witys.presentation.profil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.Witys.R
import com.example.Witys.data.CustomLineralLayout
import com.example.Witys.domain.SearchAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SearchFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mSearchRecycler:RecyclerView
    lateinit var mPositiveBtn:ImageView
    lateinit var mNegativeBtn:ImageView

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
        var view = inflater.inflate(R.layout.fragment_search, container, false)
        mPositiveBtn = view.findViewById(R.id.positive_btn_search)
        mNegativeBtn = view.findViewById(R.id.negative_btn_search)

        mSearchRecycler = view.findViewById(R.id.recycler_search)
        mSearchRecycler.stopScroll()
        var layoutManager = CustomLineralLayout(view.context, false)
        mSearchRecycler.layoutManager = layoutManager
        var myAdapter = SearchAdapter()
        mSearchRecycler.adapter = myAdapter
        var position = myAdapter.getPosition()
        mPositiveBtn.setOnClickListener{
            println(myAdapter.getPosition()+1)

           // mSearchRecycler.layoutManager = CustomLineralLayout(view.context, true)
            if (layoutManager.findLastCompletelyVisibleItemPosition() <( myAdapter.itemCount - 1)) {
                layoutManager.scrollToPosition(layoutManager.findLastCompletelyVisibleItemPosition() + 1);
            }
            //пролистывается нормально просто не меняются элементы
         //   mSearchRecycler.layoutManager = CustomLineralLayout(view.context, false)
            }
        mNegativeBtn.setOnClickListener{
            if (layoutManager.findLastCompletelyVisibleItemPosition() <( myAdapter.itemCount - 1)) {
                layoutManager.scrollToPosition(layoutManager.findLastCompletelyVisibleItemPosition() + 1);
            }

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
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}