package com.retrofit.shreyas.firstkotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val initialTextViewTransitionY = textView_progress.translationY
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                     textView_progress.text = progress.toString()
                      val translationDistance =(initialTextViewTransitionY +
                        progress * resources.getDimension(R.dimen.text_anim_step)* -1)

                textView_progress.animate().translationY(translationDistance)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        button_reset.setOnClickListener{view ->
            seekBar.progress = 0
            textView_progress.animate().setDuration(1000).rotationBy(360f)
                    .translationY(initialTextViewTransitionY)
        }
    }
}
