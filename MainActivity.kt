package com.example.passingjson_sitianandita

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.passingjson_sitianandita.model.DataItem
import com.example.passingjson_sitianandita.model.ResponseUser
import com.example.passingjson_sitianandita.network.ApiConfig
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response

class MainActivity: AppCompatActivity{
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = UserAdapter(mutableListOf())

        rv_users.setHasFixedSize(true)
        rv_users.layoutManager = LinearLayoutManager(this)
        rv_users.adapter = adapter
        getUser()
    }

    private fun getUser() {
        val client = ApiConfig.getApiService().getListUsers("1")

        client.enqueue(object :retrofit2.Callback<ResponseUser>){
            override fun onResponse(call: retrofit2.Call<ResponseUser>,response: retrofit2.Response<ResponseUser>){
                if (response.isSuccessful){
                    val responese = null,
                    val dataArray = responese.body()?.data as List<DataItem>
                    for (data in dataArray){
                        adapter.addUser(data)
                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<ResponseUser>, t: Throwable){
                val message = null
                Toast.makeText(this@MainActivity, t, message, Toast.LENGTH_SHORT).show
                t, printStackTrace()
            }
        })


    }
}