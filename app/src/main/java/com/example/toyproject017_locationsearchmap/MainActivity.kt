package com.example.toyproject017_locationsearchmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.toyproject017_locationsearchmap.databinding.ActivityMainBinding
import com.example.toyproject017_locationsearchmap.model.LocationLatLngEntity
import com.example.toyproject017_locationsearchmap.model.SearchResultEntity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SearchRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        initViews()
        initData()
        setData()

    }

    private fun initViews() = with(binding) {
        emptyResultTextView.isVisible = false
        recyclerView.adapter = adapter
    }

    private fun initAdapter() {
        adapter = SearchRecyclerAdapter()
    }

    private fun initData(){
        adapter.notifyDataSetChanged()
    }

    private fun setData(){
        val dataList = (0..10).map{
            SearchResultEntity(
                name = "빌딩 $it",
                fullAdress = "주소 $it",
                locationLatLng = LocationLatLngEntity(
                    it.toFloat(),
                    it.toFloat()
                )
            )
        }
        adapter.setSearchResultList(dataList){
            Toast.makeText(this,"빌딩이름 : ${it.name} 주소 : ${it.fullAdress}",Toast.LENGTH_SHORT).show()

        }
    }
}