package com.example.kotlinfunctions.util

import android.content.Context
import android.widget.Toast

/* Kotlin extension functions allow a developer to “add”
    methods to a class without inheriting it or using a design pattern
     */
fun Context.toast(message: CharSequence) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
