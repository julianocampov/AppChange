package com.jovel.appchange

import android.util.Patterns

fun emailValidator(text: String): Boolean {
    val pattern = Patterns.EMAIL_ADDRESS
    return pattern.matcher(text).matches()
}

fun lengthString(text: String, n: Int): Boolean {
    return text.length >= n
}

fun compareStrings(text1: String, text2: String): Boolean {
    return text1==text2
}
