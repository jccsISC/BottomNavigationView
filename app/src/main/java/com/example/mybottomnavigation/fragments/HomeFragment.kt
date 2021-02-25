package com.example.mybottomnavigation.fragments

import android.os.Bundle
import android.view.Display
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mybottomnavigation.ModulesAdapter
import com.example.mybottomnavigation.R
import com.example.mybottomnavigation.databinding.FragmentHomeBinding
import com.example.mybottomnavigation.model.MyModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var mBinding: FragmentHomeBinding
    lateinit var adapter: ModulesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding = FragmentHomeBinding.bind(view)
        super.onViewCreated(mBinding.root, savedInstanceState)

        mBinding.apply {
            adapter = ModulesAdapter(requireContext())
//
//            val listModules = arrayListOf<MyModel>(
//                    MyModel("1", "imagen", "Nuevo texgto"),
//                    MyModel("2", "imagen", "Nuevo texgto"),
//                    MyModel("3", "imagen", "Nuevo texgto"),
//                    MyModel("4", "imagen", "Nuevo texgto"),
//                    MyModel("4", "imagen", "Nuevo texgto"),
//                    MyModel("4", "imagen", "Nuevo texgto"),
//                    MyModel("4", "imagen", "Nuevo texgto"),
//                    MyModel("5", "imagen", "Nuevo texgto")
//
//            )
//
//            rvHome.adapter = adapter
//            adapter.submitList(listModules)
//            adapter.notifyDataSetChanged()
        }


        adapter.onItemClickListener = {
            Toast.makeText(context, "Click ${it.text}", Toast.LENGTH_SHORT).show()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}