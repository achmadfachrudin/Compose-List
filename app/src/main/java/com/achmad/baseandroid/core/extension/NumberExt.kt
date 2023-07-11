package com.achmad.baseandroid.core.extension

fun Number?.orZero(): Number {
    return this ?: 0
}
