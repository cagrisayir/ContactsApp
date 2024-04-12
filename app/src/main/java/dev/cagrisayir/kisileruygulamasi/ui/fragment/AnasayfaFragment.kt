package dev.cagrisayir.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dev.cagrisayir.kisileruygulamasi.R
import dev.cagrisayir.kisileruygulamasi.data.entity.Kisiler
import dev.cagrisayir.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import dev.cagrisayir.kisileruygulamasi.ui.adapter.KisilerAdapter

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

        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1, "Ahmet", "11111")
        val k2 = Kisiler(2, "Ayse", "22222")
        val k3 = Kisiler(3, "Omer", "333333")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)

        val kisilerAdapter = KisilerAdapter(requireContext(), kisilerListesi)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.adapter = kisilerAdapter

        binding.fab.setOnClickListener {
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.kisiKayitGecis)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
                return true
            }
        })

        return binding.root
    }

    private fun ara(aramaKelimesi: String) {
        Log.e("Kisi ara", aramaKelimesi)
    }

}