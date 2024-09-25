package com.example.kotlinfunctions
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinfunctions.util.loadImage
import com.example.kotlinfunctions.util.toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lambda
        Util.callLambda()

        // Higher Order Function
        Util.callHigherOrderFunction()

        // Extension Function
        toast("Hello Extension Function")
        val imageview = ImageView(this)
        imageview.loadImage(R.drawable.ic_launcher_background)

        // Inline Function
        Util.callInLineFunction()

        // Filters
        Util.callFilter()
    }
}