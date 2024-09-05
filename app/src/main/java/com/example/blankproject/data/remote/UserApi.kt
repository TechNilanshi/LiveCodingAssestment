package com.example.blankproject.data.remote

import com.example.blankproject.data.model.UserListData
import retrofit2.http.GET

//https://jsonplaceholder.typicode.com/posts
interface UserApi {
    @GET("posts")
    fun userListData() : List<UserListData>

}


