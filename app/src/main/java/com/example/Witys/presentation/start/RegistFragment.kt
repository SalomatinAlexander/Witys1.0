package com.example.Witys.presentation.start

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.Witys.R
import com.example.Witys.presentation.profil.ProfilActivity
import com.example.Witys.presentation.start.forgotpass.ForgetPassFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mEnterBtn:Button
    lateinit var mUnknownBtn:Button
    lateinit var mRegistBtn:Button
    lateinit var mLoginEdit:EditText
    lateinit var mPassEdit:EditText

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
        var view  = inflater.inflate(R.layout.fragment_regist, container, false)
        mLoginEdit = view.findViewById(R.id.login_edit_reg)
        mPassEdit = view.findViewById(R.id.pass_edit_reg)
        mEnterBtn = view.findViewById(R.id.enter_btn_reg)
        mUnknownBtn = view.findViewById(R.id.unknow_btn_reg)
        mRegistBtn = view.findViewById(R.id.registration_btn_reg)
        mEnterBtn.setOnClickListener {
            //  if (mLoginEdit.text.length > 1 && mPassEdit.text.length == 1){
            var intent = Intent(view.context, ProfilActivity::class.java)
            view.context.startActivity(intent)
            // }
            /*
            else{
                Toast.makeText(view.context,
                    "Логин либо телефон введены неверно",
                    Toast.LENGTH_LONG).show()
           }
        }
             */
        }
        mUnknownBtn = view.findViewById(R.id.unknow_btn_reg)
        mUnknownBtn.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_layout, ForgetPassFragment())
                .addToBackStack("regist")
                .commit()

        }
        mRegistBtn.setOnClickListener{
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_layout, NewUserFragment())
                .addToBackStack("regist")
                .commit()
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
         * @return A new instance of fragment RegistFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}