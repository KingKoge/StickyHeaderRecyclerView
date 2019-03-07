package me.suttichai.develop.sticky

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.suttichai.develop.sticky.model.Header

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvHeader: TextView = itemView.findViewById(R.id.tvHeader)
    var tvSection: TextView = itemView.findViewById(R.id.tvSection)

    fun bind(header: Header?) {
        if (header != null) {
            tvHeader.text = header.title
            tvSection.text = header.section
        }
    }
}