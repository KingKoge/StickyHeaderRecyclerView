package me.suttichai.develop.sticky

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.suttichai.develop.sticky.model.Body

class BodyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvBody: TextView = itemView.findViewById(R.id.tvBody)

    fun bind(body: Body?) {
        if (body != null) {
            tvBody.text = body.title
        }
    }
}