package com.example.multilinetextrecyclerviewtest

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        with(findViewById<RecyclerView>(R.id.recycler)) {
            layoutManager = LinearLayoutManager(this@MainActivity, VERTICAL, false)
            adapter = object : RecyclerView.Adapter<ViewHolder>() {
                override fun getItemCount(): Int {
                    return 3
                }


                override fun getItemViewType(position: Int): Int {
                    return position
                }

                override fun onBindViewHolder(holder: ViewHolder, position: Int) {

                }

                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                    val layout = when (viewType) {
                        0 -> R.layout.item_first
                        1 -> R.layout.item_second
                        2 -> R.layout.item_third
                        else -> throw AssertionError()
                    }
                    return object : ViewHolder(layoutInflater.inflate(layout, parent, false)) {}
                }
            }
        }
    }
}
