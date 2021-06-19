package com.example.Witys.presentation.profil

import android.Manifest
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import com.example.Witys.R
import com.squareup.picasso.Picasso
import java.io.FileNotFoundException
import java.lang.NullPointerException


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfilFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var changeBtn:Button
    lateinit var nameTxt:EditText
    lateinit var sonameTxt:EditText
    lateinit var heightTxt:EditText
    lateinit var langTxt:EditText
    lateinit var aboutMeTxt:EditText
    lateinit var aboutPersonTxt:EditText
    lateinit var hobbyTxt:EditText
    lateinit var photo:ImageView
    lateinit var sharedPreferences:SharedPreferences
    lateinit var photoURl: String
    lateinit var smokeBtn:TextView
    lateinit var alkoBtn:TextView
    lateinit var childrenBtn:TextView
    lateinit var PetBtn:TextView
    lateinit var bitMap:String
    private val Pick_image = 1
    var smoke = false
    var alco = false
    var child = false
    var pet = false



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
        var view  = inflater.inflate(R.layout.fragment_profil, container, false)
        sharedPreferences  = requireContext().getSharedPreferences(
                USER_NAME,
                Context.MODE_PRIVATE
        )



        nameTxt = view.findViewById(R.id.profil_name)
        sonameTxt = view.findViewById(R.id.profil_soname)
        langTxt = view.findViewById(R.id.profil_lang)
        heightTxt = view.findViewById(R.id.profil_height)
        aboutMeTxt = view.findViewById(R.id.profil_about_me)
        aboutPersonTxt = view.findViewById(R.id.profil_about_person)
        hobbyTxt = view.findViewById(R.id.profil_hobby)
        photo = view.findViewById(R.id.profil_photo)
        smokeBtn = view.findViewById(R.id.smoke_btn)
        alkoBtn = view.findViewById(R.id.alko_btn)
        childrenBtn = view.findViewById(R.id.child_btn)
        PetBtn = view.findViewById(R.id.pet_btn)

            try {
                if(!!savedInstanceState!!.getString("KEY").isNullOrEmpty() ) {
                    Picasso.get().load(savedInstanceState!!.getString("KEY")).into(photo)
                }
            }catch (e: NullPointerException){

        }

        try {
            if (ActivityCompat.checkSelfPermission(requireContext(),
                            Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(),
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE), Pick_image)
            } else {
                //   val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                //   startActivityForResult(galleryIntent, Pick_image)

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        getValue()






        smokeBtn.setOnClickListener {
            if (smoke) {
                smokeBtn.setBackgroundResource(R.drawable.base_background)
                smoke = false
            }
            else {
                smokeBtn.setBackgroundResource(R.drawable.base_background_green)
                smoke = true

            }
        }
            alkoBtn.setOnClickListener {
                if (alco) {
                    alkoBtn.setBackgroundResource(R.drawable.base_background)
                    alco = false
                }else{
                    alkoBtn.setBackgroundResource(R.drawable.base_background_green)
                    alco = true

                }
        }
        childrenBtn.setOnClickListener {
            if (child) {
                childrenBtn.setBackgroundResource(R.drawable.base_background)
                child = false
            }else{
                childrenBtn.setBackgroundResource(R.drawable.base_background_green)
                child = true

            }
        }
        PetBtn.setOnClickListener {
            if (pet) {
                PetBtn.setBackgroundResource(R.drawable.base_background)
                pet = false
            }else{
                PetBtn.setBackgroundResource(R.drawable.base_background_green)
                pet = true

            }
        }



        changeBtn = view.findViewById(R.id.change_profil_btn)
        changeBtn.setOnClickListener {
           saveValue(
                   name = nameTxt.text.toString(),
                   soname = sonameTxt.text.toString(),
                   language = langTxt.text.toString(),
                   height = heightTxt.text.toString(),
                   AboutMe = aboutMeTxt.text.toString(),
                   AboutPerson = aboutPersonTxt.text.toString(),
                   hobby = hobbyTxt.text.toString(),
                   imageUri = photoURl,
                   smoke = smoke,
                   alco = alco,
                   child = child,
                   pet = pet
           )
        }
        photo.setOnClickListener{
            var  photoPickerIntent =  Intent(Intent.ACTION_OPEN_DOCUMENT);
            //Тип получаемых объектов - image:
            photoPickerIntent.setType("image/*");
            //Запускаем переход с ожиданием обратного результата в виде информации об изображении:
            startActivityForResult(photoPickerIntent, Pick_image);
        }
        return view
    }
    fun saveValue(
            name: String, soname: String,
            language: String, height: String,
            AboutMe: String,
            AboutPerson: String, hobby: String, imageUri: String,
            smoke: Boolean, alco: Boolean,
            child: Boolean, pet: Boolean
    ){
        bitMap = photoURl

        var editor = sharedPreferences.edit()
        editor.putString(USER_NAME, name)
        editor.putString(USER_SONAME, soname)
        editor.putString(USER_LANG, language)
        editor.putString(USER_HEIGHT, height)
        editor.putString(USER_ABOUT_ME, AboutMe)
        editor.putString(USER_ABOUT_PERSON, AboutPerson)
        editor.putString(USER_HOBBY, hobby)
        editor.putString(USER_PHOTO, imageUri)
        editor.putBoolean(USER_SMOKE, smoke)
        editor.putBoolean(USER_ALKO, alco)
        editor.putBoolean(USER_CHILD, child)
        editor.putBoolean(USER_PET, pet)
        editor.apply()

    }

    fun getValue(){
       nameTxt.setText(sharedPreferences.getString(USER_NAME, "Имя").toString())
        sonameTxt.setText(sharedPreferences.getString(USER_SONAME, "Фамилия").toString())
        langTxt.setText(sharedPreferences.getString(USER_LANG, "Языки").toString())
        heightTxt.setText(sharedPreferences.getString(USER_HEIGHT, "Рост").toString())
        aboutMeTxt.setText(sharedPreferences.getString(USER_ABOUT_ME, "О себе:").toString())
        aboutPersonTxt.setText(
                sharedPreferences.getString(USER_ABOUT_PERSON, "О партнере:").toString()
        )

        photoURl = sharedPreferences.getString(USER_PHOTO, "О себе:").toString()
        println(photoURl)
        Picasso.get().load(photoURl).into(photo)
        try {

        }catch (e:NullPointerException){

        }
       // photoURl =
        //var imageStream =
        //        Uri.parse(photoURl)?.let { requireActivity().contentResolver.openInputStream(it) };
       // var selectedImage = BitmapFactory.decodeStream(imageStream);
      //  photo.setImageBitmap(selectedImage);
     //   photo.setImageURI(sharedPreferences.getString(USER_PHOTO, "О себе:") as Uri)
        hobbyTxt.setText(sharedPreferences.getString(USER_HOBBY, "Увлечения:").toString())
        smoke = sharedPreferences.getBoolean(USER_SMOKE, false)
        alco = sharedPreferences.getBoolean(USER_ALKO, false)
        child = sharedPreferences.getBoolean(USER_CHILD, false)
        pet = sharedPreferences.getBoolean(USER_PET, false)

        bitMap = photoURl
     Picasso.get().load(photoURl).into(photo)
        if (smoke) {
            smokeBtn.setBackgroundResource(R.drawable.base_background_green)
        }
        else {
            smokeBtn.setBackgroundResource(R.drawable.base_background)


        }

            if (alco) {
                alkoBtn.setBackgroundResource(R.drawable.base_background_green)

            }else{
                alkoBtn.setBackgroundResource(R.drawable.base_background)


            }


            if (child) {
                childrenBtn.setBackgroundResource(R.drawable.base_background_green)

            }else{
                childrenBtn.setBackgroundResource(R.drawable.base_background)
        }

            if (pet) {
                PetBtn.setBackgroundResource(R.drawable.base_background_green)

            }else{
                PetBtn.setBackgroundResource(R.drawable.base_background)


            }


    }


    companion object {
        val USER_NAME:String ="username"
        val USER_SONAME:String ="username1"
        val USER_LANG:String ="username2"
        val USER_HEIGHT:String ="username0"

        val USER_ABOUT_ME:String ="username3"
        val USER_ABOUT_PERSON:String ="username4"
        val USER_HOBBY:String ="username5"
        val USER_PHOTO:String ="username6"
        val USER_SMOKE:String ="username7"
        val USER_ALKO:String ="username8"
        val USER_CHILD:String ="username9"
        val USER_PET:String ="username10"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfilFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfilFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }}

override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    when (requestCode) {
        Pick_image ->
            if (resultCode == RESULT_OK) {
                try {

                    var imageUri = data!!.getData();
                    if (imageUri == null) {
                        return
                    } else {
                        photoURl = imageUri.toString()
                        var imageStream =
                                imageUri?.let { requireActivity().contentResolver.openInputStream(it) };
                        var selectedImage = BitmapFactory.decodeStream(imageStream);
                        bitMap = photoURl
                        photo.setImageBitmap(selectedImage);
                    }
                } catch (e: FileNotFoundException) {
                    e.printStackTrace();

                }
            }
    }
}

    override fun onSaveInstanceState(outState: Bundle) {
        if(photoURl != null) {
            outState.putString("KEY", photoURl)
        }
        super.onSaveInstanceState(outState)
    }
}