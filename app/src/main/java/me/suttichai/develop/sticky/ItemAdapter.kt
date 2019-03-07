package me.suttichai.develop.sticky

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.suttichai.develop.sticky.model.Body
import me.suttichai.develop.sticky.model.Header

class ItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), StickyHeaderListener {
    var items: MutableList<Item<*>>? = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER_TYPE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.header_item_layout, parent, false)
                HeaderViewHolder(view)
            }
            BODY_TYPE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.body_item_layout, parent, false)
                BodyViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.unknown_litem_layout, parent, false)
                UnknownViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)

        if (holder is HeaderViewHolder) {
            holder.bind(item?.data as? Header)
        } else if (holder is BodyViewHolder) {
            holder.bind(item?.data as? Body)
        }
    }

    private fun getItem(position: Int): Item<*>? {
        return items?.get(position)
    }

    override fun getItemViewType(position: Int): Int {
        return items?.get(position)?.type ?: UNKNOWN_TYPE
    }

    override fun getPosition(position: Int): Int {
        var itemPosition = position
        var headerPosition = 0
        do {
            if (this.isHeader(itemPosition)) {
                headerPosition = itemPosition
                break
            }
            itemPosition -= 1
        } while (itemPosition >= 0)
        return headerPosition
    }

    override fun getLayout(): Int {
        return R.layout.header_item_layout
    }

    override fun bind(header: View, position: Int) {
        val tvHeader: TextView = header.findViewById(R.id.tvHeader)
        val tvSection: TextView = header.findViewById(R.id.tvSection)
        val item = getItem(position)?.data as? Header

        if (item != null) {
            tvHeader.text = item.title
            tvSection.text = item.section
        }
    }

    override fun isHeader(position: Int): Boolean {
        return getItem(position)?.type == HEADER_TYPE
    }
}