package com.achmad.baseandroid.core.extension

import android.util.Patterns

fun String.sanitizedPhone(): String {
    return this.trim().filter { it.isDigit() }.take(15)
}

fun String.sanitizedEmail(): String {
    return this.trim().replace("/\t", "").replace("/\n", "")
}

fun String.isValidPhone(): Boolean {
    return this.trim().isNotEmpty()
}

fun String.isValidFullName(): Boolean {
    return this.trim().isNotEmpty()
}

fun String.isValidEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this.trim()).matches()
}

fun String.isValidPassword(): Boolean {
    val password = this.trim()
    return password.length >= 8 &&
        password.firstOrNull { it.isDigit() } != null &&
        password.filter { it.isLetter() }.firstOrNull { it.isUpperCase() } != null &&
        password.filter { it.isLetter() }.firstOrNull { it.isLowerCase() } != null &&
        password.firstOrNull { !it.isLetterOrDigit() } != null
}
