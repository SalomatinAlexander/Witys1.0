package com.example.Witys.presentation.profil.message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Witys.R
import com.example.Witys.domain.CommunicationAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CommunicationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommunicationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var recycler:RecyclerView
    lateinit var btnSend:ImageButton
    lateinit var txtMsg:EditText
    lateinit var txtName:TextView
    lateinit var txtPersonMsg:TextView
    lateinit var list:ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_communication,
            container, false)
        var list_values = requireArguments().getStringArray("MESSAGE")
        txtName = view.findViewById(R.id.comm_name_txt)
        txtPersonMsg = view.findViewById(R.id.message_item_from_person_id)
        txtName.setText(list_values?.get(1)?.toString())
        txtPersonMsg.setText(list_values?.get(0)?.toString())


         recycler = view.findViewById(R.id.communication_recycler_id)
        btnSend = view.findViewById(R.id.com_message_btn)
        txtMsg = view.findViewById(R.id.com_message_txt)
        btnSend.setOnClickListener{
           if(!txtMsg.text.isNullOrEmpty()) {list.add(txtMsg.text.toString())}
            recycler.adapter = CommunicationAdapter(list)
            txtMsg.setText(" ")
        }
        list = ArrayList()
        recycler.adapter = CommunicationAdapter(list)
        recycler.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL, false)
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CommunicationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                CommunicationFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}