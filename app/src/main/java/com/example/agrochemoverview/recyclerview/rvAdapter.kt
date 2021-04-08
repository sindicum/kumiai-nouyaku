package com.example.agrochemoverview.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.agrochemoverview.MainFragment
import com.example.agrochemoverview.MainFragmentDirections
import com.example.agrochemoverview.R
import com.example.agrochemoverview.realm.yakuzai_DB
import io.realm.RealmResults

class rvAdapter (realmResults: RealmResults<yakuzai_DB>): RecyclerView.Adapter<ViewHolder>() {

    val rResults = realmResults

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout,parent,false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return rResults.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val oneData = rResults[position]
        holder.nameText?.text = oneData?.name.toString()
        holder.pathText?.text = oneData?.path.toString()

        //　アクティビティへの遷移
        holder.itemView.setOnClickListener{

            val sendValue = oneData?.path.toString()
            val action = MainFragmentDirections.actionMainFragmentToPdfFragment(sendValue)
            it.findNavController().navigate(action)
        }

    }
}