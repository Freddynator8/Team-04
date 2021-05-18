package com.example.traveltogether

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView


class ChatHelperAdapter(var context: Context,var arrayList: ArrayList<String>, var fragment: Fragment) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false)
        val viewHolderClass = ViewHolderClass(view)
        Log.d("Fuck","On Create View Holder")
        viewHolderClass.itemView.setOnClickListener {
            Toast.makeText(context, arrayList[viewHolderClass.adapterPosition],Toast.LENGTH_SHORT).show()
            val args = chat_fragmentDirections.actionChatFragmentToConversationFragment("TEST")
            fragment.findNavController().navigate(args)
        }

        return viewHolderClass;
    }

    override fun onBindViewHolder(@NonNull holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolderClass: ViewHolderClass = holder as ViewHolderClass
        Log.d("Fuck",arrayList[position])
        viewHolderClass.textView.text = arrayList[position]
    }

    override fun getItemCount(): Int{
        return arrayList.size;
    }
    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textView: TextView

        init {
            Log.d("Fuck", "Bin im ViewHolderClass Constructer")
            textView = itemView.findViewById(R.id.chat_item_text_view)
        }
    }

}