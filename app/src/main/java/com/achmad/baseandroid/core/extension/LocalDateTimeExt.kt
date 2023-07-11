package com.achmad.baseandroid.core.extension

import kotlinx.datetime.LocalDate

fun LocalDate.toStringWithFormat() {
    this.toEpochDays()
}
