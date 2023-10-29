package com.myapp.cuniwarts.features.housepointscalculator.presentation.globalview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.myapp.cuniwarts.R

class GlobalFragment : Fragment() {

    companion object {
        fun newInstance() = GlobalFragment()
    }

    private lateinit var viewModel: GlobalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_global, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GlobalViewModel::class.java)
        // TODO: Use the ViewModel
    }

}