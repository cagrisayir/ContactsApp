package dev.cagrisayir.kisileruygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import dev.cagrisayir.kisileruygulamasi.R
import dev.cagrisayir.kisileruygulamasi.data.entity.Kisiler
import dev.cagrisayir.kisileruygulamasi.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
        binding.toolbarAnasayfa.title = "Anasayfa"
        binding.toolbarAnasayfa.setTitleTextColor(getResources().getColor(R.color.white))
        binding.fab.setOnClickListener {
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.kisiKayitGecis)
        }

        binding.buttonDetay.setOnClickListener {
            val kisi = Kisiler(1, "Ahmet", "1111")
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        return binding.root
    }

}