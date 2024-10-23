package com.example.flagquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.flagquiz.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    lateinit var binding: FragmentTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        binding.startBtn.setOnClickListener { view:View ->
            if (binding.etName.text!!.isNotEmpty()){
                val action = TitleFragmentDirections.actionTitleFragmentToQuizFragment(binding.etName.text.toString())
                findNavController().navigate(action)
            } else{
                Toast.makeText(context, "Enter your name to start", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}