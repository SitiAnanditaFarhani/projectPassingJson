package com.example.passingjson_sitianandita.network

import com.example.passingjson_sitianandita.model.ResponseUser

interface ApiService {
    //Menampilkan user dengan query
    @GET("api/users")
    fun getListUsers(@Query("page")page: String): retrofit2.Call<ResponseUser>
}
}