package me.suttichai.develop.sticky

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val headers = mock()
        val items = convertItemByHeaders(headers)

        val adapter = ItemAdapter()
        adapter.items = items
        rvItem.layoutManager = LinearLayoutManager(this)
        rvItem.adapter = adapter
        rvItem.addItemDecoration(StickyHeaderHelper(adapter))
    }
}