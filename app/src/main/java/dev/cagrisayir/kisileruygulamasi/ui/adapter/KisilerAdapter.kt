package dev.cagrisayir.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import dev.cagrisayir.kisileruygulamasi.data.entity.Kisiler
import dev.cagrisayir.kisileruygulamasi.databinding.CardTasarimBinding
import dev.cagrisayir.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections

class KisilerAdapter(var mContext: Context, var kisilerListesi: List<Kisiler>): RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi[position]
        val t = holder.tasarim

        t.textViewKisiAd.text = kisi.kisi_ad
        t.textViewKisiTel.text = kisi.kisi_tel

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.silImage.setOnClickListener {
            Snackbar.make(it, "${kisi.kisi_ad} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("Evet") {
                    sil(kisi.kisi_id)
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

    private fun sil(kisi_id: Int) {
        Log.e("Kisi sil", kisi_id.toString())
    }
}