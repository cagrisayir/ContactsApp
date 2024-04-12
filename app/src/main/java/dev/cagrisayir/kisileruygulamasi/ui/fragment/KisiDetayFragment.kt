package dev.cagrisayir.kisileruygulamasi.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import dev.cagrisayir.kisileruygulamasi.R
import dev.cagrisayir.kisileruygulamasi.databinding.FragmentKisiDetayBinding

class KisiDetayFragment : Fragment() {
    private lateinit var binding: FragmentKisiDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentKisiDetayBinding.inflate(inflater, container, false)

        binding.toolbarKisiDetay.title = "Kisi Detay"
        binding.toolbarKisiDetay.setTitleTextColor(getResources().getColor(R.color.white))

        val bundle: KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi

        binding.kisiAdText.setText(gelenKisi.kisi_ad)
        binding.kisiTelText.setText(gelenKisi.kisi_tel)

        binding.buttonGuncelle.setOnClickListener {
            val kisi_ad = binding.kisiAdText.text.toString()
            val kisi_tel = binding.kisiTelText.text.toString()
            guncelle(kisi_id = gelenKisi.kisi_id, kisi_ad = kisi_ad, kisi_tel = kisi_tel)
            hideTheKeyboard(it)
        }

        binding.geributton.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }

        return binding.root
    }

    private fun guncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        Log.e("Kisi Guncellendi", "$kisi_ad - $kisi_tel")
        Toast.makeText(context, "Kisi Guncellendi: $kisi_id: $kisi_ad", Toast.LENGTH_LONG).show()
    }

    private fun hideTheKeyboard(view: View) {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}