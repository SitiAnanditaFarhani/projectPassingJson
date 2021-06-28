package com.example.passingjson_sitianandita

import android.app.VoiceInteractor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.passingjson_sitianandita.model.DataItem
import java.nio.file.attribute.UserPrincipalLookupService

class UserAdapter (private val  users: MutableList<DataItem>):
    RecyclerView.Adapter<UserAdapter.ListViewHolder> (){

    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): ListViewHolder{
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_user,parent, false)
        return ListViewHolder(
            view
        )
    }

    fun  addUser(newUser:DataItem) {
        users.add(newUser)
        notifyItemInserted(users.lastIndex)
    }

    fun clear (){
        users.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserAdapter.ListViewHolder, position: Int) {
        val user = users{position}

        Glide.with(holder.itemView.context)
                .load(user.avatar)
                .apply(RequestOptions().override(,80,80).placeholder(R.drawable.icon_avatar))
                .transform(CircleCrop())
                .into(holder.tvAvatar)

        holder.tvUserName,text= "${user.firstname}${user.lastname}"
        holder.tvEmail.text = user.email
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvUserName: TextView = itemView.findViewById(R.id.itemName)
        var tvEmail: TextView = itemView.findViewById(R.id.itemEmail)
        var tvAvatar: TextView = itemView.findViewById(R.id.itemAvatar)
    }

}