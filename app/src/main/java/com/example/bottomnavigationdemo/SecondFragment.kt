package com.example.bottomnavigationdemo

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class SecondFragment : Fragment() {

    companion object {
        fun newInstance() = SecondFragment()
    }

    private lateinit var viewModel: SecondViewModel
    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view=inflater.inflate(R.layout.fragment_second, container, false)
        imageView=view.findViewById(R.id.imageView)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)

        val objectAnimatorX:ObjectAnimator=ObjectAnimator.ofFloat(imageView,"ScaleX",0f,0f)
        val objectAnimatorY:ObjectAnimator=ObjectAnimator.ofFloat(imageView,"ScaleY",0f,0f)
        val setObjectAnimator : AnimatorSet=AnimatorSet()
        val list : Array<ObjectAnimator> = arrayOf(objectAnimatorX,objectAnimatorY)
        setObjectAnimator.childAnimations.addAll(list)
//        setObjectAnimator.playTogether()
        imageView.scaleX=viewModel.scaleFactor
        imageView.scaleY=viewModel.scaleFactor
        setObjectAnimator.duration=500
        imageView.setOnClickListener(){
            if(!objectAnimatorX.isRunning){
                objectAnimatorX.setFloatValues(imageView.scaleX+0.1f)
                objectAnimatorY.setFloatValues(imageView.scaleY+0.1f)
                viewModel.scaleFactor=viewModel.scaleFactor+0.1f
                objectAnimatorX.start()
                objectAnimatorY.start()
                println("----")
            }
        }
    }

}