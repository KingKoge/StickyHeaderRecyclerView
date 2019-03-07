package me.suttichai.develop.sticky

import android.view.View

interface StickyHeaderListener {

    fun getPosition(position: Int): Int

    fun getLayout(): Int

    fun bind(header: View, position: Int)

    fun isHeader(position: Int): Boolean
}