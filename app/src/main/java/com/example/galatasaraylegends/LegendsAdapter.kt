package com.example.galatasaraylegends

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class LegendsAdapter(private val listoflegends:ArrayList<LegendsData>) :
    RecyclerView.Adapter<LegendsAdapter.MyviewHolder>() {

     private lateinit var mListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val create = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyviewHolder(create, mListener)
    }

    override fun getItemCount(): Int {
        return listoflegends.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val currentitem = listoflegends[position]
        holder.shapeLegens.setImageResource(currentitem.imageid)
        holder.buttonLegens.text = currentitem.heading

    }

    class MyviewHolder(itemview: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemview){
    var shapeLegens : ShapeableImageView = itemview.findViewById(R.id.shapeablelistitem)
    var buttonLegens : TextView = itemview.findViewById(R.id.textviewlistitem)

        init {
            itemview.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

}