package dev.cagrisayir.kisileruygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.cagrisayir.kisileruygulamasi.databinding.FragmentKisiDetayBinding

class KisiDetayFragment : Fragment() {
    private lateinit var binding: FragmentKisiDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentKisiDetayBinding.inflate(inflater, container, false)
        return binding.root
    }
}