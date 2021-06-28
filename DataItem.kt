package com.example.passingjson_sitianandita.model

import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName
import java.sql.RowId

data class DataItem(
    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("first_name")
    val firstName: String? = null,

    @field:SerializedName("last_name")
    val lastName: String? = null,

    @field:SerializedName("avatar")
    val avatar: String? = null

)