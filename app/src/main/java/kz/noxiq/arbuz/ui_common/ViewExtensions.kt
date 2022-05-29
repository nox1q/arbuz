package kz.noxiq.arbuz.ui_common

import android.view.View

fun View.setVisibility(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}