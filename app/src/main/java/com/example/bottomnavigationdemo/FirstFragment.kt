package com.example.bottomnavigationdemo

import android.animation.ObjectAnimator
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class FirstFragment : Fragment() {


    companion object {
        fun newInstance() = FirstFragment()
    }

    private lateinit var viewModel: FirstViewModel
    private lateinit var imageView: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_frist, container, false)
        imageView = view.findViewById(R.id.imageView)
        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(FirstViewModel::class.java)
        imageView.rotation=viewModel.rotationPosition
        println(imageView.rotation)
        val objectAnimator:ObjectAnimator=ObjectAnimator.ofFloat(imageView,"rotation",0f,0f)
        objectAnimator.duration=500
        imageView.setOnClickListener(){
            if(!objectAnimator.isRunning) {
                objectAnimator.setFloatValues(imageView.rotation, imageView.rotation + 100)
                viewModel.rotationPosition=imageView.rotation+100
                println(viewModel.rotationPosition)
                objectAnimator.start()
            }
        }
    }

}