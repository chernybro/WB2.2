package com.chernybro.wb22

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.button.MaterialButton
import timber.log.Timber


class SecondFragment : DialogFragment() {

    companion object {
        fun newInstance()  = SecondFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("${this.javaClass.canonicalName} onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("${this.javaClass.canonicalName} onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        Timber.d("${this.javaClass.canonicalName} onCreateView")
        return inflater.inflate(R.layout.fragment_second, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("${this.javaClass.canonicalName} onViewCreated")

        view.findViewById<MaterialButton>(R.id.btn_open_dialog).setOnClickListener {
            ((activity as MainView).showFragmentDialog("Hello, World!"))
        }
    }


    override fun onStart() {
        super.onStart()
        Timber.d("${this.javaClass.canonicalName} onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("${this.javaClass.canonicalName} onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("${this.javaClass.canonicalName} onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("${this.javaClass.canonicalName} onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("${this.javaClass.canonicalName} onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("${this.javaClass.canonicalName} onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("${this.javaClass.canonicalName} onDetach")
    }
}