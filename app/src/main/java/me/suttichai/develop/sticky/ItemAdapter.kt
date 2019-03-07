package me.suttichai.develop.sticky

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.suttichai.develop.sticky.model.Body
import me.suttichai.develop.sticky.model.Header

class ItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
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
}