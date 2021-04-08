package com.example.agrochemoverview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agrochemoverview.realm.yakuzai_DB
import com.example.agrochemoverview.recyclerview.rvAdapter
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment:Fragment() {

    private lateinit var realm: Realm

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        realm = Realm.getDefaultInstance()
        doQuery("") //デフォルト検索
        Log.d("doQuery","Do query All")


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextChange(newText: String):Boolean {
                doQuery(newText)
                Log.d("doQuery","Do query each word")
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    private fun doQuery(inputText:String) {

        val exact = realm.where(yakuzai_DB::class.java)
            .beginsWith("name", inputText)
            .findAll()

        viewManager = LinearLayoutManager(activity)
        viewAdapter = rvAdapter(exact)

        recyclerView = my_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }


}