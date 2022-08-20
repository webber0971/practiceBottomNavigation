package com.example.bottomnavigationdemo

import android.animation.ObjectAnimator
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.viewModelScope
import kotlin.random.Random

class ThirdFragment : Fragment() {

    companion object {
        fun newInstance() = ThirdFragment()
    }

    private lateinit var viewModel: ThirdViewModel
    private lateinit var imageView:ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view=inflater.inflate(R.layout.fragment_third, container, false)
        imageView=view.findViewById(R.id.imageView)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThirdViewModel::class.java)
        val objectAnimator:ObjectAnimator=ObjectAnimator.ofFloat(imageView,"x",0f,0f)
        objectAnimator.duration=500
        imageView.x=viewModel.dx
        if(!objectAnimator.isRunning){
            imageView.setOnClickListener() {
                val direction : Boolean =Random.nextBoolean()
                val dx :Float
                if(direction){
                    dx=100f
                }else {
                    dx=-100f
                }
                objectAnimator.setFloatValues(imageView.x,imageView.x+dx)
                viewModel.dx=viewModel.dx+dx
                objectAnimator.start()
            }
        }
    }

}