package com.iwrrr.reqres.repository

import com.iwrrr.reqres.data.User
import com.iwrrr.reqres.event.StateEventManager

interface UserRepository {
    val userStateEventManager: StateEventManager<List<User>>

    suspend fun getUsers(page: Int = 1)
}