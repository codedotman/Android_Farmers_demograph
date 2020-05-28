package com.e.farmersdemograph.views.addFarmer

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.core.os.bundleOf
import androidx.navigation.Navigation

import com.e.farmersdemograph.R
import com.e.farmersdemograph.views.addFarmer.AddFarmerLocationFragment.Companion.FARMERS_ACCOUNT
import com.e.farmersdemograph.views.addFarmer.AddFarmerLocationFragment.Companion.FARMERS_AGE
import com.e.farmersdemograph.views.addFarmer.AddFarmerLocationFragment.Companion.FARMERS_IMG
import com.e.farmersdemograph.views.addFarmer.AddFarmerLocationFragment.Companion.FARMERS_NAME
import com.e.farmersdemograph.views.addFarmer.AddFarmerLocationFragment.Companion.FARMERS_PHONE
import com.e.farmersdemograph.views.addFarmer.AddFarmerLocationFragment.Companion.FARM_LOCATION
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_add_farmer.*
import kotlinx.android.synthetic.main.fragment_login.*
import java.io.ByteArrayOutputStream

/**
 * A simple [Fragment] subclass.
 */
class AddFarmerFragment : Fragment() {

    private lateinit var farmersImage: Bitmap
    val CAMERA_REQUEST_CODE=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_farmer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ll_item_1.setOnClickListener { capturePicture() }


        registerbtn.setOnClickListener {
            val name: String = nameField.text.toString()
            val age: String = ageField.text.toString()
            val address: String = addressField.text.toString()
            val phone: String = phoneField.text.toString()
            val account: String = accountField.text.toString()

            if(name.isEmpty() || age.isEmpty() || address.isEmpty() || phone.isEmpty() || account.isEmpty()){
                Snackbar.make(login_root, "Input missing field", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(resources.getColor(R.color.colorPrimary))
                    .show()

            }else{
                val bundle = bundleOf()
                bundle.apply {
                    putString(FARMERS_NAME, name)
                    putString(FARMERS_AGE, age)
                    putString(FARMERS_IMG, encodeImage(farmersImage))
                    putString(FARMERS_PHONE, phone)
                    putString(FARM_LOCATION, address)
                    putString(FARMERS_ACCOUNT, account)


                    val navController = Navigation.findNavController(requireActivity(), R.id.my_nav_host_fragment)
                    navController.navigate(R.id.action_addFarmerFragment_to_addFarmerLocationFragment, bundle)

                }

            }
        }

    }

    private fun capturePicture() {
        val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if(callCameraIntent.resolveActivity(requireActivity().packageManager)!=null){
            startActivityForResult(callCameraIntent,CAMERA_REQUEST_CODE)
        }

    }

    private fun encodeImage(bm: Bitmap): String? {
        val baos = ByteArrayOutputStream()
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val b = baos.toByteArray()
        return Base64.encodeToString(b, Base64.DEFAULT)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    farmersImage = data.extras?.get("data") as Bitmap
                    val drawable: RoundedBitmapDrawable = RoundedBitmapDrawableFactory.create(resources, farmersImage)
                    drawable.isCircular = true
                    uploadedImage.setImageDrawable(drawable);


                }
            }
            else -> {
            }

        }
    }

}
