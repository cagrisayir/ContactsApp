package dev.cagrisayir.kisileruygulamasi.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import dev.cagrisayir.kisileruygulamasi.databinding.FragmentKisiKayitBinding

class KisiKayitFragment : Fragment() {
    private lateinit var binding: FragmentKisiKayitBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentKisiKayitBinding.inflate(inflater, container, false)

        binding.toolbarKisiKayit.title = "Kisi Kayit"

        binding.buttonKaydet.setOnClickListener {
            val kisi_ad = binding.editTextKisiAd.text.toString()
            val kisi_tel = binding.editTextKisiTel.text.toString()
            kaydet(kisi_ad, kisi_tel)
            temizle()
            hideTheKeyboard(it)
        }

        return binding.root
    }

    private fun kaydet(kisi_ad: String, kisi_tel: String) {
        Log.e("Kisi Kaydet", "$kisi_ad - $kisi_tel")
        Toast.makeText(context, "Kisi kayit edildi: $kisi_ad", Toast.LENGTH_LONG).show()
    }

    private fun temizle() {
        binding.editTextKisiAd.setText("")
        binding.editTextKisiTel.setText("")
    }

    private fun hideTheKeyboard(view: View) {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}