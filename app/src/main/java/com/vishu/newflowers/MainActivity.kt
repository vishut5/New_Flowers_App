package com.vishu.newflowers
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), FlowerAdapter.OnFlowerClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var flowerAdapter: FlowerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        flowerAdapter = FlowerAdapter(emptyList(), this)
        recyclerView.adapter = flowerAdapter

        fetchData()
    }

    private fun fetchData() {
        val gson = GsonBuilder().create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://mocki.io/v1/") // Replace with your actual API base URL
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val flowerApi = retrofit.create(FlowerApi::class.java)

        flowerApi.getFlowers().enqueue(object : Callback<List<Flower>> {
            override fun onResponse(call: Call<List<Flower>>, response: Response<List<Flower>>) {
                if (response.isSuccessful) {
                    val flowers = response.body() ?: emptyList()
                    flowerAdapter = FlowerAdapter(flowers, this@MainActivity)
                    recyclerView.adapter = flowerAdapter
                }
            }

            override fun onFailure(call: Call<List<Flower>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    override fun onFlowerClick(flower: Flower) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra("flower", flower)
        }
        startActivity(intent)
    }
}
